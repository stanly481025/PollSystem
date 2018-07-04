package pollSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Firebase.FinishedPollAdapter;
import account.member;

public class BrowseRecordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
		String title = request.getParameter("title"); //抓標題
        String url = request.getParameter("url"); //抓問卷連結
        String accountNumber = request.getParameter("account");
        //判斷該會員是否寫過，是的話顯示結果，不是的話正常填寫
        // get the now user's accountNumber
        System.out.println(request.getSession().getAttribute("nowUser"));
		
		member nowUser = (member) request.getSession().getAttribute("nowUser"); // 知道回答的人是誰
		if(nowUser == null) {
			RequestDispatcher view = request.getRequestDispatcher("mainPage.jsp");
	    	view.forward(request, response);
		}
		else {
			String userAccount = nowUser.getAccountNumber();
		
	        FinishedPollAdapter fpa = new FinishedPollAdapter();
	        ArrayList<Polls> p = (ArrayList<Polls>) getServletContext().getAttribute("polls");
	        
	        String id = getPollIDFromTitle(p, title);
	        boolean isFinish = fpa.pollFinishedChecked(id, userAccount);
	        
	        System.out.println("Have you finish the poll ? : "+isFinish);
	        
	        ArrayList<String> record = (ArrayList<String>) request.getSession().getAttribute("browseRecord");
	        title = java.net.URLDecoder.decode(title);
	        String rec = "<a href = " + url + " style = 'text-decoration: none;'><p class = 'browsS'>" + title + "</p></a>";
	        
	        if(record == null) {
	        	record = new ArrayList<String>();
	        }
	        sortRecordByTime(record, rec); //把時間較新的放在前面
	        
	        request.getSession().setAttribute("browseRecord", record); //設定瀏覽問卷到session
	        
	        if(isFinish){
	        	RequestDispatcher view = request.getRequestDispatcher("resultServlet?id=" + id +"&accountNumber=" + accountNumber);
		    	view.forward(request, response);
	        } else {
	        	RequestDispatcher view = request.getRequestDispatcher(url); //去那個問卷
	    	    view.forward(request, response); 
	        }
		}
	}
	
	private String getPollIDFromTitle(ArrayList<Polls> p, String title) {
		String id = "";
		for(int i = 0; i < p.size(); i++) {
        	if(p.get(i).getTitle().equals(title)) {
				id = "" + p.get(i).getID();
			}
        }
		return id;
	}
	private void sortRecordByTime(ArrayList<String> record, String rec) {
		boolean check = false;
        for(int i = 0; i < record.size(); i++) {
        	if(record.get(i).equals(rec)) {
        		check = true;
        		break;
        	}
        }
        if(check != true) {
        	record.add(rec);
        }
        for(int i = 0; i < record.size(); i++) {
        	for(int j = 1; j < record.size(); j++) {
        		String temp = "";
        		temp = record.get(i);
        		record.set(i, record.get(j));
        		record.set(j, temp);
        	}
        }
	}
}
