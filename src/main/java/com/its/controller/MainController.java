package com.its.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.its.service.CommonService;
import com.its.vo.LoginVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController extends CommonController{
	
	@Autowired
	private CommonService commonService;	
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Value("${web.pagesize.five}")
    private int PAGE_SIZE;
	
	
	@RequestMapping(value = { "/", "/login" })
	public String root(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		log.info("root");
		
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		param.put("userId","12313");
//		
//		LoginVo login = commonService.getLoginInfo(param);
		
		if( session.getAttribute("LOGIN") == null) {
			return "/login";
		}else{
			return "redirect:/main";
		}
	}
	
	
	@RequestMapping(value="/main")
	public String main(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		log.info("main");
		
		String url = "/home";
		
		if( session.getAttribute("LOGIN") == null) {
			log.info("session expire");
		}else {
			log.info("session OK");
		}
		
		log.info("로그인");
		
		return url;
	}
	/*
	@RequestMapping(value="/test")
	public String test(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		log.info("test");
		
		String url = "/test";
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName","test");
		param.put("loginId","test");
		String bcryptPassword = passwordEncoder.encode("test");
		param.put("password",bcryptPassword);
		
		int reuslt = commonService.insertUser(param);
		
		log.info(String.valueOf(reuslt));
		
		return url;
	}
	*/
	
}