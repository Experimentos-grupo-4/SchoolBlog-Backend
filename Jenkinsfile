pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Agrega aquí los pasos necesarios para construir tu proyecto
                echo 'Building...'
            }
        }
    }

    post {
        success {
            // Pasos a realizar en caso de éxito
            echo 'Build successful!'
        }

        failure {
            // Pasos a realizar en caso de fallo
            echo 'Build failed!'
        }
    }
}
