pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-username/tic-tac-toe.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        

      // stage('Deploy') {
            steps {
                sh '''
                cp target/tictactoe-web-1.0.war /opt/tomcat/webapps/
                '''
            }
        }//

    }

    post {

        success {
            echo "Build and Deployment Successful"
        }

        failure {
            echo "Build Failed"
        }

        always {
            echo "Pipeline Finished"
        }
    }
}
