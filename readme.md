#Java Advanced: Backend Services
---
####This course will provide you with technical hands-on knowledge of 
- Spring Boot configuration, 
- designing RESTful APIs, 
- different types of RPC protocols and data formats, and 
- Spring Security authentication and authorization features.

---
# Module 1: Spring Foundation
###Apps:
- spring-foundation-app

### Topics:
- Spring Auto Configuration
- Custom Config
- Spring Actuators and custom actuator endpoints

### References
#### How Spring Auto-Configuration works:
- [Spring Custom Auto Configuration](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/reference/html/boot-features-developing-auto-configuration.html)
- [What is Auto-Configuration?(EPAM)](https://kb.epam.com/display/RD/java+internal+lab?preview=/972042154/1004148675/Boot.pptx)
- [@SpringBootApplication Annotation (EPAM)](https://kb.epam.com/display/RD/Java+-+COE+Curriculum?preview=%2F1780200788%2F1780200803%2FSpring-Boot.pptx)

#### Spring Boot Actuator:
- [Spring Boot Actuator](https://www.linkedin.com/learning/advanced-spring-spring-boot-actuator)
- [Spring Boot Actuator pptx](https://kb.epam.com/pages/viewpage.action?pageId=227544432&preview=%2F227544432%2F779271187%2FSpring+Boot+Admin.pptx)

####Spring profiles:
- [Spring Boot Configurations: Must-Haves for Production](https://www.linkedin.com/learning/running-spring-boot-in-production)

###Docs:
- [Spring-boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

### Additional Materials [Optional]
####How Spring Auto-Configuration works
- [Spring Boot Enable AutoConfiguration debugging](https://www.youtube.com/watch?v=iBr-OpVdbz4)
- [Intro to Auto Configuration](https://www.youtube.com/watch?v=ByV0Z9nB2JM&ab_channel=JavaDevelopmentJournal)
- [Create a Custom Auto-Configuration with Spring Boot](https://www.baeldung.com/spring-boot-custom-auto-configuration)
- [Configuring a DataSource Programmatically in Spring Boot](https://www.baeldung.com/spring-boot-configure-data-source-programmatic)

#### Spring Boot Actuator
- [Custom Actuator End Point](https://www.youtube.com/watch?v=QbDNqCEJMDE&ab_channel=AnotherDevOps%21)
- [Mastering Spring Boot's Actuator](https://www.youtube.com/watch?v=otcYECeFS6Y)
- [Production Monitoring and Management with Spring Boot Actuator](https://www.youtube.com/watch?v=7L5rBQUMiPI)
- [Metrics Collection in Spring Boot With Micrometer and Prometheus](https://www.codeprimers.com/metrics-collection-in-spring-boot-with-micrometer-and-prometheus/)
- [Spring Boot Actuator](https://www.baeldung.com/spring-boot-actuators)

#### Spring profiles
- [Spring profiling](https://www.baeldung.com/spring-profiles)




---
# Module 2: RPC Protocols and Data Formats
### Apps:
- grpc-part
- avro-part

### Topics:
- gRPC
- HTTP/2
- Protobuf
- Rsocket
- Apache Avro
- Apache Thrift

### Lectures:
- [Building Java Microservices with gRPC](https://www.linkedin.com/learning/building-java-microservices-with-grpc)
- [WebSocket Programming with Java EE](https://www.linkedin.com/learning/websocket-programming-with-java-ee)

### Videos:
1. [Protocol Buffers in gRPC](https://youtu.be/yfZB2_rT_Pc)
2. [RSocket - Future Reactive Protocol by Oleh Dokuka](https://youtu.be/KapSjhUYSz4)
3. [RSocket - Future Reactive Application Protocol by Oleh Dokuka @ Spring I/O Bridge](https://youtu.be/-EoXSAaRe5c)
4. [Mark Heckler, Oleh Dokuka - RSocket + Spring: A full throttle introduction](https://youtu.be/8iy8Cs5TdcM)
5. [JSON RPC vs SOAP vs Apache Thrift What to Use and What Makes them Different](https://youtu.be/e8Df_8yMGRU)
6. [Write a Kafka Avro Producer Tutorial](https://youtu.be/_6HTHH1NCK0)

### Docs:
- [gRPC Documentation](https://grpc.io/docs/what-is-grpc/introduction/)
- [Protobuf Documentation](https://developers.google.com/protocol-buffers/docs/overview)
- [RSocket Documentation](https://docs.spring.io/spring-framework/reference/rsocket.html)
- [Apache Avro Documentation](https://avro.apache.org/docs/1.10.2/gettingstartedjava.html)
- [Apache Thrift Documentation](https://thrift.apache.org/docs/)

### Additional Materials [Optional]:
- [Working with Apache Thrift](https://www.baeldung.com/apache-thrift)
- [Official Apache Thrift Java Tutorial](https://thrift.apache.org/tutorial/java.html)
- [Guide to Apache Avro](https://www.baeldung.com/java-apache-avro)
- [Kafka Schema Registry & Avro Introduction](https://medium.com/lydtech-consulting/kafka-schema-registry-avro-introduction-1ca835524e3d)




---
# Module 3: REST API Architecture
### Apps:
- rest-api-architecture

### Topics:
- REST API Architecture  overview
- Richardson Maturity Model
- HTTP headers and response codes
- REST API design best practice
- Validation of REST API using Swagger

### Lectures:
- [Designing RESTful APIs](https://www.linkedin.com/learning/designing-restful-apis)
- [Creating Your First Spring Boot Microservice](https://www.linkedin.com/learning/creating-your-first-spring-boot-microservice)
- [Learning REST APIs](https://www.linkedin.com/learning/learning-rest-apis)

### References:
- [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)
- [Spring Boot JPA](https://spring.io/projects/spring-data-jpa)
- [Swagger](https://swagger.io/docs/)
- [Dependency Injection](https://springframework.guru/dependency-injection-example-using-spring/)




---
# Module 4: Authentication and Authorization 
### Apps:
- authentication-and-authorization
- Ex_Files_Spring_Spring_Security

### Topics:
- Security Overview
- Identification
- Authentication
- Authentication Types
- Authorization
- OAuth
- OpenID Connect

### Lectures:
- [Spring: Spring Security](https://www.linkedin.com/learning/spring-spring-security-15832928)
- [Web Security: OAuth and OpenID Connect](https://www.linkedin.com/learning/web-security-oauth-and-openid-connect-2019)
- [Web Security: User Authentication and Access Control](https://www.linkedin.com/learning/web-security-user-authentication-and-access-control-2019)

### References:
- [Prevent Brute Force](https://www.baeldung.com/spring-security-block-brute-force-authentication-attempts)
- [Spring Security](https://docs.spring.io/spring-security/reference/)
- [Build a REST API with Spring](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- [Password Hashing](https://www.baeldung.com/java-password-hashing)