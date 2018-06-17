package wbse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeywordSearchServlet extends HttpServlet {
	//關鍵字搜尋的servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword"); //抓keyword parameter
		ArrayList<Polls> polls = new ArrayList<Polls>();
		polls = (ArrayList<Polls>) getServletContext().getAttribute("polls"); //全部問卷
		
		ArrayList<Polls> displayPoll = new ArrayList<Polls>(); //符合keyword的Poll array
		//比較title是否符合keyword
		for(int i = 0; i < displayPoll.size(); i++) {
			if(polls.get(i).getTitle().contains(keyword)) { //比title
				displayPoll.add(polls.get(i));
			}
		}
		request.setAttribute("afterSearchPolls", displayPoll); //比過關鍵字後的民調
		
		//RequestDispatcher view = request.getRequestDispatcher("");
	    //view.forward(request, response);
	}
}
