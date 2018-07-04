<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<title>Success</title>
    <script type="text/javascript">
        var t = 7;
        function showTime() {
            t -= 1;
            document.getElementById('timeLeave').innerHTML = t;

            if (t == 0) {
                location.href = 'mainPage.jsp';
            }

            //每秒執行一次,showTime()
            setTimeout("showTime()", 1000);
        }
       
    </script>
</head>
<body onload="showTime()">
		${successMessage}
	 <a href="mainPage.jsp">返回首頁</a>
	 <p>網頁將於 <span id="timeLeave">7</span> 秒後離開...</p>
</body>
</html>