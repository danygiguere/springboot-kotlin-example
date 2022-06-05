# README


### About
- just a project to learn Spring with Kotlin

### Installation
- add your db credentials to application.properties
- run the project with `./gradlew bootRun`

### sources of information
- https://www.callicoder.com/kotlin-spring-boot-mysql-jpa-hibernate-rest-api-tutorial/
- https://www.section.io/engineering-education/introduction-spring-data/
- https://www.raywenderlich.com/28749494-kotlin-and-spring-boot-getting-started#toc-anchor-012
- https://miensol.pl/clear-database-in-spring-boot-tests/
- https://lokalise.com/blog/spring-boot-internationalization/
- https://springframework.guru/spring-boot-cli/

### Spring documentation
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features

### Demo requirements
#### Completed
- create User and Post models and controllers
- create db migrations (built it)
- create `user has many posts` relationship
- create db seeds
- install i18n (add header `Accept-Language` : `fr` to set the locale to `fr` or `en` for english)
- create DemoController
- create translation validation on post model

#### todo
- install JWT https://scalablescripts.medium.com/kotlin-api-authentication-using-jwt-spring-boot-jwt-authentication-6e4c099e1c2
- create a middleware https://www.baeldung.com/spring-mvc-handlerinterceptor
- create demos for joins, db transactions
- find a way to run the seeds when we want (with `./gradlew ...` or a groovy command maybe??, see ./command.groovy) and make sure it cannot be run in production
- install websockets/RSocket
- When I look at this page: https://auth0.com/blog/build-and-secure-an-api-with-spring-boot/, I see 
  `fun getAll(@RequestParam(value="brandname", required = false, defaultValue = "")`, would there be a way to do the validation at that point in the request lifecycle, and in a different file ? Rather than doing the validation later at the model level. 
- https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/

#### todo (nice to have)
- figure how to reset the test db before each test (may not be required since the tests can be mocked `mockMvc.post(...`)
- figure how to run the tests as transactions, so the data is not commited in the db (may not be required since the tests can be mocked `mockMvc.post(...`)
- split the DataSeeder file in multiple files  
- find a place to save the secrets - like in a .env file (https://github.com/paulschwarz/spring-dotenv) (instead of having them in the .properties files)


