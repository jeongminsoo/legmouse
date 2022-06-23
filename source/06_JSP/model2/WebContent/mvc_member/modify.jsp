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
			$('#emailChkResult').html('사용 가능한 이메일입니다');
			$('input[name="mpw"], input[name="mpwchk"]').keyup(function(){
				var mpw = $('input[name="mpw"]').val();
				var mpwchk = $('input[name="mpwchk"]').val();
				if (mpw == mpwchk) {
					$('#pwChkResult').html("비밀번호 일치");
				} else {
					$('#pwChkResult').html("두 비밀번호가 일치하지 않습니다");
				}
			});
			$('input[name="memail"]').keyup(function(){
				var newmemail = $('input[name="memail"]').val();
				if (memail != newmemail) {
					$.ajax({
						url : '${conPath}/emailChk.do',
						data : 'memail=' + newmemail,
						type : 'post',
						dataType : 'html',
						success : function(data){
							$('#emailChkResult').html(data);
						}
					});
				} else {
					$('#emailChkResult').html('사용 가능한 이메일입니다');
				}
			});
			$('form').submit(function(){
				var mpw = '${member.mpw}';
				var oldpw = $('input[name="oldpw"]').val();
				var pwchk = $('#pwChkResult').text().trim() == '' ? '비밀번호 일치' : $('#pwChkResult').text().trim();
				var emailchk = $('#emailChkResult').text().trim();

				if (oldpw != mpw ) {
					alert('현재 비밀번호가 다릅니다')
					return false;
				} else if ((pwchk != '비밀번호 일치') || (pwchk == '')) {
					alert('비밀번호를 확인하세요');
					return false;
				} else if (emailchk != '사용 가능한 이메일입니다') {
					alert('사용 가능한 이메일로 가입하세요');
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
	<jsp:include page="../main/header.jsp"/>
	<div id="join_wrap">
		<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>정보수정</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" value="${member.mid }" readonly="readonly">
					</td>
					<td rowspan="4"><img src="${conPath }/mPhotoUp/${member.mphoto}" width="100"></td>
				</tr>
				<tr>
					<th>현재비밀번호</th>
					<td>
						<input type="password" name="oldpw" required="required">
					</td>
				</tr>
				<tr>
					<th>새비밀번호</th>
					<td>
						<input type="password" name="mpw">
					</td>
				</tr>
				<tr>
					<th>새비밀번호확인</th>
					<td>
						<input type="password" name="mpwchk">
						<div id="pwChkResult"> </div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2">
						<input type="text" name="mname" required="required" value="${member.mname }">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="2">
						<input type="email" name="memail" required="required" value="${member.memail }">
						<div id="emailChkResult"> </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td colspan="2">
						<input type="file" name="mphoto">
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan="2">
						<input type="text" name="tempbirth" id="datepicker" value='${member.mbirth eq null ? "" : member.mbirth}'>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2">
						<input type="text" name="maddress" value='${member.maddress eq null ? "" : member.maddress }'>
					</td>
				</tr>

			</table>
			<p>
				<input type="submit" value="정보수정" class="btn">
				<input type="button" value="메인으로" class="btn" onclick="location.href='${conPath}/main/main.jsp'">
			</p>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>