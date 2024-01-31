package com.project.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Dexcription Swagger2配置类
 * @Author：overthinker
 * @Package：com.project.demo.config
 * @Project：springboot流浪动物救助系统v2
 * @name：Knife4jConfig
 * @Date：2024/1/24 16:31
 * @Filename：Knife4jConfig
 */
@Configuration
@EnableSwagger2WebMvc
@Slf4j
public class Knife4jConfiguration {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {

        log.info("Knife4jConfiguration dockerBean-指定使用Swagger2规范");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .description("# 流浪动物救助站 RESTful APIs")
                        .termsOfServiceUrl("http://localhost:5000/swagger-ui.html")
                        .contact("overthinker")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("流浪动物救助站")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.project.demo.controller"))
                .paths(PathSelectors.any())
                .build();

    }
}
