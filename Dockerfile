FROM amazoncorretto:8
ARG JAR_FILE=target/rest_calculator-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
CMD ["java","-jar","app.jar"]