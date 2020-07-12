# item-stock-batch
Basic Spring Batch application. Imports items and merchandise hierarchy csv files to a database.

Before testing the app, you should start the database with Docker compose. Head to the resources directory where the docker-compose.yaml file is located, and run docker-compose up (or docker-compose up -d if you want to detach).

- Starting the app will trigger the import job of the csv files located on the resources directory. Modifiy these files with the desired data that you want to import.
- Use the /importedData/items and /importedData/merchandise endpoints to check the data present on the database.
- You can check the logfiles for detailed import results.
