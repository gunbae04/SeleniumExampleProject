$("#school_box").change(function(){
	var value = $(this).val();
	
	
	if(value != ""){
		
		var param = {
			schoolId : value
	    };
		
		//get New campusList
		$.ajax({
			url: '/campusList',
	    	dataType: "JSON",
	    	data: param,
	    	type: "POST",
	    	success: function(dom) {
	    		if(dom.campusList.length > 0 ){
	    			
	    			$("#campus_box option").remove();
	    			$("#campus_box").append("<option value=''>캠퍼스</option>");
	    			for(var i=0; i<dom.campusList.length; i++){
	    				$("#campus_box").append("<option value='"+dom.campusList[i].campusId+"'>"+dom.campusList[i].camName+"</option>");
	    			}
	    		}
	    		
	    		if(dom.majorList.length > 0 ){
	    			
	    			$("#major_box option").remove();
	    			$("#major_box").append("<option value=''>학과</option>");
	    			for(var i=0; i<dom.majorList.length; i++){
	    				$("#major_box").append("<option value='"+dom.majorList[i].majorId+"'>"+dom.majorList[i].majName+"</option>");
	    			}
	    		}
	    		
	    		$("#isSnum").attr("value","0");
				$("#isId").attr("value","0");
	    		
	    		
	    	},
	    	error: function(request,status,error){
	      		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	}
	  	});
		
		
	}
	
});

