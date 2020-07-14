# item-stock-batch
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/mauroalfaro/item-stock-batch)](https://github.com/mauroalfaro/item-stock-batch/releases/tag/v1.0)

## Description
Basic Spring Batch application. Imports items and merchandise hierarchy csv files to a database running on a Docker container.

## Design
Basic Spring Batch application with basic Spring Batch features. Imports two csv files, and provides an endpoint to each entity to check the data imported.
Includes:
- Spring MVC
- Spring Boot
- Spring Batch processors, writers and listeners
- Docker compose to start up the db
- Hibernate framework for data writing and retrieving
- OpenApi UI to test the imports

## Using the app
Before testing the app, you should start the database with Docker compose. Head to the resources directory where the docker-compose.yaml file is located, and run 
```bash
 docker-compose up
```
or docker-compose up -d if you want to detach.

This will start the stock-db pointing to the default MySQL port. You can use MySQL Workbench or any other client to test connection. Check user and password presents on the yaml in case that you have any issues connecting.
Run the command docker-compose logs to check the logs from the db if you are dettaching.

To build the app without tests, run:

```bash
 mvn clean install -DskipTests=true
```

And then execute

```bash
java -jar item-stock-batch/target/item-stock-batch-1.0-RELEASE.jar
```

- Starting the app will trigger the import job of the csv files located on the resources directory. Modifiy these files with the desired data that you want to import.
- If any other instance of the import job was executed before, any new import run will wipe the data present on the db before writing new data.
- Use the /importedData/items and /importedData/merchandise endpoints to check the data present on the database, using Swagger UI or Postman.
- You can check the logfiles for detailed import results.
