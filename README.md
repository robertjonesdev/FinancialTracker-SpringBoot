### Financial Tracker
Robert Jones

Spring Boot Rest API

 - PostgreSQL Database
 - Rest API endpoints:
   - Person ('api/v1/person')
     - Self (GET:id) Includes all transactions for a Person
     - Add (POST)
     - Update (PUT:id)
     - Remove (DELETE:id)
   - FinancialTransaction ('api/v1/transaction')
     - Self (GET:id)
     - Add (POST)
     - Update (PUT:id)
     - Remove (DELETE:id)
 - Database relationships
   - Person has a One-To-Many relationship with FinancialTransactions.
 - Swagger UI


### env.properties
An env.properties.example file is provided. Rename this file to env.properties and set your PostgreSQL database name, username, and password.