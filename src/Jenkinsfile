pipeline {
    agent any

    tools {
        // Ensure maven36 is configured in global tools.
        maven "maven36"
    }

    stages {
        stage('Init') {
            steps {
                git([url: 'https://github.com/gokulraja2787/trader-admin.git', branch: 'main'])
            }

        }
        stage('Quality') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean test"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                sh "mvn -DskipTests=true clean install"
            }
        }
    }
}
