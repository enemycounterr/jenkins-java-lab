pipeline {
    agent any

    tools {
            maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Maven Build') {
            steps {
                echo 'Building JAR with dependencies...'
                sh 'mvn clean package'
            }
        }
        stage('Docker Image') {
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t tcp-chat-server:latest .'
            }
        }
        stage('Deploy to K8s') {
            steps {
                echo 'Updating Kubernetes Deployment...'
                sh 'kubectl apply -f k8s/chat-server.yaml'
            }
        }
    }
}