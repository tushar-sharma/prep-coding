# Spring Boot Questions

**1. What's difference between @Controller and @RESTController?**

@RestController is a specialized version of controller, which includes @Controller and @ResponseBody.


**2. What is servlet?**

Servlet is a technology/API/class that is used to create handle requests in web applications. Reside in server side, Spring Boot uses Servlet to receive requests from client side. There are two ways in Spring Boot to use Servlet Api:

- Use @ServletComponentScan annotation.
- Use @Bean annotation.

