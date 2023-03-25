# SpringBootCustomerApplication

This Application handles basic CRUD operations in Java using springboot. I've used in memory Map for this implementation.

Following are the endpoints that are implemented:

GET /customers - return a list of customer objects in the response body.

GET /customers/count - return the total number of customers in the system/database in the response body
 
POST /customers - create a customer object, stores it in in-memory DB, returning the new customer in the response body

PUT /customers/{id} - update a customer object by id, storing it in the in-memory DB, returning updated customer in response body

DELETE /customers/{id} - deletes the customer - returns true if succeeded, false with error otherwise

## Project Setup

Clone the repository and update the project which should update the dependencies for local environment.
The application runs on localhost port 8080



