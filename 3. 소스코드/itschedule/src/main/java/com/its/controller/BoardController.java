package com.its.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.its.service.BoardService;
import com.its.util.PagingUtil;
import com.its.vo.BoardVo;
import com.its.vo.LoginVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;	
	
	@Autowired
	private PagingUtil pagingUtil;
	
	@Value("${web.pagesize.five}")
    private int PAGE_SIZE;
	
	@RequestMapping(value="/list")
	public String list(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("list");
		
		String url = "/main";
		
		if( session.getAttribute("LOGIN") == null) {
			url = "/logout";
		}
		
		int pageNum = (String)param.get("pageNum") == null ? 1 : Integer.parseInt((String)param.get("pageNum"));
		int pageStartNum = (pageNum-1)*PAGE_SIZE;
		
		param.put("pageSize", PAGE_SIZE);		
		param.put("pageStartNum", pageStartNum);
		
		List<BoardVo> resultList = boardService.getBoardList(param);
		int resultListCnt = boardService.getBoardListCnt(param);
		
		int no = resultListCnt - (PAGE_SIZE * (pageNum - 1));
		
		String paging = pagingUtil.paging(resultListCnt, PAGE_SIZE, pageNum, "boardListGet");
		
		model.addAttribute("paging", paging);
		
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultListCnt", resultListCnt);
		model.addAttribute("no", no);
		model.addAttribute("pageNum", pageNum);
		
		return url;
	}
	
	@RequestMapping(value="/create")
	public String create(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("create");
		
		String url = "/board/boardAdd";
		
		if( session.getAttribute("LOGIN") == null) {
			url = "/logout";
		}
	
		
		return url;
	}
	
	@RequestMapping(value = { "/addAction" })
	@ResponseBody
	public int addAction(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("addAction");
		
		int result = 0;
		
		LoginVo login = null;
		if( session.getAttribute("LOGIN") != null) {
			login = (LoginVo) session.getAttribute("LOGIN");
			param.put("memberId", login.getUserId());
		}
		
		result = boardService.insertBoard(param);
		
		return result;
	}	
	@RequestMapping(value = { "/editAction" })
	@ResponseBody
	public int editAction(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("editAction");
		
		int result = 0;
		
		result = boardService.updateBoard(param);
		
		return result;
	}	
	
	@RequestMapping(value = { "/delAction" })
	@ResponseBody
	public int delAction(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("delAction");
		
		int result = 0;
		
		result = boardService.delBoard(param);
		
		return result;
	}	
	
	@RequestMapping(value="/view")
	public String view(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("view");
		
		String url = "/board/boardView";
		
		if( session.getAttribute("LOGIN") == null) {
			url = "/logout";
		}
		
		BoardVo result = boardService.getBoardInfo(param);
		
		model.addAttribute("result",result);
		
		return url;
	}
	@RequestMapping(value="/edit")
	public String edit(HttpSession session, ModelMap model, HttpServletRequest request, HttpServletResponse response,@RequestParam(required=false) Map<String, Object> param) {
		
		log.info("edit");
		
		String url = "/board/boardEdit";
		
		if( session.getAttribute("LOGIN") == null) {
			url = "/logout";
		}
		
		BoardVo result = boardService.getBoardInfo(param);
		
		model.addAttribute("result",result);
		
		return url;
	}

}
