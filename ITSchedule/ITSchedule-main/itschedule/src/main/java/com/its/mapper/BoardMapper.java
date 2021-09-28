package com.its.mapper;

import java.util.List;
import java.util.Map;

import com.its.vo.BoardVo;
import com.its.vo.CodeVo;

public interface BoardMapper {
	
	List<BoardVo> getBoardList(Map<String, Object> param);
	
	int getBoardListCnt(Map<String, Object> param);
	
	BoardVo getBoardInfo(Map<String, Object> param);
	
	int insertBoard(Map<String, Object> param);
	
	int updateBoard(Map<String, Object> param);
	
	int delBoard(Map<String, Object> param);

	List<CodeVo> getCodeList(Map<String, Object> param);

}
