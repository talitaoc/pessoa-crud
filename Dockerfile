FROM adoptopenjdk/maven-openjdk11
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn package -DskipTests
ENTRYPOINT ["java","-jar","target/cadastro-0.0.1-SNAPSHOT.jar"]
