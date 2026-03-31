pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test -Dbrowser=chrome -Denv=prod'
            }
        }

        stage('Publish Report') {
            steps {
                echo 'Publishing Cucumber report...'
                publishHTML(target: [
                    reportName: 'Cucumber Report',
                    reportDir: 'target',
                    reportFiles: 'cucumber.html'
                ])
            }
        }
    }

    post {
        success {
            echo '✅ All tests passed!'
        }
        failure {
            echo '❌ Tests failed — check the Cucumber report.'
        }
    }
}