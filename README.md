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

## Testing
Basic Unit tests through Spring were used as well as Rest Assured version 2.3.0 to the the application and Rest API

Jacoco was used to get the code coverage of the Application. To run code coverage cd into the root of the project and run
./gradlew test jacocTestReport

The resulting HTML file will be in build/reports/jacoco/index.html

![Jacoco Code Coverage][jacoco_test_report]

## API Routing
+ GET /api/v1/beer - get a random beer
+ POST /api/v1/beer - create a beer

[the_app]: ./readme_resources/the_app.png
[jacoco_test_report]: ./readme_resources/jacoco_test_report.png