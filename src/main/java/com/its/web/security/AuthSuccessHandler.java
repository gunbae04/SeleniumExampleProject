package com.its.web.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.its.service.CommonService;
import com.its.vo.LoginVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	private CommonService commonService;
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		LoginVo loginVo = (LoginVo)authentication.getPrincipal();
		
		List<GrantedAuthority> roles = (List<GrantedAuthority>) authentication.getAuthorities();
		
		String roleName = "";
		for ( GrantedAuthority role : roles) {
			log.info("#role==>{}" , role.getAuthority());
			roleName = role.getAuthority();
		}
		
		if(roleName.equals("")) {
			request.getRequestDispatcher("logout").forward(request, response);
		}
		
		HttpSession session = request.getSession(true);
		
		Map<String, Object> param = new HashMap<String, Object>();
		session.setAttribute("LOGIN", loginVo);
		log.info("#==>{}",loginVo);
		

		/*
		 * role setting 
		 * 
		 */
		
		if(loginVo != null) {
			request.getRequestDispatcher("/main").forward(request, response);
		}else {
			request.getRequestDispatcher("/logout").forward(request, response);
		}
		
	}

}
