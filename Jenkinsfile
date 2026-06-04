pipeline {
    agent any // This uses your Windows host environment directly

    tools {
        // Ensure these match your Global Tool Configuration names!
        jdk 'JAVA_HOME' 
        maven 'MAVEN_HOME'
    }
 
    stages {
        stage('Clean and Test') {
            steps {
                // Use 'bat' for Windows commands
                bat 'mvn clean test'
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