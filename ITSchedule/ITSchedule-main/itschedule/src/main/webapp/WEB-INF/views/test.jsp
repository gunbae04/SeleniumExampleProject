<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">

    <head>
        
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=0,maximum-scale=10,user-scalable=no">

    </head>
    
    <body>
    <script>
    	/*
		var maxCnt = 10;
		
		for(var i=maxCnt; i>0; i--) {
			if( i % 2 == 0) {
				
				//공백
				var spaceCnt = maxCnt -i;
				
				for(var j=0; j<spaceCnt; j++) {
					document.write("&nbsp;");
				}
				
				for(var j=spaceCnt; j<maxCnt; j++) {
					//*
					document.write("*");
				}
				document.write("<br>");
			}
		}
		*/
		document.write("<h2>나무 그리기: 왼쪽부터 짝수로 줄어드는 나무</h2>");
		document.write("<div class='tree'>");
		for (var npi=10; npi>=1; npi=npi-2){
			console.log(npi);
			var spaceCnt = 10-npi;
			
			for(var spc=0; spc <=spaceCnt; spc++){
				document.write("&nbsp;");
			}	
			for(var skr=0; skr <= npi; skr++){
				document.write("*");
			}
			document.write("<br/>");
		}
		document.write("</div>");

    </script>

	</body>
</html>
