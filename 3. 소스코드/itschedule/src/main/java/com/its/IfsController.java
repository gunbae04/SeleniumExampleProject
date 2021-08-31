package com.its;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class IfsController {

	
	@RequestMapping(value = "/api.app", method = RequestMethod.POST)
	@ResponseBody
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws JsonProcessingException {
	        
		return "";
	}
	
}
