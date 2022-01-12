**Technical Assesment**

**Spring boot version[0.0.1-SNAPSHOT] with H2 as in Mem database.**

**Introduction:**
This is a Backend written in spring boot for Retrieval and creation of Invoice data.Please see below details for how to run project.

**Requirements:**

1) JDK 1.8 or higher (Runtime/compiler)
2) Maven 3.6 or higher (for running tests and creating artifact)
3) IntelliJ (Optional)

**How to start:**

From CMD:

1) Download zip or clone the project from the url: https://github.com/rbansal2657/tech-assesment.git
2) Go to spring boot project directory from cmd.
3) Build the project using Maven i.e mvn clean install. *Make sure you have all required softwares.
3) Run the jar file in the target folder using java -jar technical-assesment-xxxx.jar.
   Alternatively, You can run using Any Ide by directly running the Application File.

**Documentation of API:**

Postman Documentation is : https://documenter.getpostman.com/view/3370993/UVXgMHhS

**Frameworks used:**
1) Spring Boot for API

**Postman Api Collection for testing:**

1) Collection for Postman for Api Testing is:  https://www.getpostman.com/collections/2d0916e6657f7e970e93

**Database Details:**

1)  H2 web url is :http://localhost:8080/h2-console
    H2 Db is: jdbc:h2:mem:testdb
    H2 Db Password is : password

**Unit test cases:**

1) To run the unit test cases ,run the following command: mvn test
