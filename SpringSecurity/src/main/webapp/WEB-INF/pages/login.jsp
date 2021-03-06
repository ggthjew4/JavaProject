<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />">
<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>

<title>登入</title>
</head>
<body>
   <div class="container">
      <form class="form-signin" name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
         <font style="color:red">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</font>
         <h2 class="form-signin-heading">Please sign in</h2>
         User:
         <input type='text' class="input-block-level" name='j_username' value=''>
         Password:
         <input type='password' class="input-block-level" name='j_password' />
         <label class="checkbox">
            <input type="checkbox" name="_spring_security_remember_me" />Remember Me
         </label>
         <button name="submit" type="submit" value="Login" class="btn btn-large btn-primary">Login</button>
      </form>
   </div>
   <c:set var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" value="${null}"/>
</body>
</html>