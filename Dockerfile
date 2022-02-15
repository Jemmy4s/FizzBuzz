FROM openjdk:17
COPY build/libs/fizzbuzz-0.0.1-SNAPSHOT.jar fizzbuzz.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/fizzbuzz.jar"]