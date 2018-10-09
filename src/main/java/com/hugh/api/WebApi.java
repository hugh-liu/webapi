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
		@ApiImplicitParam(name ="name", value = "用户名称", paramType = "query", dataType = "String", required = true, defaultValue = ""),
		@ApiImplicitParam(name ="password", value = "用户密码", paramType = "query", dataType = "String", required = true, defaultValue = "")
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
		@ApiImplicitParam(name ="name", value = "用户名称", paramType = "query", dataType = "String", required = true, defaultValue = ""),
		@ApiImplicitParam(name ="password", value = "用户密码", paramType = "query", dataType = "String", required = true, defaultValue = "")
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
		@ApiImplicitParam(name ="name", value = "用户名称", paramType = "query", dataType = "String", required = true, defaultValue = ""),
		@ApiImplicitParam(name ="password", value = "用户密码", paramType = "query", dataType = "String", required = true, defaultValue = "")
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
		@ApiImplicitParam(name ="name", value = "用户名称", paramType = "query", dataType = "String", required = true, defaultValue = ""),
		@ApiImplicitParam(name ="password", value = "用户密码", paramType = "query", dataType = "String", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse testPut(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
}
