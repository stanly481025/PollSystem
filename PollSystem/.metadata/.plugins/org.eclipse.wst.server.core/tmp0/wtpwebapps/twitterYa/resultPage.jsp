<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="pollSystem.*"%>
<%@ page import="PollData.*"%>
<html>
   <head>
      <meta charset = "utf-8">
      <title>結果</title>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="d3.min.js"></script>
      <script>
		 
		 var count = 0;    //接上後可忽略
		 var countt = 0;
		 var x = "";
		 var E = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			              "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ",
						  "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR", "BS", "BT", "BU", "BV", "BW", "BX", "BY", "BZ"];
		 
		 function addQ(y, total)
		 {
			var r = 0;
			var g = 0;
			var b = 0;
			//var tt = Math.floor(Math.random()*5)+2;//選項數目
			//console.log("add:" + tt);
			//測試內容
			//var quest = "quest";
			//此處加入標題
			var ttt = 400;
			var options = [];
			var number = 0;
			
			var gg=[];
			var count =0;
			var tot=0;
			var i;
			while( 0 < y )
			{
				var n= parseInt(document.getElementById("A0"+count).getAttribute("value"));
				for(var i=0;i<n;i++)
				{
					gg.push(parseInt(document.getElementById(E[i+tot]).getAttribute("value")));
				}
				console.log(gg);
				
				
				var value = parseInt(parseInt(document.getElementById(E[i]).getAttribute("value")));
				
				
				var div_data_bind = d3.select("#" + E[tot]).selectAll('div').data(gg)
				div_set = div_data_bind.enter().append("div");
				div_data_bind.exit().remove();
				
				console.log(value);
				div_set.style("width", function(d,i) {
					console.log("change");
					//console.log(d);
	                return (100 + d/total*400)+"px";
	                
	            });
				//div_set.style("position", "absolute");
				div_set.style("left", "10%");
				div_set.style("top", "10%");
				div_set.style("font-size", "25px");
				div_set.style("height", "30px");
				div_set.style("color", "black");
	            div_set.style("background", "red");
				div_set.style("margin-top", "13px");
				div_set.style("margin-left", "50px");
				r = Math.floor((Math.random() * 255) + 1);
				g = Math.floor((Math.random() * 255) + 1);
				b = Math.floor((Math.random() * 255) + 1);
				div_set.style("background-color", function(d,i) {
					console.log("cchange");
	                return "rgb("+ r + "," + g + "," + b + ")";
	            });
				
				
				gg=[];
				tot=tot+n;
				y=y-n;
				count=count+1;
			}
			
			/*
			console.log(options);
			var div_data_bind = d3.select("#" + E[countt]).selectAll("div").data(options);
			console.log(div_data_bind);
			
			div_set = div_data_bind.enter().append("div");
			div_data_bind.exit().remove();
			
			var top = 50;
			
			div_set.text(function(d, i)
			{
				return i + " / " + d[2];
			});
			div_set.style("top", function(d, i)
			{
				return  (50 + i *40) + "px"
			});
			
			div_set.style("position", "absolute");
			div_set.style("left", "10%");
			div_set.style("font-size", "25px");
			div_set.style("height", "30px");
			div_set.style("color", "black");
            div_set.style("background", "red");
			div_set.style("margin-top", "20px");
            div_set.style("width", function(d,i) {
                return (d[2] * 5)+"px";
            });
			
			countt++; 
			console.log("add one block");
			*/
		 }
		 
		 function test()
		 {
			totalOption = parseInt(document.getElementById( "littleSheepWithFire" ).getAttribute("value"));
			total = parseInt(document.getElementById( "girlIsOnFire" ).getAttribute("value"));
			addQ(totalOption, total);
			/*
			count = ;
			for(var i = 0; i < count; i++)
			{
				addQ(i);
			}*/
		 }

		 
		 //網頁起始設定
         function start()
         {
			//改上面圖片 做好玩的
            var x = Math.floor(Math.random()*5)+1;
			document.getElementById( "image" ).setAttribute("style", "background-image: url('img/" + x + ".jpg');");
			
			//依解析度改位置
			var w = (screen.width - 450)/2-40;
			document.getElementById( "titleD" ).setAttribute("style", "margin-left:" + w + "px;");
			//生標題div   addQ()
			test();
         }
		 
         window.addEventListener( "load", start, false );
		 
		 //回到最上層
		$(function(){
		//動畫方式回到上層
		$("#gotopD").click(function(){
			jQuery("html,body").animate({scrollTop:0},300);
		});
		//目前的位置距離網頁頂端，若大於300px則顯示回上層圖示;否則隱藏
		$(window).scroll(function() {
			if ( $(this).scrollTop() > 500){
				$('#gotopD').fadeIn("fast");
			} 
			else {
				$('#gotopD').stop().fadeOut("fast");
			}
		});
		});
      </script>
	  <style>
		body	{
					font-family: Helvetica, Microsoft YaHei, LiHei Pro, TW-Kai;
				}
		
		/*搜尋Div*/
		#titleD {
					position: absolute;
					color: white;
					top: 1%;
					width: 450px;
					height: 200px;
					background-color: rgba(0, 0, 0, 0.8);
					padding: 5px 5px;
					border-radius: 20px;  /*圓角*/
				}
		/*中間Div*/
		.contentDiv {
					position: absolute;
					left: 20%;
					width: 55%;
					height: 160px;
					margin-bottom: 50px;
					background-color: #FFFFFF; 
					box-shadow:4px 3px 2px 1px black;
					padding: 5px 5px;
					border-radius: 10px;
				}
		.contentDDT {
					position: absolute;
					top:3%;
					left:4%;
					width:98%;
					height: 35px;
					font-size: 30px;
					color: blue;
				}
		.contentDDC {
					position: absolute;
					margin-top:50px;
					left:3%;
					width: 93%;
					height: 80%;
					font-size: 15px;
					color: gray;
					//background-color: rgba(0, 0, 0, 0.2);
				}
		/*上圖*/
		.background1  {
					background-size: cover;
					background-repeat: no-repeat;
					background-attachment: scroll;
					position: absolute;
					top: 0%;
					left: 0%;
					width: 100%;
					height: 40%;
					z-index: -998;
				}
		/*中下底*/
		.background2 {
					position: fixed;
					top: 0%;
					left: 0%;
					width: 100%;
					height: 100%;
					z-index: -999;
					background-color: rgba(62, 173, 97, 0.63);
				}
		#gotopD {
					position: fixed;
					top: 92%;
					left: 90%;
					height: 20px;
					width: 22px;
					margin-right: 200px;
					background: rgba(0, 0, 0, 0.6);
					padding: 10px 20px;
					border-radius: 10px;  /*圓角*/
				}
		#gotopP {
					text-decoration: none;
					color: white;
					cursor: pointer;
		}
		.options {
					margin-top: 20px;
		        }
		.optionD {
					position: absolute;
					left: 15%;
					font-size: 25px;
					height: 30px;
					color: black;
					margin-top: 20px;
		}
		.optionP {
					position: absolute;
					left: 3%;
					font-size: 15px;
					color: black;
					margin-top: 20px;
		}
		#titleP {
					margin-top: 50px;
					font-size: 20px;
		}
	  </style>
   </head>
   <body>
	<div id = "image" class = "background1"></div>
	<div class = "background2"></div>
	
	<!--草之擺標題-->
	<div id = "titleD">
	    <p id = "titleP" align = "center">
	        <%
		        Polls b = (Polls)request.getAttribute("poll");
			    out.print(b.getTitle());
		    %>
		</p>
		<p align = "center">
	        <%
		        caculatePoll m = (caculatePoll)request.getAttribute("poll_caculate");
			    out.print("總共有: " + m.gettotalWriter() + " 個人填寫!");
		    %>
		</p>
	</div>
	<!--  
	<p align = "center" style = "position: absolute; top: 30%; left: 6%; width: 50px; height: 50px;"><input type = "button" value = "測試新增Q" onclick = "test()"></p>
	-->
	<!--草之擺題目-->
	<div id = "ContentDiv">
        
		<%
		    caculatePoll a = (caculatePoll)request.getAttribute("poll_caculate");
			int total = a.gettotalWriter();
			ArrayList<caculateOption> y = a.getQuestionList();
			Polls c = (Polls)request.getAttribute("poll");
			ArrayList<Question> Q = c.getQuestionList();
			String[] E = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			              "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ",
						  "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR", "BS", "BT", "BU", "BV", "BW", "BX", "BY", "BZ"};
			int distance = 0;
			int count = 0;
			int countt = 0;
			int basic_H = 400;
			int question_H = 0;
			int option_C = 0;
			ArrayList<String> options;
			int totalOption = 0;
			int rr = 0;
			int gg = 0;
			int bb = 0;
			
			for(Question q : Q)
			{
				distance = 300 + (440 + 5) * count;
				options = q.getOptionList();
				option_C = options.size();
				
				out.print("<div class = 'contentDiv' style = 'top : " + distance + "px; height: " + basic_H + "px;'><div class ='contentDDT'>" + q.getQuestion() + "</div><div id='A0"+ count +"'  class='contentDDC' value='"+ options.size() +"'>");
				//拿到題目的選項arraylist
				
				countt = 0;
				for(String d : options)
			    {
					rr = (int)(Math.random()*254+1);
					gg = (int)(Math.random()*254+1);
					bb = (int)(Math.random()*254+1);
				
					//插入題目數量
				    //out.print("<div class='optionD'  style = ' top: "+ (30 + countt*40) + "px; width: " + (50 + ? * 20 ) + "px; color: rgba(" + rr + "," + gg + "," + bb + ",0.6);" + "'>" + d + "/" + ? +"</div>");
					//out.print("<t id=" + E[totalOption+countt] +" class='optionD'  style = ' top: "+ (30 + countt*40) + "px;" + "width: 80%' value=" + 	y.get(count).getAnswerList().get(countt) + ">" + d + "/" + 	y.get(count).getAnswerList().get(countt) +"</t>");
					out.print("<p class='optionP' style='top: " + (40 + countt*45) + "px; '>" + d + " / " + 	y.get(count).getAnswerList().get(countt) +"</p><div id=" + E[totalOption+countt] +" class='optionD'  style = ' top: "+ (30 + countt*40) + "px; width:" + (70*y.get(count).getAnswerList().get(countt)/total) +"%;' value=" + 	y.get(count).getAnswerList().get(countt) + "></div>");
					countt++;
			    }
				out.print("</div></div>");
				count++;
				totalOption += countt;
			}
		%>
		
		
	</div>
	
	<div id = "gotopD" href = "#top" hidden = "true">
		<a href = "#top" id = "gotopP">Top</a>
	</div>
	
	
	<div display="hidden" value="<%=totalOption%>" id="littleSheepWithFire"></div>
	<div display="hidden" value="<%=total%>" id="girlIsOnFire"></div>
	
   </body>
</html>