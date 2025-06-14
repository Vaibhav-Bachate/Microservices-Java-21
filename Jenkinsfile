pipeline {
    agent any

    environment {
        DOCKER_USER = 'Vaibhav8855'
        K8S_NAMESPACE = 'java21'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build All Services') {
            steps {
                script {
                    def services = ['product-service', 'order-service', 'user-service', 'api-gateway']
                    services.each { service ->
                        dir("${service}") {
                            echo "🔧 Building ${service}..."
                            sh './mvnw clean package -DskipTests || mvn clean package -DskipTests'
                        }
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    def services = ['product-service', 'order-service', 'user-service', 'api-gateway']
                    services.each { service ->
                        echo "🐳 Building Docker image for ${service}..."
                        sh "docker build -t ${DOCKER_USER}/${service}:latest ${service}"
                    }
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
                    sh 'echo "$DOCKERHUB_PASS" | docker login -u "$DOCKERHUB_USER" --password-stdin'

                    script {
                        def services = ['product-service', 'order-service', 'user-service', 'api-gateway']
                        services.each { service ->
                            echo "⬆️ Pushing ${DOCKER_USER}/${service}:latest..."
                            sh "docker push ${DOCKER_USER}/${service}:latest"
                        }
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "kubectl apply -f k8s/namespace.yaml"

                script {
                    def manifests = ['product-service.yaml', 'order-service.yaml', 'user-service.yaml', 'api-gateway.yaml', 'ingress.yaml']
                    manifests.each { yaml ->
                        echo "🚀 Deploying ${yaml}..."
                        sh "kubectl apply -f k8s/${yaml}"
                    }
                }
            }
        }
    }

    post {
        success {
            echo "✅ Deployment completed successfully!"
            sh "kubectl get all -n ${K8S_NAMESPACE}"
        }
        failure {
            echo "❌ Pipeline failed. Check console logs."
        }
    }
}
