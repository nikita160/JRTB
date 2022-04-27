FROM openjdk:11
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_nikita160_bot
ENV BOT_TOKEN=5343306449:AAHqbeHgmxvGVjcS3g5-ApVRfS-PXxe4NgU
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar",  "app.jar", "--bot.username=${BOT_NAME}", "--bot.token=${BOT_TOKEN}"]
#CMD ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]

