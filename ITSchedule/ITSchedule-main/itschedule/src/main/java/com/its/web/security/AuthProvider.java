package com.its.web.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.its.vo.LoginVo;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {

//	@Autowired
//	private LoginService loginService;
	
//	@Autowired 
//	private PasswordEncoder passwordEncoder;
	
	@Value("${server.dev}")
	private boolean iDev;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userId = authentication.getName();
		String userPw = authentication.getCredentials().toString();
		boolean loginFl = false;
		
//		String bcryptPassword = passwordEncoder.encode(userPw);
		if (userId == null || userId.equals("")) {
			throw new UsernameNotFoundException("#없는 아이디입니다.");
		}
		
		if (userPw == null || userPw.equals("")) {
			throw new UsernameNotFoundException("#잘못된 비밀번호 입니다.");
		} 
		
//		LoginVo loginvo = loginService.getLoginInfo(userId);
		LoginVo loginvo = null;
		
		if( loginvo == null ) {
			throw new UsernameNotFoundException("#없는 유저 정보입니다.");
		}
/*		
		if ( passwordEncoder.matches(userPw, loginvo.getPassword())) { 
			loginFl = true;
		}else {
			throw new UsernameNotFoundException("#없는 유저 정보입니다.");
		}
*/
		loginFl = false;
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		
		if (loginvo != null ) {
						
			if(loginFl) {
				
				grantedAuthorityList.add( new SimpleGrantedAuthority("ROLE"));

				return new UsernamePasswordAuthenticationToken(loginvo, null , grantedAuthorityList);
			} else {
				throw new BadCredentialsException("#정보를 찾을수 없습니다.");
			}
		} else {
			throw new BadCredentialsException("#없는 유저 입니다.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
