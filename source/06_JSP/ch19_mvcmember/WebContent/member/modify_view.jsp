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
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<style>
		table {
			background-color : black;
			text-align : center;
		}
		tr {
			background-color : white;
		}
	</style>
</head>
<body>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value='${member.mid eq null ? "" : member.mid }' readonly="readonly"></td>
				<td rowspan="10"><img src="${conPath }/mPhotoUp/${member.mphoto}"><br>${member.mphoto == null ? "" : member.mphoto }</td>
			</tr>
			<tr>
				<th>현재비밀번호</th>
				<td><input type="password" name="oldpw" required="required"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<th>새비밀번호확인</th>
				<td><input type="password" name="mpwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value='${member.mname eq null ? "" : member.mname }' required="required"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="memail" value='${member.memail eq null ? "" : member.memail }'></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="mphoto"></td>
				
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempbirth" value='${member.mbirth eq null ? "" : member.mbirth }' required="required"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="maddress" value='${member.maddress eq null ? "" : member.maddress }'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보수정" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>