pipeline {

agent any

tools {
    jdk 'JAVA_HOME'    // Change 'JDK21' to whatever is in your settings
    maven 'MAVEN_HOME' // Change 'Maven3' to whatever is in your settings
}

stages {

    stage('Git Checkout') {
        steps {
            git 'https://github.com/anku2308/TutorialsNinjaAutomation.git'
        }
    }

    stage('Build') {
        steps {
            bat 'mvn clean compile'
        }
    }

    stage('Run Tests') {
        steps {
            bat 'mvn test'
        }
    }

    stage('Generate Report') {
        steps {
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Report'
            ])
        }
    }
}


}
