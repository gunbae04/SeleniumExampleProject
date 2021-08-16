package com.its.vo;

import lombok.Data;

@Data
public class BoardVo {

	//board
	private int boardId;
	private int memberId;
	private String title;
	private String content;
	private String status;
	private String updated;
	private String created;
	
	//comment
	private int commentId;
	private String comment;
	private String commentStatus;
	private String commentUpdated;
	private String commentCreated;
	
	//file
	private int fileId;
	private String fileName;
	private String fileSize;
	private String fileType;
	private String fileUrl;
	private String fileStatus;
	private String fileUpdated;
	private String fileCreated;
}
