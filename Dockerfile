FROM openjdk:11
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_nikita160_bot
ENV BOT_TOKEN=5343306449:AAHqbeHgmxvGVjcS3g5-ApVRfS-PXxe4NgU
ENV BOT_DB_USERNAME=jrtb_db_user
ENV BOT_DB_PASSWORD=jrtb_db_password
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar",  "app.jar", "--bot.username=${BOT_NAME}", "--bot.token=${BOT_TOKEN}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}"]
#CMD ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]

