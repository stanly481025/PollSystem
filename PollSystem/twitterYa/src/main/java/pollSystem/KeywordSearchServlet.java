package pollSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeywordSearchServlet extends HttpServlet {
	//關鍵字搜尋的servlet
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword"); //抓keyword parameter
		ArrayList<Polls> polls = new ArrayList<Polls>();
		polls = (ArrayList<Polls>) getServletContext().getAttribute("polls"); //全部問卷
		
		ArrayList<Polls> displayPoll = new ArrayList<Polls>(); //符合keyword的Poll array
		//比較title是否符合keyword
		for(int i = 0; i < polls.size(); i++) {
			if(polls.get(i).getTitle().contains(keyword)) { //比title
				displayPoll.add(polls.get(i));
			}
		}
		request.setAttribute("displayPoll", displayPoll); //比過關鍵字後的民調
	    request.getSession().setAttribute("TYPE", -1); //使用者停留的poll type
		
	    RequestDispatcher view = request.getRequestDispatcher("mainPage.jsp");
	    view.forward(request, response);
	}
}
