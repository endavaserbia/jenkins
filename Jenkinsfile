pipeline {
    agent any
    parameters {
        string(name: 'mvnMessage', defaultValue: 'Maven installed.', description: 'Maven message')
        string(name: 'jdkMessage', defaultValue: 'JDK installed.', description: 'JDK message')
    }

    stages {
        stage('Test Required Tools') {
            parallel {
                stage('Test Maven') {
                    agent { docker 'maven:3-alpine' }
                    steps {
                        sh 'mvn --version'
                        echo "${params.mvnMessage}"
                    }
                }
                stage('Test JDK') {
                    agent { docker 'openjdk:11-jre' }
                    steps {
                        sh 'java -version'
                        echo "${params.jdkMessage}"
                    }
                }
            }
        }
        stage('Compile Project') {
            agent { docker 'maven:3-alpine' }
            steps {
                sh 'mvn clean verify'
            }
            post {
                success {
                    echo 'Build finished successfully.'
                }
                failure {
                    echo 'Pipeline failed!'
                }
            }
        }
    }
}