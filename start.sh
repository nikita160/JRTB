#!/bin/sh

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=test_nikita160_bot
export BOT_TOKEN=5343306449:AAHqbeHgmxvGVjcS3g5-ApVRfS-PXxe4NgU

# Start new deployment
docker-compose up --build -d