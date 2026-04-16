pipeline {
    agent any

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
                // Завантажуємо свіжий образ у Minikube
                sh 'minikube image load tcp-chat-server:latest'
                // Застосовуємо конфігурацію оркестрації
                sh 'kubectl apply -f k8s/chat-server.yaml'
            }
        }
    }
}