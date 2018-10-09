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
@ApiModel(value = "响应数据value", description = "响应数据")
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
