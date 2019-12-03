<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>유저리스트</h4>
<div id="rDiv">
</div>
<button onclick="getUserList()">가져오기</button>


<script>
function getUserList(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/userinfos');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==xhr.DONE){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				console.log(res);
				var html = '';
				html += '<table border="1">';
				html += '<tr>';
				html += '<td>번호</td>';
				html += '<td>이름</td>';
				html += '<td>아이디</td>';
				html += '<td>가입날짜</td>';
				for(var i=0; i<res.length; i++){
					html += '<tr>';
					html += '<td>' + res[i].ui_NUM + '</td>';
					html += '<td>' + res[i].ui_NAME + '</td>';
					html += '<td>' + res[i].ui_ID + '</td>';
					html += '<td>' + res[i].credat + '</td>';
					html += '</tr>';
					
				}
				html += '</table>';
				document.querySelector('#rDiv').innerHTML = html;
			}
			
		}
	}
	xhr.send();
}

</script>
</body>
</html>