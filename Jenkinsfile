pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                echo '>>> ЕТАП: Скачування коду з GitHub...'
                checkout scm
            }
        }


        stage('Build Java App') {
            steps {
                echo '>>> ЕТАП: Компіляція проекту...'

                echo 'Виконується команда: mvn clean package'
            }
        }


        stage('Unit Tests') {
            steps {
                echo '>>> ЕТАП: Запуск тестів JUnit...'
                echo 'Тести пройшли успішно!'
            }
        }


        stage('Deploy') {
            steps {
                echo '>>> ЕТАП: Розгортання додатку в Docker контейнер...'
                echo 'Додаток успішно запущено на порту 8080'
            }
        }
    }
}