# README


### About
- just a project to learn Spring with Kotlin

### Installation
- add your db credentials to application.properties and docker-compose.yml
- run the project with docker-compose up or locally with `./gradlew bootRun`

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
- create a middleware (interceptor)

#### todo
- create a custom validation rule
- create a few test
- create UserWithPosts to prevent n+1
- install JWT https://scalablescripts.medium.com/kotlin-api-authentication-using-jwt-spring-boot-jwt-authentication-6e4c099e1c2
- JWT https://github.com/scalablescripts/kotlin-auth
- create custom validation for checking if a email is already taken in the db https://wkrzywiec.medium.com/how-to-check-if-user-exist-in-database-using-hibernate-validator-eab110429a6
- create demos for joins, db transactions
- find a way to run the seeds when we want (with `./gradlew ...` or a groovy command maybe??, see ./command.groovy) and make sure it cannot be run in production
- install websockets/RSocket
- https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/

#### todo (nice to have)
- figure how to reset the test db before each test (may not be required since the tests can be mocked `mockMvc.post(...`)
- figure how to run the tests as transactions, so the data is not commited in the db (may not be required since the tests can be mocked `mockMvc.post(...`)
- split the DataSeeder file in multiple files  
- find a place to save the secrets - like in a .env file (https://github.com/paulschwarz/spring-dotenv) (instead of having them in the .properties files)
- validation: https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
- security and roles https://www.marcobehler.com/guides/spring-security

