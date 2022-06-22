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
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[name="mId"]').keyup(function(){
				var mId = $('input[name="mId"]').val();
				$.ajax({
					url : '${conPath}/idConfirm.do',
					data : 'mId=' + mId,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#idConfirmResult').html(data);
					}
				});
			});
			$('input[name="mpw"], input[name="mpwchk"]').keyup(function(){
				var mpw = $('input[name="mpw"]').val();
				var mpwchk = $('input[name="mpwchk"]').val();
				if (mpw == mpwchk) {
					$('#pwChkResult').html('두 비밀번호가 일치합니다');
				} else {
					$('#pwChkResult').html('두 비밀번호가 일치하지 않습니다');
				}
				
			});
			$('form').submit(function(){
				var idConfirm = $('#idConfirmResult').text().trim();
				var pwChk = $('#pwChkResult').text().trim();
				if (idConfirm != '사용 가능한 ID입니다') {
					alert('사용 가능한 ID로 가입하세요');
					return false;
				} else if (pwChk != '두 비밀번호가 일치합니다') {
					alert('비밀번호를 확인하세요');
					return false;
				} 
			});
		});
	</script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script>
  	$(function() {
    	$('#datepicker').datepicker({
    		dateFormat : 'yy-mm-dd',
    		changeMonth : true,
    		monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    		showMonthAfterYear : true,
        	yearSuffix : '년',
        	showOtherMonths : true,
        	dayNamesMin:['일','월','화','수','목','금','토'],
			changeYear : true,
			minDate : '-100y',
			maxDate : 'y',
			yearRange : 'c-100:c+100'
    	});
  	});
  </script>
</head>
<body>
	<form action="">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mId" required="required">
					<div id="idConfirmResult"></div>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpw" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td>
					<input type="password" name="mpwchk" required="required">
					<div id="pwChkResult"></div>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" id="datepicker" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>