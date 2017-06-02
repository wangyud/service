package com.sdhsie.check.document;

import com.sdhsie.check.jopo.BaseResponse;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2 //Loads the spring beans required by the framework
public class MySwaggerConfig {


    private ApiInfo apiInfo() {
//        Contact contact = new Contact("winterwa", "https://github.com/ichenkaihua/ssm-easy-template", "admin@chenkaihua.com");
        return new ApiInfoBuilder()
                .title("山东高速智能值机系统 API接口")
                .description("服务端信息提供")
//                .contact(contact)
                .version("1.0")
                .build();
    }

    private Predicate<String> userPaths() {
        return or(
                regex("/users.*")
        );
    }

    @Bean
    public Docket userApi() {
        Set<String> set = new HashSet<String>();

        com.fasterxml.classmate.TypeResolver typeResolver = new com.fasterxml.classmate.TypeResolver();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true)


                ;

        return docket;
    }

  /*  *//**
     * @method 登录接口
     */
    private Predicate<String> loginPaths(){
        return or(
                regex("/login.*")
        );
    }

    @Bean
    public Docket LoginApi() {
        Set<String> set = new HashSet<String>();

        com.fasterxml.classmate.TypeResolver typeResolver = new com.fasterxml.classmate.TypeResolver();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("login-api")
                .apiInfo(apiInfo())
                .select()
                .paths(loginPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true)


                ;

        return docket;
    }

}