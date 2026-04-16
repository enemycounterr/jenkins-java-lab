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
                sh "sed -i 's/127.0.0.1/host.docker.internal/g' /var/jenkins_home/.kube/config"
                sh 'kubectl apply -f k8s/chat-server.yaml --insecure-skip-tls-verify'
            }
        }
    }
}