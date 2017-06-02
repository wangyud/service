package com.sdhsie.check.document;

import com.sdhsie.check.jopo.BaseResponse;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2 //Loads the spring beans required by the framework
public class LoginDocConfig {

    /**
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
                //.apiInfo(apiInfo())
                .select()
                .paths(loginPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true)


                ;

        return docket;
    }

}