<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-responsive.min.css" />">
<title>Insert title here</title>
</head>
<body>
<H1>${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</H1>
<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="_spring_security_remember_me" />Remember Me</td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>