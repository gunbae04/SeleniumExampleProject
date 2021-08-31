package com.its.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthFailuerHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.info("###fail.............");
		
		String errMsg = exception.getMessage();		
		log.info("#errMsg==>{}" , errMsg);		
		
		if (exception instanceof BadCredentialsException) 			errMsg = ((BadCredentialsException)exception).getMessage();
		else if (exception instanceof UsernameNotFoundException) 	errMsg = ((UsernameNotFoundException)exception).getMessage();
		else if (exception instanceof DisabledException) 			errMsg = ((DisabledException)exception).getMessage();
		
		request.setAttribute("errMsg", errMsg);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		request.getRequestDispatcher("/login").forward(request, response);
		/*
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		//실패 시 response를 json 형태로 결과값 전달
		String sRlt = "{\"sucesss\": false}";
		response.getWriter().print(sRlt);
		response.getWriter().flush();
		*/
	}

}
