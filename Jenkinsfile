pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Too Install') {
            steps {
                script {
                    // Coloca aquí los comandos para instalar dependencias
                    echo 'Instalando dependencias...'
                }
            }
        }

        stage('Compile Stage') {
            steps {
                script {
                    // Coloca aquí los comandos para compilar tu proyecto
                    echo 'Compilando...'
                }
            }
        }

        stage('Testing Stage') {
            steps {
                script {
                    // Coloca aquí los comandos para ejecutar pruebas
                    echo 'Ejecutando pruebas...'
                }
            }
        }
    }

    post {
        success {
            // Acciones a realizar si el pipeline es exitoso
            echo 'Pipeline ejecutado con éxito.'
        }

        failure {
            // Acciones a realizar si el pipeline falla
            echo 'El pipeline ha fallado.'
        }
    }
}
