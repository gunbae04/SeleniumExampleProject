package com.its.service;

import java.util.List;
import java.util.Map;

import com.its.vo.LoginVo;

public interface CommonService {	
	
	LoginVo getLoginInfo(Map<String, Object> param);
}
