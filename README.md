# EnterpriseApplicationManagement-Lab5

## Learning outcomes
### Docker
* Docker is a containerization platform that allows applications and their dependencies to be packaged in lightweight, portable containers, facilitating easy deployment and scalability. 
* A container registry, in general, is a repository for storing and managing container images. While DockerHub is a popular public registry, organizations often use private container registries to securely store and distribute their own container images.
* DockerHub is a public container registry where Docker users can find, share, and distribute container images. It serves as a central repository for container images created by the community and offers a convenient way to access and deploy pre-built images.
* Locally building images involves creating custom container images on your local machine using a Dockerfile, which defines the image's configuration and dependencies. These images can then be pushed to a container registry (like DockerHub or a private registry) for storage and sharing, or used for running containers locally or in cloud environments. Building images locally provides control over the image's contents and configuration, allowing for customized, self-contained application deployments.
* Docker Compose is a tool for defining and running multi-container Docker applications. It allows you to define all the services, networks, and volumes for a multi-container application in a single docker-compose.yml file, making it easier to manage and orchestrate complex application setups. Docker Compose simplifies the process of launching and connecting multiple containers, streamlining development and testing workflows for containerized applications.
### Microservices 
Microservices is an architectural approach where complex applications are broken down into smaller, independent services that can be developed, deployed, and scaled individually, promoting agility and flexibility in software development. 
#### Deployment Tools
- **Docker**: Microservices are packaged as containers using tools like Docker and deployed individually. This provides isolation, scalability, and consistency, making it easier to manage and update services independently. Docker networks and volumes can be used to connect and share data between containers.
- **Kubernetes**: Kubernetes is a popular orchestration tool for deploying and managing microservices. It automates scaling, load balancing, and fault tolerance, ensuring high availability and resilience.
## Lab
Example Dockerfile for building images
```
FROM openjdk:17
EXPOSE 8080
COPY build/libs/ms-subtract-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Docker compose config used for deploying containerized applications. 
```
services:
  ms-sum:
    build: ./ms-sum
    ports:
      - '8080:8080'

  ms-subtract:
    build: ./ms-subtract
    ports:
      - '8081:8080'
    environment:
      - SUM_SERVICE_URL=http://ms-sum:8080
```

* ms-sum is microservice is used for calculating sum of 2 number.
* ms-subtract, on the other hand, is used for subtracting. But it calls ms-sum with (a, -1 * b) for calculating result.
* OpenFeign is used for communication between services, which is a Java-based declarative web service client framework that simplifies making HTTP requests to RESTful web services. It allows developers to define the HTTP requests and the corresponding RESTful service endpoints using annotations and interfaces, making it more straightforward to work with REST APIs.

## Running
1. For running first jar files should be generated for each service. Given script can tackle this issue.
```
cd ms-sum
./gradlew build
cd ../ms-subtract
./gradlew build
```
2. Everything else will be handled by docker compose.
```
docker-compose up -d
```

## Successfull Request & Response logs
<img width="1728" alt="image" src="https://github.com/Ndrrr/EnterpriseApplicationManagement-Lab5/assets/81439809/4652cc52-3374-4139-97fd-8ad33e8fc2e3">
