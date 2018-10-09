# Spring结合Swagger2使用
***
## 前言
***
## 目录
* [1、添加架包依赖](#1添加架包依赖)
* [2、Swagger2配置类](#2Swagger配置类)
* [3、创建接口测试](#3创建接口测试)
* [4、注解说明](#4注解说明)

***
***

### 1、添加架包依赖
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.8.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.8.0</version>
</dependency>
```
### 2、Swagger配置类
```
package com.hugh.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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
				// api包路径
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
				 .contact(new Contact("hugh.liu", "www.hugh.com", "6810110@qq.com"))
				 .version("1.0")
				 .build();
	 }
}
```
### 3、创建接口测试
```
package com.hugh.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.hugh.api.APIResponse;

/**
 * @describe：API测试
 * @author: Hugh.liu
 * @Date: 2018年10月8日
 * @version: 1.0 
 */
@Controller
@RequestMapping
@Api(tags = "测试API")
public class WebApi {
	
	@ResponseBody
	@RequestMapping(value = "testGet", method = RequestMethod.GET)
	@ApiOperation(value = "测试方法testGet", notes = "testGet notes")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="name", value = "用户名称", required = true, defaultValue = ""),
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="password", value = "用户密码", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse testGet(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
	@ResponseBody
	@RequestMapping(value = "testPost", method = RequestMethod.POST)
	@ApiOperation(value = "测试方法testPost", notes = "testPost notes")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="name", value = "用户名称", required = true, defaultValue = ""),
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="password", value = "用户密码", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse testPost(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
	@ResponseBody
	@RequestMapping(value = "testDelete", method = RequestMethod.DELETE)
	@ApiOperation(value = "测试方法testDelete", notes = "testDelete notes")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="name", value = "用户名称", required = true, defaultValue = ""),
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="password", value = "用户密码", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse testDelete(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
	@ResponseBody
	@RequestMapping(value = "testPut", method = RequestMethod.PUT)
	@ApiOperation(value = "测试方法testPut", notes = "testPut notes")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="name", value = "用户名称", required = true, defaultValue = ""),
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="password", value = "用户密码", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse testPut(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
}
```
输出对象类

```
package com.hugh.api;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @describe：API返回对象
 * @author: Hugh.liu
 * @Date: 2018年10月8日
 * @version: 1.0 
 */
@SuppressWarnings("serial")
@ApiModel(description = "响应数据")
public class APIResponse implements Serializable {
	
	@ApiModelProperty(value = "编号")
	private Integer code;
	
	@ApiModelProperty(value = "信息")
	private String message;
	
	@ApiModelProperty(value = "返回对象")
	private Object data;
	
	public APIResponse(Integer code, String message, Object data) {
		setCode(code);
		setMessage(message);
		setData(data);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
```
打开链接：http://localhost:8080/webapi/swagger-ui.html
![1](/img/1.png)
### 4、注解说明
```
@Api()用于请求类
	tags——类说明，可以是集合也可以是字符串
	value——类说明，可以使用tags替代
@ApiOperation()用于请求方法
	value——方法描述
	notes——提示内容
@ApiImplicitParams()用于请求方法，包含多个@ApiImplicitParam()
	@ApiImplicitParam()用在@ApiImplicitParams注解中
		name——参数名称
		value——参数说明
		paramType——参数类型
			· header——请求参数的获取：@RequestHeader
			· query——请求参数的获取：@RequestParam
			· path——（用于restful接口）请求参数的获取：@PathVariable
			· body——（不常用）
			· form——（不常用）
		dataType——数据类型
		required——是否必填
		defaultValue——默认值
@ApiResponses()用于请求方法，包含多个@ApiResponse
	@ApiResponse()
		code——数字
		message——信息
		response——抛出异常的类
@ApiParam()用于请求方法的参数
	name——参数名
	value——参数说明
	required——是否必填
@ApiModel()用于响应类
	value——响应类名称
	description——响应类描述
@ApiModelProperty()用于响应类属性
	value——属性描述
```
