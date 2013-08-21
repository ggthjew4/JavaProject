<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />">
      <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-responsive.min.css" />">
      <title>Login Page Index</title>
   </head>
   <body>
      <sec:authentication property="authorities" var="authorities" scope="page"/>
      <p><a href="<c:url value="/j_spring_security_logout"/>">登出</a></p>
      <sec:authorize ifAnyGranted="ROLE_USER">
        <p><a>電影介紹</a></a></p>
        <p><a>場次查詢</a></a></p>
        <p><a>線上訂票</a></a></p>
      </sec:authorize><br>
      <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <p><a>電影維護</a></a></p>
        <p><a>場次維護</a></a></p>
        <p><a>帳戶管理</a></a></p>
      </sec:authorize>
   </body>
</html>