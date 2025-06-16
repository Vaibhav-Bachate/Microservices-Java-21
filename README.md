# Java 21 Microservices Project – E-commerce System

This repository demonstrates an **industry-standard Java 21 microservices architecture** for an e-commerce platform, containerized using Docker and deployed on Kubernetes using Jenkins for CI/CD.

## Microservices Overview

| Service         | Description                                  | Port |
|-----------------|----------------------------------------------|------|
| `product-service` | Manages product catalog and inventory       | 8081 |
| `order-service`   | Handles order creation and management       | 8082 |
| `user-service`    | Manages user registration and profiles      | 8083 |
| `api-gateway`     | Gateway to route and secure all services    | 8080 |

---

##  Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Maven**
- **Docker**
- **Kubernetes**
- **Jenkins (CI/CD)**
- **Spring Cloud Gateway**
- **Spring Web, Data JPA, H2 (in-memory DB for dev)**

---

##  Folder Structure

```bash
java21-microservices/
├── api-gateway/               # Spring Cloud Gateway service
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│       └── main/java/com/example/ecom/gateway/
│       └── main/resources/application.yml
├── product-service/           # Product microservice
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
├── order-service/             # Order microservice
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
├── user-service/              # User microservice
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
├── k8s/                       # Kubernetes manifests
│   ├── namespace.yaml
│   ├── ingress.yaml
│   ├── product-service.yaml
│   ├── order-service.yaml
│   ├── user-service.yaml
│   └── api-gateway.yaml
├── Jenkinsfile                # CI/CD Pipeline
└── README.md

