<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('button').click(function(){
				var mId = $('input[name="mId"]').val();
				$.ajax({
					// url : 요청경로
					// data : 요청파라미터
					// type : get방식/post방식    (안쓰면get방식)
					//dataType : html/json/... 요청한 경로로 실행한 결과 타입
					// success : 성공시 콜백함수(data){}
					// error : 실패시 콜백함수
					url : 'idConfirm.jsp',
					data : 'mId='+mId,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#result').html(data);
					},
					error : function(code){
						alert(code.status + code.statusText);
					}
				});
			});
		});
	</script>
</head>
<body>
	<p>
		아이디 <input type="text" name="mId" id="mId"> <button>중복체크</button>
	</p>
	<span id="result"></span>
</body>
</html>