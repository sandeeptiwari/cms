#!/bin/bash
./mvnw clean install -DSkipTests=true
cd docker || exit
docker-compose down -v
docker-compose up --build
cd .. || exit
