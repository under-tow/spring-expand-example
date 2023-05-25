//package cn.under2.rabbitmq.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableOpenApi
//public class Swagger2 {
//	   @Bean
//	    public Docket createRestApi() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .apiInfo(apiInfo())
//	                .select()
//	                .apis(RequestHandlerSelectors.basePackage("cn.under2"))
//	                .paths(PathSelectors.any())
//	                .build();
//	    }
//	    private ApiInfo apiInfo() {
//	        return new ApiInfoBuilder()
//	                .title("Spring Boot中使用spring-boot-starter-amqp集成rabbitmq")
//	                .description("包含web示例和java方法的示例")
//	                .version("1.0")
//	                .build();
//	    }
//}
