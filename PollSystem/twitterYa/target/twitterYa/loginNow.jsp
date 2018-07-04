<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login in now</title>
    <style>
        .loginOutButton {
            width: 125px;
            height: 50px;
        }

        .getRewardButton {
            width: 125px;
            height: 50px;
            position: relative;
            top: 92px;
        }

        .headImg {
            width: 200px;
            height: 220px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>
                <img src="noone.jpg" class="headImg">
            </td>
            <td>
                <form method="post" action="logoutServlet">
                    <h2>名稱 : <span>${nowUser["name"]}</span></h2>
                    <h2>帳號 : <span>${nowUser["accountNumber"]}</span></h2>
                    <h2>點數 : <span>${nowUser["point"]}</span></h2>
                    <br />
                    <input type="submit" value="登出" class="loginOutButton" />
                </form>
            </td>
            <td>
                <form method="get" action="exchangePage.jsp">
                    <input type="submit" value="兌換" class="getRewardButton" />
                </form>
            </td>
        </tr>

    </table>
</body>
</html>