$("#campus_box").change(function(){
	var value = $(this).val();
	var schoolId = $("#school_box").val();
	
	
	if(value != ""){
		
		var param = {
				schoolId : schoolId,
				campusId : value
		};
		
		//get New majorList
		$.ajax({
			url: '/majorList',
			dataType: "JSON",
			data: param,
			type: "POST",
			success: function(dom) {
				
				if(dom.majorList.length > 0 ){
					
					$("#major_box option").remove();
					$("#major_box").append("<option value=''>학과</option>");
					for(var i=0; i<dom.majorList.length; i++){
						$("#major_box").append("<option value='"+dom.majorList[i].majorId+"'>"+dom.majorList[i].majName+"</option>");
					}
				}
				$("#isSnum").attr("value","0");
				$("#isId").attr("value","0");
				
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
		
	}
	
});

$("#major_box").change(function(){
	
	$("#isSnum").attr("value","0");
	$("#isId").attr("value","0");
	
});


$(".btn_check_snum").click(function() {
	
	var snum = $("#userSnum").val();
	var schoolId = $("#school_box").val();
	
	if(schoolId == ""){
		alert("학교를 선택해주세요.");
		return false;
		
	}
	
	if(snum != ""){
		
		var param = {
				sCode : snum,
				schoolId : schoolId
		};
		
		//학번 중복확인
		$.ajax({
			url: '/checkSnum',
			dataType: "JSON",
			data: param,
			type: "POST",
			success: function(dom) {
				if(dom > 0){
					$("#isSnum").attr("value","1");
					alert("사용가능한 학번 입니다.");
				}else{
					$("#isSnum").attr("value","0");
					alert("중복된 학번입니다.");
				}
				
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
		
	}
	
});

$(".btn_check_id").click(function() {
	
	var id = $("#userId").val();
	
	if(id != ""){
		
		var param = {
				loginId : id
		};
		
		//아이디 중복확인
		$.ajax({
			url: '/checkId',
			dataType: "JSON",
			data: param,
			type: "POST",
			success: function(dom) {
				console.log(dom);
				if(dom > 0){
					$("#isId").attr("value","1");
					alert("사용가능한 아이디 입니다.");
				}else{
					$("#isId").attr("value","0");
					alert("다른 아이디를 입력하세요.");
				}
				
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
		
	}
	
});

$(".btn_auth").click(function() {
	var userName = $("#username").val();
	var pnum = $("#phone").val();
	
	if(userName == ""){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if(pnum == ""){
		alert("전화번호을 입력해주세요.");
		return false;
	}
	
	var param = {
			userName : userName,
			pnum : pnum
	};
	
	$.ajax({
		url: '/authkakao',
		dataType: "JSON",
		data: param,
		type: "POST",
		success: function(dom) {
			
			if(dom.result == "1"){
				$("#authCodeId").attr("value",dom.msgId);
				alert("전송되었습니다.");
				$("#authView").show();
			}else{
				alert("다시 시도해주세요.");
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
});

$(".btn_auth_ing").click(function() {
	var authCodeId = $("#authCodeId").attr("value");
	var authCode = $("#authCode").val();
	
	if(authCodeId == ""){
		alert("인증코드발송을 눌러주세요.");
		return false;
	}
	
	if(authCode == ""){
		alert("인증번호를 입력해주세요.");
		return false;
	}
	
	console.log(authCodeId+"\n"+authCode);
	
	var param = {
			msgId : authCodeId,
			authCode : authCode
	};
	
	//btn_auth_ing
	$.ajax({
		url: '/authkakaoCheck',
		dataType: "JSON",
		data: param,
		type: "POST",
		success: function(dom) {
			
			if(dom.result == "1"){
				$(".btn_auth").attr("disabled",true); 
		    	$("#phone").attr("readonly",true);
		    	
		    	$(".btn_auth_ing").attr("disabled",true); 
		    	$("#authCode").attr("readonly",true);
		    	
		    	$("#iskakaoAuth").attr("value","1");
		    	
		    	
				alert("인증되었습니다.");
			}else{
				alert("다시 시도해주세요.");
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
});



$(".btn_add_action").click(function() {
	
	var schoolId = $("#school_box option:selected").val();
	var campusId = $("#campus_box option:selected").val();
	var majorId = $("#major_box option:selected").val();
	var name = $("#username").val();
	var stuCode = $("#userSnum").val();
	var userId = $("#userId").val();
	var password = $("#userpassword").val();
	var password2 = $("#userpassword2").val();
	var pnum = $("#phone").val();
	var email = $("#userEmail").val();
	var isSnum = $("#isSnum").val();
	var isId = $("#isId").val();
	var sex = $("#sex_box option:selected").val();
	var grade = $("#grade_box option:selected").val();
	var joinCode = $("#join_code").val();
	var iskakaoAuth = $("#iskakaoAuth").attr("value");
	
//	console.log(schoolId+"\n"+campusId+"\n"+majorId+"\n"+name+"\n"+grade+"\n"+sex+"\n"+stuCode+"\n"+userId+"\n"+password+"\n"+pnum+"\n"+email+"\n"+sex+"\n"+grade);
//	console.log();
	
	if(schoolId == ""){
		alert("학교를 선택해주세요.");
		return false;
	}
	
	if(campusId == ""){
		alert("캠퍼스를 선택해주세요.");
		return false;
	}
	
	if(majorId == ""){
		alert("전공을 선택해주세요.");
		return false;
	}
	
	if(name == ""){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if(stuCode == ""){
		alert("학번을 입력해주세요.");
		return false;
	}
	
	if(userId == ""){
		alert("아이디을 입력해주세요.");
		return false;
	}
	
	if(password == "" || password2 == ""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	
	if(password != password2){
		alert("비밀번호를 확인해주세요.");
		return false;
	}
	
	if(pnum == ""){
		alert("전화번호을 입력해주세요.");
		return false;
	}
	
	if(email == ""){
		alert("이메일을 입력해주세요.");
		return false;
	}
	
	if(isSnum == "0"){
		alert("학번 중복체크를 해주세요.");
		return false;
	}
	
	if(isId == "0"){
		alert("아이디 중복체크를 해주세요.");
		return false;
	}
	if(iskakaoAuth == "0"){
		alert("핸드폰 번호를 인증해주세요.");
		return false;
	}
	if(joinCode == ""){
		alert("가입코드를 입력해주세요.");
		return false;
	}
	
	
	if(isSnum == "1" && isId == "1"){
		
		var param = {
				schoolId : schoolId,
				campusId : campusId,
				majorId : majorId,
				stuCode : stuCode,
				auth : "4",
				username : name,
				pnum : pnum,
				email : email,
				loginId : userId,
				password : password,
				sex : sex,
				grade: grade,
				joinCode : joinCode
		};
		
		//아이디 중복확인
		$.ajax({
			url: '/signupIng',
			dataType: "JSON",
			data: param,
			type: "POST",
			success: function(dom) {
				if(dom == "1"){
					location.href = "/login";
				}else if(dom == "2"){
					alert("가입코드가 잘못되었습니다.");
					return false;
				}else{
					alert("중복된 아이디입니다.\n회원가입에 실패 하였습니다.");
					return false;
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
	
	}
	
});

$(".btn_find_action").click(function() {
	
	var schoolId = $("#school_box option:selected").val();
	var campusId = $("#campus_box option:selected").val();
	var majorId = $("#major_box option:selected").val();
	var name = $("#username").val();
	var stuCode = $("#userSnum").val();
	var userId = $("#userId").val();
	var pnum = $("#phone").val();
	var iskakaoAuth = $("#iskakaoAuth").attr("value");
	
	if(schoolId == ""){
		alert("학교를 선택해주세요.");
		return false;
	}
	
	if(campusId == ""){
		alert("캠퍼스를 선택해주세요.");
		return false;
	}
	
	if(majorId == ""){
		alert("전공을 선택해주세요.");
		return false;
	}
	
	if(name == ""){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if(stuCode == ""){
		alert("학번을 입력해주세요.");
		return false;
	}
	
	if(userId == ""){
		alert("아이디을 입력해주세요.");
		return false;
	}
	
	if(pnum == ""){
		alert("전화번호을 입력해주세요.");
		return false;
	}
	
	if(iskakaoAuth == "0"){
		alert("핸드폰 번호를 인증해주세요.");
		return false;
	}
	
		
	var param = {
			schoolId : schoolId,
			campusId : campusId,
			majorId : majorId,
			stuCode : stuCode,
			auth : "4",
			username : name,
			pnum : pnum
	};
	
	//아이디 중복확인
	$.ajax({
		url: '/findId',
		dataType: "JSON",
		data: param,
		type: "POST",
		success: function(dom) {
			if(dom.result == "1"){
				if(dom.loginId == ""){
					alert("없는 아이디 입니다.");
					return false;
				}
				if(confirm('등록하신 아이디가 '+ dom.loginId +' 맞습니까?')){
					
					
					location.href = "/changePassword?schoolId="+dom.schoolId+"&campusId="+dom.campusId+"&majorId="+dom.majorId+"&userId="+dom.userId;
				}
				
			}else{
				alert("없는 유저입니다.");
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
		
});

$(".btn_password_action").click(function() {
	
	var schoolId = $("#schoolId").attr("value");
	var campusId = $("#campusId").attr("value");
	var majorId = $("#majorId").attr("value");
	var userId = $("#userId").attr("value");
	var password = $("#userpassword").val();
	var password2 = $("#userpassword2").val();
	
	if(schoolId == "" || campusId == "" || majorId == "" || userId == ""){
		alert("다시 진행해주세요.");
		return false;
	}
	
	if(password == "" || password2 == ""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	
	if(password != password2){
		alert("비밀번호를 확인해주세요.");
		return false;
	}
	
	
	
	var param = {
			schoolId : schoolId,
			campusId : campusId,
			majorId : majorId,
			userId : userId,
			password : password
	};
	
	//아이디 중복확인
	$.ajax({
		url: '/changePasswordAction',
		dataType: "JSON",
		data: param,
		type: "POST",
		success: function(dom) {
			if(dom.result == "1"){
				alert("변경이 완료되었습니다.");
				location.href = '/login';
				
			}else{
				alert("없는 유저입니다.");
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
});
