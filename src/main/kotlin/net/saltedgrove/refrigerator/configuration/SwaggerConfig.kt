package net.saltedgrove.refrigerator.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.service.ApiInfo.DEFAULT_CONTACT

@EnableSwagger2
@Configuration
class SwaggerConfig {
    @Bean
    fun api() : Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.saltedgrove.refrigerator.controllers"))
                .build()
                .apiInfo(apiInfo())
    }
    fun apiInfo() : ApiInfo{
        return ApiInfo("Refrigerator Service", "Multitenant Refrigerator Service", "",
                "", DEFAULT_CONTACT,
                "", "", ArrayList())
    }
}