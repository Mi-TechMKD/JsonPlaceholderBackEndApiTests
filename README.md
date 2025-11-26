JsonPlaceholderBackEndApiTests

Overview

JsonPlaceholderBackEndApiTests is a Java-based API testing project that automates testing of the JSONPlaceholder
 fake REST API. The project validates CRUD operations, HTTP responses, and JSON data using JUnit, RestAssured, and Jackson.

Features

GET Requests – Retrieve resources and verify responses

POST Requests – Create new resources and validate creation

PUT Requests – Update resources and check updates

DELETE Requests – Delete resources and confirm deletion

Response Validation – Assert status codes, headers, and JSON body content

Reusable Test Data – Data factories for dynamic payloads

Object Builders – Builder classes for request objects

Centralized Configuration – All base URLs and settings in one class

Project Structure
JsonPlaceholderBackEndApiTests/
│
├─ src/main/java/
│   ├─ client/             # API client classes for sending HTTP requests
│   ├─ datafactory/        # Test data generators (POST, PUT)
│   ├─ models/             # POJO classes for requests and responses
│   ├─ objectbuilder/      # Builder classes for request objects
│   └─ utils/              # Configuration and helper classes
│
├─ src/test/java/
│   └─ productsTests/      # JUnit test classes for API endpoints
│
└─ pom.xml                 # Maven dependencies and build configuration

Technologies

Java 24

Maven 3.8+

JUnit 4

RestAssured 5.4.0

Jackson Databind 2.15.2

Lombok 1.18.38

Getting Started
Prerequisites

Java JDK 24

Maven 3.8+

IDE (IntelliJ IDEA, Eclipse, VS Code)

Installation

Clone the repository:

git clone https://github.com/yourusername/JsonPlaceholderBackEndApiTests.git


Navigate to the project folder:

cd JsonPlaceholderBackEndApiTests


Build the project:

mvn clean install

Running Tests

You can run tests via your IDE or command line:

mvn test


Test reports will be generated in target/surefire-reports.

Usage

Update Configuration.java for different API base URLs if necessary.

Use objectbuilder classes to generate request payloads.

Run JUnit tests in productsTests to validate API endpoints.

Example Test
@Test
public void getAllProductsTest() {
    Response response = ProductsClient.getAllProducts();
    assertEquals(200, response.getStatusCode());

    ProductsGETALLResponse products = response.as(ProductsGETALLResponse.class);
    assertNotNull(products);
    assertTrue(products.getProducts().size() > 0);
}

Contributing

Fork the repository

Create a branch: git checkout -b feature/YourFeature

Commit your changes: git commit -m "Add some feature"

Push to branch: git push origin feature/YourFeature

Open a Pull Request

License

This project is licensed under the MIT License. See the LICENSE
 file for details.
