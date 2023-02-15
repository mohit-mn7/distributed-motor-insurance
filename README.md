# Insurance Quoation System

This is a web based motor insurance quotation system which allows various types of clients to connect to a broker service that generates a list of quotations based on the client's information. The broker service utilizes three different insurance service implementations - Girl Power, Dodgy Drivers, and Auld Fellas' - to produce the list of quotations. This system allows clients to receive multiple quotes from different insurance providers and compare them to make an informed decision.

### Prerequisites

- Java 8 or higher
-	Node.js
-	Docker
-	Maven
-	A web browser


### Running the Project
> 1. Clone the repository and navigate to the root directory
```
$ git clone GIT_URL
$ cd DIR
```
> 2.	Build and run the backend services using Maven:
```
$ cd backend
$ mvn clean
$ mvn install package
```
> 3. Navigate to the frontend directory and install the required dependencies:

```
$ cd ../frontend
$ npm install
```
> 4.	Build and run the Docker containers using Docker compose:
```
$ cd ..
$ docker-compose up --build
```
> 5.	Once the Docker containers are up, Open a web browser and navigate to http://localhost:4200 to access the application.

### Using the Application
1.	Enter your name, gender, age, points, Number of claims,  and licence number.

2.	Click the "Submit" button to retrieve a list of quotations from the broker service.

3.	The quotations will be displayed in a table, including the company name, a reference number and cost of insurance.

