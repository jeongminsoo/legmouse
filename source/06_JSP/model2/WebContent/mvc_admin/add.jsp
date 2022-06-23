<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/join.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[name="aid"]').keyup(function(){
				var aid = $('input[name="aid"]').val();
				$.ajax({
					url : '${conPath}/aidChk.do',
					data : 'aid=' + aid,
					type : 'post',
					dataType : 'html',
					success : function(data){
						$('#aidChkResult').html(data);
					}
				});
			});

			$('form').submit(function(){
				var idchk = $('#aidChkResult').text().trim();
				if (idchk != '사용 가능한 아이디입니다') {
					alert('사용 가능한 아이디로 가입하세요');
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="join_wrap">
		<form action="${conPath }/add.do" method="post">
			<table>
				<caption>관리자 추가</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="aid" required="required">
						<div id="aidChkResult"></div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="apw" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="aname" required="required">
					</td>
				</tr>
			</table>
			<p>
				<input type="submit" value="관리자 추가" class="btn">
			</p>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>