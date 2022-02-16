FROM gradle:7.4.0-jdk17 AS TEMP_BUILD_GRADLE2
ENV APP_DIR=/usr/app
ENV ARTIFACT=fizzbuzz-0.0.1-SNAPSHOT.jar
WORKDIR $APP_DIR
COPY build.gradle settings.gradle gradlew $APP_DIR/
COPY gradle $APP_DIR/gradle
COPY src $APP_DIR/src
RUN ./gradlew build


FROM openjdk:17
ENV ARTIFACT=fizzbuzz-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_GRADLE2 $APP_HOME/build/libs/$ARTIFACT .
EXPOSE 8080
CMD java -jar ${ARTIFACT}