# Random Beer - Spring Boot Rest API.

Name: Colm Carew

## Overview
Random Beer is an App developed using Spring Boot v2 that exhibits the creation and use of a RESTful API

![The Random Beer App][the_app]

### API Feature List

 + Version Control of the Rest Api - /api/v1
 + Obtain a random beer - /api/v1/beer
 + Create a new beer, POST to - /api/v1/beer, example JSON  "{\"name\":\"Colms Beer\",\"description\":\"A Short Descrtiption\",\"alcoholPercentage\":2.0,\"breweryLocation\":\"Waterford\",\"imageUrl\":\"https://dc8gwjuur0w0x.cloudfront.net/lists/avatars/000/000/047/original_o-PINT-GLASS-BEER-facebook.jpg?1473216955\"}"


## Installation + Running the App
Ensure you have Java 8 installed locally

Once the project is clone you can run the app by cd into the root of the project and running :
./gradlew bootRun

### List of Software + Technologies Used
+ Spring Boot 2.0.0.M2
+ React 15
+ Bootstrap 3

## Testing
Basic Unit tests through Spring were used as well as Rest Assured version 2.3.0 to the the application and Rest API

Jacoco was used to get the code coverage of the Application. To run code coverage cd into the root of the project and run
./gradlew test jacocTestReport

The resulting HTML file will be in build/reports/jacoco/index.html

![Jacoco Code Coverage][jacoco_test_report]

## API Routing
+ GET /api/v1/beer - get a random beer
+ POST /api/v1/beer - create a beer


## Database and Data Model
An in memory h2 Database was used for saving the data as it makes the project easier to run since it does not need a physical DB such as MySQL or Mongo etc.

The Data model is fairly simple, there are 2 domains a Beer and a Brewery.
A Beer has a Brewery and a Brewery has many beers. This is fine for small data set, however if a brewery has a very large number of beers then the has many should be removed
and only the Beer should point to the Brewery.

## Comments
As this was my first time working with the Spring Boot framework I suspect some of the code is not layed out in a Spring like fashion or I may have fallen in to some Spring gotchas,
especially in the database aspect with repositories. However the code coverage is quite good according to Jacoco, the App itself works as layed out and should be scalable for many devices
as Bootstrap was used.

A point to make note of is the Rest API. The API is very basic but it does not mention ids anywhere. This is due to me not wanting to expose the database id of objects for security purposes.

## Further Development
A few items I didn't get around to which I think would make the App better would be the use of Json Web Tokens for Rest Validation. Realistically this only needs to be done for the POST creating the beers.
Another item would be to add a GUID to each database object such that this id could be referenced when finding, deleting and updating objects as this gives a more linking reference and prevents the exposing of the database id.

[the_app]: ./readme_resources/the_app.png
[jacoco_test_report]: ./readme_resources/jacoco_test_report.png