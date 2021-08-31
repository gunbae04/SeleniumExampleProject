package com.its.util;

import org.springframework.stereotype.Component;

@Component
public class PagingUtil {
	
	/**
	 * <pre>
	 * 1. �޼ҵ�� : paging
	 * 2. �ۼ���   : 2020. 1. 22. ���� 8:59:49
	 * 3. �ۼ���   : ������
	 * 4. ����     : ����¡ HTML �����
	 * </pre>
	 * @param totalCount 	// ��ü ����Ʈ ����
	 * @param pageSize 		// �� ȭ�鿡 ������ ����Ʈ ����
	 * @param pageNum 		// Ŭ�� �� ������ ��ȣ
	 * @param pageName 		// ����Ʈ �̸�
	 * @return
	 */
	public String paging(int totalCount, int pageSize, int pageNum, String pageName){
	
		// pageNumber : �� ���� ������ ������ ��ȣ ��
		int pageNumber = 10;
	
		// totalPage : ��ü ������ ����
		int totalPage = (int) Math.ceil((float)totalCount / (float)pageSize);
		// totalBlock : ex) totalPage : 3 - �� 1��, totalPage : 18 - �� 2��
		int totalBlock = (int) Math.ceil((float)totalPage / (float)pageNumber);
	
		int block = 0;
	
		if((pageNum) % pageNumber != 0){
			block = (int) Math.ceil((float)(pageNum + 1) / (float)pageNumber);
		}else{
			block = (int) Math.ceil((float)(pageNum + 1) / (float)pageNumber) - 1;
		}
	
		int firstPage = (block - 1) * pageNumber; 	
		int lastPage = block * pageNumber;			
	
		int frist = 1;
		int last = lastPage + 1;
		
		int prev = 1;		
		int next = totalPage;	
		
		if(pageNum > 1) {
			prev = pageNum - 1;
		}
		
		if(pageNum < totalPage) {
			next = pageNum + 1;
		}
		
		int goPage = firstPage + 1;
	
		if(pageName == ""){
			pageName = "pageGo";
		}
	
		if(totalBlock <= block){
			lastPage = totalPage;
		}
	
		StringBuilder sb = new StringBuilder();
		
		if(totalCount > 0){
			sb.append("<ul class='pagination pagination-rounded justify-content-end mb-2'>");
			sb.append("<div class='pagination'>");
			
			if(block > 1){	
				//sb.append("<a href='javascript:"+pageName+"("+frist+");'>&laquo;</a>");
				sb.append("<li class='page-item'>");
				sb.append("<a class='page-link' href='javascript:"+pageName+"("+frist+");' aria-label='Previous'>");
				sb.append("<i class='mdi mdi-chevron-left'></i>");
				sb.append("</a>");
				sb.append("</li>");
				
			}else{
				//sb.append("<a href='javascript:"+pageName+"("+prev+");'>&laquo;</a>");
				sb.append("<li class='page-item'>");
				sb.append("<a class='page-link' href='javascript:"+pageName+"("+prev+");' aria-label='Previous'>");
				sb.append("<i class='mdi mdi-chevron-left'></i>");
				sb.append("</a>");
				sb.append("</li>");
			}
	
			for(int i = goPage; i <= lastPage; i++){
				
				if(pageNum == i){
					//sb.append("<a href='javascript:"+pageName+"("+i+");' class='active'>"+i+"</a>");
					sb.append("<li class='page-item active'><a class='page-link' href='javascript:"+pageName+"("+i+");' >"+i+"</a></li>");
				}else{
					//sb.append("<a href='javascript:"+pageName+"("+i+");'>"+i+"</a>");
					sb.append("<li class='page-item'><a class='page-link' href='javascript:"+pageName+"("+i+");' >"+i+"</a></li>");
				}
			}
	
			if(block < totalBlock){				
				//sb.append("<a href='javascript:"+pageName+"("+last+");'>&raquo;</a>");
				sb.append("<li class='page-item'>");
				sb.append("<a class='page-link' href='javascript:"+pageName+"("+last+");' aria-label='Next'>");
				sb.append("<i class='mdi mdi-chevron-right'></i>");
				sb.append("</a>");
				sb.append("</li>");
			}else{
				//sb.append("<a href='javascript:"+pageName+"("+next+");'>&raquo;</a>");
				sb.append("<li class='page-item'>");
				sb.append("<a class='page-link' href='javascript:"+pageName+"("+next+");' aria-label='Next'>");
				sb.append("<i class='mdi mdi-chevron-right'></i>");
				sb.append("</a>");
				sb.append("</li>");
			}
			sb.append("</div>");
			sb.append("</ul>");
		}else{
			sb.append("<ul class='pagination pagination-rounded justify-content-end mb-2'></ul>");
		}
		
		/*		
		if(totalCount > 0){
			sb.append("<div class='page_div'>");
			sb.append("<div class='pagination'>");
			
			if(block > 1){	
				sb.append("<a href='javascript:"+pageName+"("+frist+");'>&laquo;</a>");				
			}else{
				sb.append("<a href='javascript:"+pageName+"("+prev+");'>&laquo;</a>");
			}
	
			for(int i = goPage; i <= lastPage; i++){
				
				if(pageNum == i){
					sb.append("<a href='javascript:"+pageName+"("+i+");' class='active'>"+i+"</a>");
				}else{
					sb.append("<a href='javascript:"+pageName+"("+i+");'>"+i+"</a>");
				}
			}
	
			if(block < totalBlock){				
				sb.append("<a href='javascript:"+pageName+"("+last+");'>&raquo;</a>");
			}else{
				sb.append("<a href='javascript:"+pageName+"("+next+");'>&raquo;</a>");		
			}
			sb.append("</div>");
			sb.append("</div>");
		}else{
			sb.append("<div class='page_div'></div>");
		}
		*/
	
		return sb.toString();
	}
		
	
}
