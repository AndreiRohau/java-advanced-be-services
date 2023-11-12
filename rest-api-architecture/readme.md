# Rest App

---
### Maturity set:
 - according to this [guide](https://blog.restcase.com/4-maturity-levels-of-rest-api-design/) 
 - check as well this [guide](https://martinfowler.com/articles/richardsonMaturityModel.html) 

---
### Swagger-2 using Springfox (NOT APPLIED) info
- How was set? [guide](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
- Run App & use Swagger docs: http://localhost:8080/v2/api-docs
- Run App & use Swagger ui: http://localhost:8080/swagger-ui/

- ######DONE: migrate from SpringFox to SpringDoc: [guide](https://springdoc.org/#migrating-from-springfox)
- How? [guide](https://springdoc.org/v1/), where Spring-boot (v1, v2 and v3) & Java8~11
- NOTE! SpringBoot version requirements: [springdoc-openapi v2.2.0](https://springdoc.org/#getting-started) requires Spring-boot v3 (Java 17 & Jakarta EE 9)
- Run App & use Swagger docs: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- Run App & use Swagger ui: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)



---
TASK:

--->>> START

What should be done
1. Create maven project with 4 modules :

- jmp-dto - jmp-service-api - jmp-cloud-service-impl - jmp-service-rest

2. Create the fallowing classes under jmp-dto module :

- [User] Long id; String name; String surname; LocalDate birthday; - [Subscription] Long id; User user; LocalDate startDate; - [UserRequestDto] Long id; String name; String surname; String birthday; - [SubscriptionRequestDto] Long id; Long userId; - [UserResponseDto] Long id; String name; String surname; String birthday; - [SubscriptionResponseDto] Long id; Long userId; String startDate;

3. Create UserController under jmp-service-rest module with following methods:

- createUser(UserRequestDto); - updateUser(UserRequestDto); - deleteUser(Long); - getUser(Long); - getAllUser();

4. Use id filed into UserRequestDto only for updating data.

5. Must be returned UserResponseDto from the following methods :

- createUser(UserRequestDto); - updateUser(UserRequestDto); - getUser(Long); - getAllUser();

6. Create ServiceController under jmp-service-rest module with following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - deleteSubscription(Long); - getSubscription(Long); - getAllSubscription();

7. Use id filed into SubscriptionRequestDto only for updating data.

8. Must be returned SubscriptionResponseDto from the following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - getSubscription(Long); - getAllSubscription(); (as list)

9. Add necessary interfaces/methods to jmp-service-api.

10. Implement interfaces/methods under jmp-service-api into jmp-cloud-service-impl.

11. UserController and ServiceController must provide REST API interfaces according to 2nd of REST API maturity.

12. You can use memory structures to store the data (List, Map..).

13. Use jmp-cloud-service-impl to implement UserController and ServiceController.

14. Implement Application class with @SpringBootApplication annotation and main method.

15. Use lambdas and Java 8 features wherever it’s applicable.

16. Make sample requests to UserController and ServiceController, provide screenshots/responses.

(3-4 stars)

17. Use a DB to store the data (List, Map..).

18. Use spring boot data jpa module to access data.

19. Use spring converters to convert :

- UserRequestDto to User - User to UserResponseDto - SubscriptionRequestDto to Subscription - Subscription to SubscriptionResponseDto

20. Document methods in UserController and ServiceController using Swagger 2 annotations.

21. Make sample requests to UserController and ServiceController via Swagger UI, provide screenshots.

(5 stars)

22. Use Java 9 modules wherever it’s applicable.

23. Implement REST APIs according to all Richardson Maturity Level (0 - 3).

24. Make sample requests to UserController and ServiceController, provide screenshots/responses.

--->>> END
---
