
	var boardListSearch = function(){
	    if(window.event.keyCode == 13) {
	    	boardListGet('1');
	    }
    }

    var boardListGet = function(page){
    	
      	if(page === null || page === ''){
		 	page = '1';
	  	}
    	
    	document.getElementById('pageNum').value = page;
    	
    	var searchTitle = $("#searchTitle").val();
    	
    	let url = '/board/list';
    	url += `?pageNum=${page}&searchTitle=${searchTitle}`;
    	    	
    	location.href = url;
    }
    
    $(".add_board_btn").click(function() {
    	
    	if(confirm('등록 하시겠습니까?')){
    		
    		$('textarea[name="contentArea"]').val($('#note-editable').summernote('code'));
        	
        	var content = $("#contentArea").val();
        	
        	var title = $("#title").val();
    		
    		var param = {
    				title : title,
    				content : content
    		};
    		
    		$.ajax({
    			url: '/board/addAction',
    			dataType: "JSON",
    			data: param,
    			type: "POST",
    			success: function(dom) {
    				if(dom == "1"){
    					alert("등록 되었습니다.");
    					location.href = '/board/list';
    				}else{
    					alert("등록에 실패 하였습니다.");
    					return false;
    				}
    			},
    			error: function(request,status,error){
    				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    			}
    		});
    		
    	
    	}
    	
    });
    
    $(".editA_board_btn").click(function() {
    	
    	if(confirm('수정 하시겠습니까?')){
    		var memberId = $("#memberId").val();
    		var boardId = $("#boardId").val();
    			
    		$('textarea[name="contentArea"]').val($('#note-editable').summernote('code'));
    		
    		var content = $("#contentArea").val();
    		
    		var title = $("#title").val();
    		
    		var boardId = $("#boardId").val();
    		
    		var param = {
    				title : title,
    				content : content,
    				memberId : memberId,
    				boardId : boardId
    		};
    		
    		$.ajax({
    			url: '/board/editAction',
    			dataType: "JSON",
    			data: param,
    			type: "POST",
    			success: function(dom) {
    				if(dom == "1"){
    					alert("수정 되었습니다.");
    					location.reload();
    				}else{
    					alert("등록에 실패 하였습니다.");
    					return false;
    				}
    			},
    			error: function(request,status,error){
    				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    			}
    		});
    		
    		
    	}
    	
    });
    
    $(".del_board_btn").click(function() {
    	
    	if(confirm('삭제 하시겠습니까?')){
    		var memberId = $("#memberId").val();
    		var boardId = $("#boardId").val();
    			
    		var param = {
    				memberId : memberId,
    				boardId : boardId
    		};
    		
    		$.ajax({
    			url: '/board/delAction',
    			dataType: "JSON",
    			data: param,
    			type: "POST",
    			success: function(dom) {
    				if(dom == "1"){
    					alert("삭제 되었습니다.");
    					location.href = '/board/list';
    				}else{
    					alert("등록에 실패 하였습니다.");
    					return false;
    				}
    			},
    			error: function(request,status,error){
    				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    			}
    		});
    		
    		
    	}
    	
    });
    
    $(".view_board").click(function() {
    	
    	var id = $(this).attr("value");

    	location.href = '/board/view?boardId='+id;
    });
    
    $(".edit_board_btn").click(function() {
    	
    	var id = $(this).attr("value");
    	
    	location.href = '/board/edit?boardId='+id;
    });
    
    $(".back_board_btn").click(function() {
    	
    	var referrer =  document.referrer;
    	
    	if(referrer.indexOf("main") != -1) {
    		location.href= '/board/list';
    	}else{
    		window.history.back();
    	}
    });
    
    $(".search_btn").click(function() {
    	
    	var title = $("#searchTitle").val();
    	
    	location.href= '/board/list?searchTitle='+title;
    	
    	
    });
    
    
    
    