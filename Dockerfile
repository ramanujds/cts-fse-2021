FROM adoptopenjdk/openjdk11
WORKDIR /
ADD target/product-service-0.0.1-SNAPSHOT.jar product-service-0.0.1-SNAPSHOT.jar
EXPOSE 5100
CMD java -jar product-service-0.0.1-SNAPSHOT.jar