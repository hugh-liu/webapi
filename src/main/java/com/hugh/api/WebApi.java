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
@RequestMapping("/api")
@Api(tags = "测试API")
public class WebApi {
	
	@ResponseBody
	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ApiOperation(value = "测试方法test", notes = "测试方法 notes")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="name", value = "用户名称", required = true, defaultValue = ""),
		@ApiImplicitParam(paramType = "query", dataType = "String", name ="password", value = "用户密码", required = true, defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 500, message = "后台异常", response = Exception.class)
	})
	public APIResponse test(@RequestParam String name, @RequestParam String password) throws Exception {
		return new APIResponse(0, "完成", null);
	}
	
}
