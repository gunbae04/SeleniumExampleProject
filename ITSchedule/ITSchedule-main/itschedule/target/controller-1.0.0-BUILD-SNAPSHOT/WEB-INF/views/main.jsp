<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="./common/header.jsp" flush="true"/>   
      
      
      
    <input type="hidden" id="pageNum" name="pageNum" value="${pageNum}">  
    <!-- Page -->
    <div class="page">
      <div class="page-content">
        <!-- Panel -->
        <div class="panel">
          <div class="panel-body">
          	<div align="right">
          		<a href="/board/create"><button type="button" class="btn btn-floating btn-success"><i class="icon wb-pencil" aria-hidden="true"></i></button></a>
            </div>
            <br>
            <br>
            <div class="page-invoice-table table-responsive">
              <table class="table table-hover text-right">
                <thead>
                  <tr>
                    <th class="text-center">번호</th>
                    <th class="text-left">제목</th>
                    <th class="text-right">작성자</th>
                    <th class="text-right">날짜</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${resultListCnt > 0}">
	                <c:forEach items="${resultList}" var="board" varStatus="status">
	                	 <tr>
		                    <td class="text-center"><c:out value="${no-status.index}"/> </td>
		                    <td class="text-left view_board" style="cursor:pointer;" value="${board.boardId}">
		                      <c:out value="${board.title}"/>
		                    </td>
		                    <td>
		                      <c:out value="${board.userName}"/>
		                    </td>
		                    <td>
		                      <c:out value="${board.created}"/>
		                    </td>
		                  </tr>
	                </c:forEach>
                </c:if>
                </tbody>
              </table>
              	<div class="form-group" align="center" style="width:30%">
                    <div class="input-group">
                      <input type="text" class="form-control" name="searchTitle" id="searchTitle" placeholder="제목을 입력하세요." value="${searchTitle}">
                      <span class="input-group-append">
                        <button type="button" class="btn btn-primary search_btn"><i class="icon wb-search" aria-hidden="true"></i></button>
                      </span>
                    </div>
                  </div>
            </div>
            
            
            <!-- pagination  -->
            <c:out value="${paging}" escapeXml="false"/>
          </div>
        </div>
        <!-- End Panel -->
      </div>
    </div>
    <!-- End Page -->

    <jsp:include page="./common/footer.jsp" flush="true"/>
    
    <!-- custom  -->
    <script src="/js/common/board.js"></script>
