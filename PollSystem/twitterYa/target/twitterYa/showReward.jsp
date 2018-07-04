<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reward 好爽哦!</title>
	<style>
        .itemImg{
            width:200px;
            height:80px;
            position:relative;
            right:250px;
        }
        .itemText{
            font-size:26px;
            position:relative;
            right:80px;
        }
        .btn {
          width:100px;
          height:80px;
     	}
	</style>
</head>
<body>
	 <table align="center">
        <tr style="font-size:22px; text-decoration:underline;">
            <td style="position:relative; right:180px;"> 物 品 圖 片</td>
            <td> 物 品 名 稱</td>
            <td> 兌 換 序 號</td>
        </tr>
       	<%
		int reward1 = (Integer)request.getAttribute("reward1");
   		int reward2 = (Integer)request.getAttribute("reward2");
   		int reward3 = (Integer)request.getAttribute("reward3");
   		String tag = "";
       		String[] alphaStr = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
       		for(int i=0;i<reward1;i++)
       		{
       			tag = "";
       			for(int j=0;j<20;j++)
       			{
       				tag += alphaStr[(int) (Math.random()*36)];
       			}
       			out.print("<tr><td><img src='mmm.jpg' class='itemImg' /></td><td class='itemText'> 麥當勞套餐兌換卷</td><td>"+ tag + "</td></tr>");
       		}
       		for(int i=0;i<reward2;i++)
       		{
       			tag = "";
       			for(int j=0;j<20;j++)
       			{
       				tag += alphaStr[(int) (Math.random()*36)];
       			}
       			out.print("<tr><td><img src='startbark.jpg' class='itemImg' /></td><td class='itemText'> 星巴克咖啡類兌換卷</td><td>" + tag + "</td></tr>");
       		}
       		for(int i=0;i<reward3;i++)
       		{
       			tag = "";
       			for(int j=0;j<20;j++)
       			{
       				tag += alphaStr[(int) (Math.random()*36)];
       			}
       			out.print("<tr><td><img src='711shopping.png' class='itemImg' /></td><td class='itemText'> 7-11購物金50元</td><td>" + tag + "</td></tr>");
       		}
       	%>
    </table>
    <form action="exchangePage.jsp">
    	<input type="submit" value="確定" class="btn" >
    </form>
    
</body>
</html>