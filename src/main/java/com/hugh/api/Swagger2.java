package com.hugh.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @describe：Swagger2配置类
 * @author: Hugh.liu
 * @Date: 2018年10月8日
 * @version: 1.0 
 */
@Configuration // 通过@Configuration注解，让Spring来加载该类配置。
@EnableSwagger2 // 再通过@EnableSwagger2注解来启用Swagger2。
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hugh.api"))
				.paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * 创建该API的基本信息（这些基本信息会展现在文档页面中）
	 * 访问地址：http://项目实际地址/swagger-ui.html
	 * @return     
	 **/
	 private ApiInfo apiInfo() {
		 return new ApiInfoBuilder()
				 .title("Swagger2构建RESTful APIs")
				 .description("更多请关注http://www.hugh.com")
				 .termsOfServiceUrl("http://www.hugh.com")
				 .version("1.0")
				 .build();
	 }
}