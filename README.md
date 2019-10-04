## Tehchsaloniki 5 Spring

A Spring Boot application which can be used as a backend of Student Angular application. It was developed using [this configuration](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.1.9.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.prodyna&artifactId=techsaloniki-spring&name=techsaloniki-spring&description=Demo%20project%20for%20Spring%20Boot%20and%20Angular&packageName=com.prodyna.techsaloniki&dependencies=web,data-jpa,mysql,flyway). (click on the link to see what happens)

It was developed as a tutorial of Spring Boot and Angular for workshop puproses on  [Techsaloniki event](https://techsaloniki.gr/techsaloniki-5), Greece (2019-10-05).

## Branches

This example is divided into 2 Git branches:

* `master`: contains the exercise as it is taught inside the workshop with TODO items/goals to be missing.
* `complete`: contains the complete solution

## Database

In order to run this application you have to create a new MySQL database and ```student``` table using the following DDL commands:

```sql
CREATE SCHEMA `techsaloniki` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `techsaloniki`.`student` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `surname` VARCHAR(255) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

```

## App configuration

Before running the application, please configure database in ```application.properties``` file accordingly:

```conf
spring.datasource.url=jdbc:mysql://myip:3306/techsaloniki?useSSL=false
spring.datasource.username=myuser
spring.datasource.password=mypassword
```

## Run the application using an IDE

The easiest way to run is through an IDE such as Netbeans, Eclipse, IntelliJ IDEA. For example to run on Eclipse STS (Spring Tool Suite) you can import the project as a Maven project and then right click on the project and select: ```Run As```>```Spring Boot App```.

## Compile using Maven

Alternatively to the IDE, providing that you have [Maven](http://maven.apache.org/) installed, open a shell (or command prompt) and run ```mvn clean package```. An executable ```.jar``` file will be generated in ```target``` directory. Example: ```techsaloniki2018-0.0.1-SNAPSHOT.jar```

## Run the application from shell

Run ```java -jar techsaloniki-spring-0.0.1-SNAPSHOT.jar```.

The application will be available in:
* http: http://localhost:8081

You can copy and alter ```application.properties``` file in order to customize the application.

## Test the API

To test the REST API the easier way is use [cURL](https://curl.haxx.se/) or [Postman](https://www.getpostman.com/). Current examples are provided using ```curl```.

### Insert a student

Execute in a shell:

```shell
curl -X POST "http://localhost:8081/students/" \
    -H "Content-Type: application/json" \
    -d '{"name" : "John", "surname":"Longjohn"}'
```

### Return all students

Execute in a shell:

```shell
curl "http://localhost:8081/students/all"
```

### Delete a student by its id

To delete student with id:3, execute in a shell:

```shell
curl -X DELETE "http://localhost:8081/students/3"
```

### Search students with a string

To search for students with a "nik" string inside their name or surname, execute in a shell:

```shell
curl -X GET "http://localhost:8081/students/search/nik"
```
