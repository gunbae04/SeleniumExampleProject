$(".btn_add_action").click(function() {
	
	var userName = $("#userName").val();
	var userId = $("#userId").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	
	if(userName == ""){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if(userId == ""){
		alert("아이디을 입력해주세요.");
		return false;
	}
	
	if(password1 == "" || password2 == ""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	
	if(password1 != password2){
		alert("비밀번호를 확인해주세요.");
		return false;
	}
	
	if(confirm('가입 하시겠습니까?')){
		
		var param = {
				userName : userName,
				userId : userId,
				password : password1
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
					alert("아이디가 중복됩니다");
					return false;
				}else{
					alert("회원가입에 실패 하였습니다.");
					return false;
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
		
	
	}
});
