# SpringBootCustomerApplication

This Application handles basic CRUD operations in Java using springboot. I've used in memory Map for this implementation.

Following are the endpoints that are implemented:

* GET /customers - return a list of customer objects in the response body.

* GET /customers/count - return the total number of customers in the system/database in the response body
 
* POST /customers - create a customer object, stores it in in-memory DB, returning the new customer in the response body

* PUT /customers/{id} - update a customer object by id, storing it in the in-memory DB, returning updated customer in response body

* DELETE /customers/{id} - deletes the customer - returns true if succeeded, false with error otherwise

### API Header for PUT, POST, DELETE
```
Content-Type: application/json
```

## Pre-requisites:
   
   1. Java 8 or above version
   2. Spring Tool Suit (Preferrable IDE)

## Project Setup

Clone the repository and follow the following steps:

1. Navigate to the folder inside which you've cloned the repository. For example, my repository is inside karishmachauhan folder and click Launch.

<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743257-d5391e99-30bd-45de-9b21-723bfc468d64.png">

2. Click on import projects
<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743330-a2c70fe3-80f4-490d-a40f-f8546d8d0668.png">

3. Click on import Maven project as below:
<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743359-11076ee1-a7a6-4f19-ba24-e8d3d54c68fa.png">

4. Browse into your repository folder as below and click finish after checking pom.xml
<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743408-1daa3fb3-178a-4396-8d7a-52f09a03ffc8.png">

5. After Project is imported click on Update Project as below and this should add dependencies that are required for the application.
<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743493-709b7fa6-6377-47e8-94fd-674ece39946b.png">

6. Once project is updated run spring boot application as below:
<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227743545-77210bdd-841e-436e-a63c-a0922a0e36b5.png">


This should start spring boot application and run the application on port 8080. Now you can access all the endpoints mentioned above using a REST client like Postman.

## Sample request body for PUT and POST 

```
{
    "firstName": "John",
    "lastName": "Doe",
    "cellNumber": "1234567890",
    "email": "john.doe@example.com"
}
```

## Sample GET output

<img width="700" alt="image" src="https://user-images.githubusercontent.com/15381660/227744106-a05edc32-1174-4a2e-aae4-d77608b22b35.png">


