# Poseidon
A Spring Boot application for collecting datas of bid/ask financial obligation

This application use different technologies to achieve his purpose like:
- Spring Security
- Thymeleaf
- Hibernate
- Spring Data JPA

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

- Java 1.8
- Maven 3.6.2
- Mysql 8.0.17

### Installing environment

1.Install Java:

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven:

https://maven.apache.org/install.html

3.Install MySql:

https://dev.mysql.com/downloads/mysql/

### Installing database structure

Post installation of MySQL, Java and Maven, you will have to set up the tables and data in the data base.

For this, please run the sql commands present in [data.sql](/doc/data.sql)

### Installing App

1.Clone this project using git:
`git clone <url>`

2.Install the app using maven:
`mvn install`

### Mysql connection
The database connection is handled by application.properties, you need to edit this file and change login and password according to your mysql user


### Running Tests

Run tests:
`mvn test`

### Running App

Using java in command line:

`java -jar <target/last_snapshot.jar>`

### Access Datas
The web server listen on port 8080.

### Test Account
login: admin
password: 123456

login: user
password: 123456
