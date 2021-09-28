<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../common/header.jsp" flush="true"/>   

    <!-- Page -->
    <div class="page">
      <div class="page-content">
        <!-- Panel -->
        <div class="panel">
          <div class="panel-body">
            <br>
            <br>
            <input type="hidden" id="memberId" value="${result.memberId }">
            <input type="hidden" id="boardId" value="${result.boardId }">
            <div >
					<div class="form-group form-material floating"
						data-plugin="formMaterial">
						 <label class="floating-label">제목</label>
						 <br>
						 <h3>${result.title}</h3>
					</div>
              		
   ${result.content}
              


				</div>
            
        <div align="right">    
			<button type="button" class="btn btn-success ladda-button back_board_btn"
				data-style="expand-left" data-plugin="ladda">
				<span class="ladda-label">돌아가기</span> <span class="ladda-spinner"></span>
				<div class="ladda-progress" style="width: 0px;"></div>
			</button>
			<c:if test="${LOGIN.userId == result.memberId}">
				<button type="button" class="btn btn-primary ladda-button edit_board_btn"
					data-style="expand-left" data-plugin="ladda" value="${result.boardId }">
					<span class="ladda-label">수정하기</span> <span class="ladda-spinner"></span>
					<div class="ladda-progress" style="width: 0px;"></div>
				</button>
				<button type="button" class="btn btn-danger ladda-button del_board_btn"
					data-style="expand-left" data-plugin="ladda" value="${result.boardId }">
					<span class="ladda-label">삭제하기</span> <span class="ladda-spinner"></span>
					<div class="ladda-progress" style="width: 0px;"></div>
				</button>
			</c:if>
		</div>
          </div>
        </div>
        <!-- End Panel -->
	</div>
    </div>
    <!-- End Page -->

    <jsp:include page="../common/footer.jsp" flush="true"/>
    
    <!-- custom  -->
    <script src="/js/common/board.js"></script>
    
    <script src="/js/Plugin/summernote.js"></script>
