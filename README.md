### Financial Tracker
Robert Jones

Spring Boot Rest API

Live example: https://frozen-garden-64177.herokuapp.com/swagger-ui.html

 - PostgreSQL Database
 - Rest API endpoints:
   - Person ('api/v1/person')
     - Self (GET:id) 
     - Add (POST)
     - Update (PUT:id)
     - Remove (DELETE:id)
   - FinancialTransaction ('api/v1/transaction')
     - Self (GET:id)
     - Get Transactions by Person Id (GET:/person/{personId})
     - Add (POST)
     - Update (PUT:id)
     - Remove (DELETE:id)
 - Database relationships
   - Person has a One-To-Many relationship with FinancialTransactions.
 - Swagger UI


### env.properties
An env.properties.example file is provided. Rename this file to env.properties and set your PostgreSQL database name, username, and password.