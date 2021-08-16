var mainListSearch = function(){
    if(window.event.keyCode == 13) {
    	mineListGet('1');
    }
}

var mineListGet = function(page){
	
  	if(page === null || page === ''){
	 	page = '1';
  	}
	
	document.getElementById('pageNum').value = page;
	
	let url = '/mine';
	url += '?pageNum='+page;
	
	location.href = url;
}

$(".btn_my_program").click(function() {
	
	location.href = "/mine";
});

$(".btn_lec").click(function() {
	
	location.href = "/lecture/list";
});

$(".btn_self").click(function() {
	location.href = "/self/list";
	
});

$(".btn_lec_review").click(function() {
	
	location.href = "/study/lecReviewList";
});

$(".btn_copy").click(function() {
	var urlbox = $(this).prev();
	urlbox.select(); //복사할 텍스트를 선택
	document.execCommand("copy") //클립보드 복사 실행
	alert("클립보드에 복사 되었습니다.");
});

$(".btn_enter").click(function() {
	var url = $(this).attr("value");
	
	if(url != ""){
		window.open(url, "_blank");
	}
	
	
});

$(".btn_view_mine").click(function() {
	var id = $(this).attr("value");
	var type = $(this).attr("value2");
	var modalType = $(this).attr("value3");
	
	var url = "#";
	if(type == "online_lecture"){
		//url = "/lecture/view?lecId="+id;
		url = "/lecture/submitModal2?lecId="+id+"&modalType="+modalType;
	}else if(type == "online_self"){
//		url = "/self/view?selfId="+id;
		url = "/self/submitModal2?selfId="+id+"&modalType="+modalType;
	}else if(type == "online_meeting"){
//		url = "/meeting/view?meetingId="+id;
		url = "/meeting/submitModal2?meetingId="+id+"&modalType="+modalType;
	}else if(type == "online_consulting"){
//		url = "/consulting/view?consultingId="+id;
		url = "/consulting/submitModal2?consultingId="+id+"&modalType="+modalType;		
	}
	
	location.href = url;
});

$(".btn_cancel").click(function() {
	var id = $(this).attr("value");
	var type = $(this).attr("value2");
	
	if(confirm('정말 취소 하시겠습니까?')){
		var url = "";
		if(type == "online_lecture"){
			url = "/lecture/applyCancel";
		}else if(type == "online_self"){
			url = "/self/applyCancel";
		}else if(type == "online_meeting"){
			url = "/meeting/applyCancel";
		}else if(type == "online_consulting"){
			url = "/consulting/applyCancel";
		}
		
		var param = {
				lecId : id
	    };
		
		$.ajax({
			url: url,
	    	dataType: "JSON",
	    	data: param,
	    	type: "POST",
	    	success: function(dom) {
	    		
	    		let result = dom.result;
    			if(result > 0){
    				alert("취소 완료");
    				location.reload();
	    		}
	    	},
	    	error: function(request,status,error){
	      		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	}
	  	});
	  	
	}
	
	
});