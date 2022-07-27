<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
	</style>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
  		$( function() {
	 	 $("#datepicker").datepicker({
		 	 dateFormat : 'yy-mm-dd',
				monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토'],
				showMonthAfterYear : true,
				showOtherMonths : true,
				selectOtherMonths : false,
				yearSuffix : '년',
	  		});
  		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/book.do?method=add" method="post" enctype="multipart/form-data">
			
		<table>
			<tr>
				<th>책이름</th>
				<td>
					<input type="text" name="btitle">
				</td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="bwriter"></td>
			</tr>
			<tr>
				<th>출판일</th>
				<td><input type="text" name="brdate" id="datepicker"></td>
			</tr>
			<tr>
				<th>책이미지</th>
				<td><input type="file" name="tempbimg1"></td>
			</tr>
			<tr>
				<th>책이미지</th>
				<td><input type="file" name="tempbimg2"></td>
			</tr>
			<tr>
				<th>책소개</th>
				<td><textarea name="binfo"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록">
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>