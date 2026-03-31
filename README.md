# Raken App - Test Automation Framework

A production-grade test automation framework for [Raken](https://www.rakenapp.com), the cloud-based construction collaboration platform. This project covers **web UI**, **iOS mobile**, and integrates **AI-powered failure analysis** to accelerate root cause triage.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Build | Maven 3+ |
| Web Automation | Selenium WebDriver 4.37 |
| Mobile Automation | Appium Java Client 10 (XCUITest) |
| Test Runner | TestNG 7.10 + Cucumber 7.34 (BDD) |
| Driver Management | WebDriverManager 5.5.3 |
| CI/CD | Jenkins (Declarative Pipeline) |
| AI Triage | Groq API (LLaMA 3.3 70B) via OkHttp |
| Reporting | Cucumber HTML/JSON + screenshot-on-failure |

---

## Architecture

```
src/test/
├── java/
│   ├── hooks/              # Cucumber lifecycle (@Before, @After, @AfterStep)
│   ├── listeners/          # TestNG listeners (AIFailureListener)
│   ├── pages/
│   │   ├── web/            # Page Objects: BasePage, BannerPage, DemoPage
│   │   └── mobile/
│   │       ├── ios/        # iOS Page Objects: RakenMobilePage, FreeTrialPage
│   │       └── android/    # (Planned)
│   ├── runners/            # MainRunner (Cucumber + TestNG)
│   ├── stepsDefinitions/
│   │   ├── web/            # Web step definitions
│   │   └── mobile/         # Mobile step definitions
│   └── utils/              # DriverFactory, ConfigManager, AiAnalyzer
└── resources/
    ├── config.properties   # Environment & device configuration
    └── features/           # Gherkin feature files
```

### Design Patterns

- **Page Object Model** - All page classes extend `BasePage`, which initializes `WebDriver` and `WebDriverWait` from a central `DriverFactory`.
- **ThreadLocal Driver Management** - `DriverFactory` uses `ThreadLocal<WebDriver>` for parallel-safe execution across threads.
- **BDD with Cucumber** - Feature files use Gherkin syntax with Background sections and tag-based filtering (`@regression`, `@negative`, `@ios`, `@mobile`).
- **Configuration Driven** - `ConfigManager` reads from `config.properties` to centralize browser type, base URLs, timeouts, and Appium device settings.
- **AI-Powered Failure Triage** - `AIFailureListener` (TestNG `ITestListener`) intercepts failures at runtime and sends test context to the Groq API for automated root cause analysis.

---

## Test Coverage

### Web - Trial Banner Flow (`@trial-banner`)
End-to-end validation of the trial signup banner form, including first name, last name, email, phone, company name, company size dropdown, calendar date/time selection, and confirmation messaging. Tests run with both randomized unique data and hardcoded real data.

### Web - Demo Button Flow (`@demo-button`)
Validates navigation to the request-demo page, multi-step form submission, and negative testing for invalid email input with error message verification.

### iOS Mobile - Free Trial (`@ios @mobile`)
Native iOS app testing via Appium/XCUITest on a real device. Covers launching the app, navigating to the free trial screen, completing the signup form using accessibility ID locators, and verifying the email confirmation screen.

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Chrome (or Firefox/Edge/Safari) for web tests
- Xcode + Appium Server for iOS tests
- A [Groq API key](https://console.groq.com/) for AI failure analysis

### Configuration

Edit `src/test/resources/config.properties`:

```properties
browser=chrome
base.url=https://www.rakenapp.com
explicit.wait=15

# iOS (Appium)
device.name=iPhone
platform.version=26.2.1
udid=YOUR_DEVICE_UDID
bundle.id=com.raken.Raken
appium.server=http://127.0.0.1:4723
```

Set the Groq API key as an environment variable:

```bash
export GROQ_API_KEY=your_api_key_here
```

### Running Tests

```bash
# Run all tests (default tag in MainRunner)
mvn clean test

# Run by tag
mvn test -Dcucumber.filter.tags="@regression"
mvn test -Dcucumber.filter.tags="@negative"
mvn test -Dcucumber.filter.tags="@ios"

# Specify browser
mvn test -Dbrowser=firefox
```

### Reports

After execution, reports are generated at:

- **HTML Report** - `target/cucumber.html`
- **JSON Report** - `target/cucumber.json`
- **Screenshots** - Automatically attached to the Cucumber report on step failure

---

## AI Failure Analysis

When a test fails, the `AIFailureListener` automatically sends the test name, error message, and stack trace to the Groq API. The AI returns:

1. **Root cause** in 1-2 sentences
2. **Likely fix** as actionable bullet points
3. **Prevention tip** to avoid recurrence

Output appears in the console under the `AI FAILURE ANALYSIS` header immediately after the failure, enabling faster triage without manual log reading.

---

## CI/CD

The included `Jenkinsfile` defines a declarative pipeline with four stages:

1. **Checkout** - Pulls the latest code from SCM
2. **Build** - `mvn clean compile`
3. **Test** - `mvn test -Dbrowser=chrome -Denv=prod`
4. **Publish Report** - Publishes the Cucumber HTML report via Jenkins

---

## Supported Browsers & Platforms

| Platform | Driver | Status |
|---|---|---|
| Chrome | ChromeDriver (via WebDriverManager) | Active |
| Firefox | GeckoDriver (via WebDriverManager) | Active |
| Edge | EdgeDriver (via WebDriverManager) | Active |
| Safari | SafariDriver | Active |
| iOS | Appium XCUITest | Active |
| Android | Appium UiAutomator2 | Planned |

---

## Built With

- [Selenium WebDriver](https://www.selenium.dev/) - Browser automation
- [Appium](https://appium.io/) - Mobile automation
- [Cucumber](https://cucumber.io/) - BDD framework
- [TestNG](https://testng.org/) - Test execution and listeners
- [Groq](https://groq.com/) - Fast AI inference for failure analysis
- [OkHttp](https://square.github.io/okhttp/) - HTTP client for API calls
- [WebDriverManager](https://bonigarcia.dev/webdrivermanager/) - Automatic driver management
