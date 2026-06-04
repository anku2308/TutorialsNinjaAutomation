pipeline {
    agent {
        docker {
            // This image comes with Java and Maven pre-installed
            image 'maven:3.9-eclipse-temurin-21'
            // This ensures the container runs as your current user
            args '-u root' 
        }
    }
 
    stages {
        stage('Clean and Test') {
            steps {
                // Now you use 'sh' instead of 'bat' because containers run Linux
                sh 'mvn clean test'
            }
        }
 
        stage('Generate Reports') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Amazon Cucumber Report'
                ])
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
    }
}