pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/sauravnirala/tic-tac-toe.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t tictactoe-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                     docker stop tictactoecon || true
                     docker rm tictactoecon || true
                     docker run -d -p 8081:8080 --name tictactoecon tictactoe-app
                     '''
            }
        }
    
    }
}

