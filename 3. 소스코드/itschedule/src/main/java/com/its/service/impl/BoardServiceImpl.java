package com.its.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.mapper.BoardMapper;
import com.its.service.BoardService;
import com.its.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVo> getBoardList(Map<String, Object> param) {
		return boardMapper.getBoardList(param);
	}

	@Override
	public int getBoardListCnt(Map<String, Object> param) {
		return boardMapper.getBoardListCnt(param);
	}

	@Override
	public BoardVo getBoardInfo(Map<String, Object> param) {
		return boardMapper.getBoardInfo(param);
	}
	
	@Override
	public int insertBoard(Map<String, Object> param) {
		int result = 0;
		result = boardMapper.insertBoard(param);
		return result;
	}

	@Override
	public int updateBoard(Map<String, Object> param) {
		int result = 0;
		result = boardMapper.updateBoard(param);
		return result;
	}

	@Override
	public int delBoard(Map<String, Object> param) {
		int result = 0;
		result = boardMapper.delBoard(param);
		return result;
	}

}
