package com.toycommerce.member.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

/**
 * API DOC 를 위한 Swagger 설정
 */
@Configuration
@EnableWebMvc
class SwaggerConfig{
    /**
     * API 태그 정의
     */
    companion object SwaggerTags{
        const val ALL = "all"
        const val MEMBER = "member"
    }

    @Bean
    fun swaggerApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(swaggerInfo())
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.toycommerce.member.was"))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
            .tags(
                Tag(ALL, "전체", 0),
                Tag(MEMBER, "계정", 1),
            )
    }

    private fun swaggerInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("MSA Toy Project - Member API")
            .description("Member API Docs")
            .build()
    }

    private fun getConsumeContentTypes(): Set<String> {
        return hashSetOf(
            "application/json;charset=UTF-8",
            "application/x-www-form-urlencoded",
        )
    }

    private fun getProduceContentTypes(): Set<String> {
        return hashSetOf(
            "application/json;charset=UTF-8",
        )
    }
}