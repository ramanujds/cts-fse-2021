# cts-fse-2021


## How to install and use Docker on AWS EC2

```text

1. Launch a new ec2 instance
2. save the key to your local machine
3. install putty
4. generate ppk from pem and save it
5. run putty and mention the public ip address of ec2
6. add ssh->auth->browse->add the saved ppk file
7. open


installing docker on ec2



1. sudo yum update -y
2. sudo yum install docker -y
3. sudo service docker start
4. Add ec2-user to the docker group 
sudo usermod -a -G docker ec2-user
5. docker  -v


Installing Java

sudo amazon-linux-extras install java-openjdk11

Transferring files from Local Machine to EC2:
1) Create s3 bucket and add the files to be coppied
2) Allow public access to the files
3) Copy the object URL of the fils in S3
4) RUN wget "paste-url"

How to build images from the jar file:
Follow steps from docker-repository

* Modify the inbound rule and add All Port Range dor All Protocol to All
* Use http rather https

```

__Dockerfile for building image for java application__

```Dockerfile

FROM adoptopenjdk/openjdk11
WORKDIR /
ADD truyum-app.jar truyum-app.jar
EXPOSE 5000
CMD java -jar truyum-app.jar

```

## Running Spring Boot App with MySql on Docker

* Running Mysql -

```bash

docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=cts_db -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql-server mysql

```
* Running MySql with Volume - 

```bash

docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=cts_db -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql-server  --volume mysql-db-volume:/var/lib/mysql mysql

```



* Running Spring Boot App

```bash

docker container run -p 5000:5000 -e RDS_HOSTNAME=mysql-server -e RDS_PORT=3306 --link=mysql-server --name spring-boot-docker spring-boot-docker

```

* Creating Network - 

```bash

docker network create docker-mysql-network

```
* Running MySql on the Network -

```bash

docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=cts_db -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql-server  --volume mysql-db-volume:/var/lib/mysql --network=docker-mysql-network mysql

```

* Network Based Communication

 ```bash

docker container run -p 5000:5000 -e RDS_HOSTNAME=mysql-server -e RDS_PORT=3306 --name spring-boot-docker --network=docker-mysql-network spring-boot-docker

```

### Running Microservices on Docker

```text

sudo docker network create microservices-network

sudo docker container run -p 8761:8761 -d --name eureka-server --network=microservices-network eureka-server

sudo docker container run -p 5100:5100  -d -e EUREKA_HOST=eureka-server --name product-service --network=microservices-network product-service

sudo docker container run -p 5200:5200 -d -e EUREKA_HOST=eureka-server --name coupon-service --network=microservices-network coupon-service

sudo docker container run -p 5000:5000 -d -e EUREKA_HOST=eureka-server --name order-service --network=microservices-network order-service

sudo docker container run -p 8888:8888 -d -e EUREKA_HOST=eureka-server --name api-gateway --network=microservices-network api-gateway

```

### Pushing Images to Docker Hub

__login to docker__
```bash

docker login

```
__tagging a image__

```bash

docker tag order-service ram1uj/order-service:0.1

```

__push an image to docker hub__

```bash

docker push ram1uj/order-service:0.1

```

### Installing Docker-compose on EC2:

```bash

sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose


sudo chmod +x /usr/local/bin/docker-compose

sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose

```


### Docker Compose yml -

```yaml

version: '3.7'
services: 
   
    eureka-server:
        image: ram1uj/eureka-server:0.1
        ports: 
            - "8761:8761"
        restart: always
       
        networks:
            - app-network
    
    product-service:
        image: ram1uj/product-service:0.1
        ports: 
            - "5100-5199:5100"
        restart: always
        environment:
            EUREKA_HOST: eureka-server
                
        depends_on:
            - eureka-server
        networks:
            - app-network
 
    coupon-service:
        image: ram1uj/coupon-service:0.1
        ports: 
            - "5200-5299:5200"
        restart: always
        environment:
            EUREKA_HOST: eureka-server
        
        depends_on:
            - eureka-server
        networks:
            - app-network

    order-service:
        image: ram1uj/order-service:0.1
        ports: 
            - "5000-5099:5000"
        restart: always
        environment:
            EUREKA_HOST: eureka-server
        depends_on:
            - eureka-server
        networks:
            - app-network
 
# Networks to be created to facilitate communication between containers
networks:
    app-network:  
    
```


### Running with docker compose - 

* Checking the file - 

```bash
docker-compose config
```
* Strating Services - 

```bash 

docker-compose up
```

* Stopping Services - ctrl+c

* Removing Docker Compose -
 
 ```bash
 docker-compose down
```

* Scaling Services -

```bash

docker-compose up --scale product-service=2 --scale coupon-service=3

```


