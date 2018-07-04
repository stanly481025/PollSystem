<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Account Layout display</title>
    <style>
        .loginInButton {
            width:125px;
            height:50px;
        }
        .singInButton{
            width:125px;
            height:50px;
            position:relative;
            right:125px;
            top:96px;
        }
        .inputText {
            width:250px;
            height:20px;
        }
        .headImg{
            width:200px;
            height:220px;
        }
		.twBtn{
		    width:125px;
            height:50px;
		}
    </style>

</head>
<body>
<c:if test="${sessionScope.loginStatus eq 'logIn' }">
	<c:redirect url="loginNow.jsp"/>
</c:if>
    <table>
        <tr>
            <td>
                <img src="noone.jpg" class="headImg">
            </td>
            <td>
                <form method="post" action="loginInServlet">
                    <h4>帳號:</h4>
                    <input type="text" class="inputText" name="accountNumber" required="required" />
                    <h4>密碼:</h4>
                    <input type="password" class="inputText" name="password" required="required" />
                    <br /><br />
                    <input type="submit" value="登入" class="loginInButton" />
                </form>
            </td>
            <td>
                <form method="get" action="signInPage.html">
                    <input type="submit" value="註冊" class="singInButton"/>
                </form>
            </td>
            
        </tr>

    </table>
</body>
</html>