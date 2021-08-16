package com.its.mapper;

import java.util.Map;

import com.its.vo.LoginVo;

public interface CommonMapper {
	
	LoginVo getLoginInfo(Map<String, Object> param);
	
	int insertUser(Map<String, Object> param);
}
