FROM maven:3.8.1-jdk-8-slim as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Run the web service on container startup.
#上面代码可以换成自己的jar包名字
CMD ["java","-jar","/app/target/nanchengyu-backend-5.0-SNAPSHOT.jar,"--spring.profiles.active=prod"]


#上面的代码可以根据自己代码的实际情况更改哦
