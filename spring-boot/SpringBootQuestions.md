# Spring Boot Questions

**1. What's difference between @Controller and @RESTController?**

@RestController is a specialized version of controller, which includes @Controller and @ResponseBody.


**2. What is servlet?**

Servlet is a technology/API/class that is used to create handle requests in web applications. Reside in server side, Spring Boot uses Servlet to receive requests from client side. There are two ways in Spring Boot to use Servlet Api:

- Use @ServletComponentScan annotation.
- Use @Bean annotation.


**3. What is use of collectMap()?**

 The function converts sequence into a Mono<Map>. Example 
 
  Lets say you have a request that returns Map
  
  ```bash
  @GetMapping("test") 
  public Mono<Map<String, String>> test() {
      reuturn this.someService.test();
  }
  ```
  
  And then you can return hashmap values like
  
  ```bash
   public Mono<Map<String, String>> test() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "key1");
        map.put("key2", "key2");
  
        return Flux.fromIterable( () -> map.entrySet().iterator()).collectMap(entry -> entry.getKey(), entry -> entry.getValue());
   }
  ```
  

