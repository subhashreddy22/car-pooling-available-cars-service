# car-pooling-available-cars-service
## Description

Retrieves the available cars in the requested location

```java
List<String> getAvailableCars(@RequestParam String location)
```
1. Receives location as input.
2. Based on the location input the available cars at that location are retrieved.
3. The retrieved cars are returned as a list in the output.

### Endpoints

>/car/pooling/available/cars GET

### Request Data

#### URI: /car/pooling/available/cars GET

> **Request**

```json
	http://localhost:8080/car/pooling/available/cars?location=Germany
```

> **Response**

```json
	["AMG S 63 Cabrio","AMG C 63 S","AMG E 53"]
```

## Built with
* Maven
* Spring Boot

## Prerequisites
You need to have installed

 - Java 8
 - Maven
 - STS
 
## Deployment
On STS right click on project -> Run As -> Spring Boot App

## Running JUnit test
On STS right click on project -> Run As -> Maven Test
