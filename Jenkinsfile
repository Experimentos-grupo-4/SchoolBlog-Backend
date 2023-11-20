pipeline {
    agent any
    environment {
        // Define la variable de entorno PATH para incluir la ubicación de Angular CLI.
        PATH = "C:\\ruta\\a\\angular\\cli;$PATH"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Install Dependencies') {
            steps {
                // Instala Node.js y las dependencias del proyecto (asegúrate de que Node.js y npm estén instalados)
                bat 'curl -sL https://deb.nodesource.com/setup_14.x | bash -'
                bat 'apt-get install -y nodejs'
                bat 'npm install'
            }
        }
        stage('Build') {
            steps {
                // Compilar y construir la aplicación Angular
                bat 'npm run build'  // O "ng build" si tienes Angular CLI globalmente instalado
            }
        }
        // Agrega más etapas aquí según tus necesidades (por ejemplo, etapas de pruebas o despliegue).
    }
    post {
        success {
            // Puedes agregar acciones que se ejecuten cuando el Pipeline tenga éxito.
            echo 'El pipeline se ejecutó con éxito.'
        }
        failure {
            // Puedes agregar acciones que se ejecuten cuando el Pipeline falle.
            echo 'El pipeline ha fallado.'
        }
    }
}
