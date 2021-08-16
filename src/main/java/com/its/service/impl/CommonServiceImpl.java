package com.its.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.mapper.CommonMapper;
import com.its.service.CommonService;
import com.its.vo.LoginVo;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private CommonMapper commonMapper;

	@Override
	public LoginVo getLoginInfo(Map<String, Object> param) {
		return commonMapper.getLoginInfo(param);
	}

	@Override
	public int insertUser(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int result = 0;
		result = commonMapper.insertUser(param);
		return result;
	}

}
