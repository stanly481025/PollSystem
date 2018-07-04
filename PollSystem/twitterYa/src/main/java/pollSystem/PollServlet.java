package pollSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.member;

public class PollServlet extends HttpServlet {
	//處理首頁頁面呈現的servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        ArrayList<Polls> p = (ArrayList<Polls>) getServletContext().getAttribute("polls");
        //預設type為1
        String pollType = "";
        
        ArrayList<Polls> bonus = (ArrayList<Polls>) getServletContext().getAttribute("bonusPoll");
        bonus.clear();
        getServletContext().setAttribute("bonusPoll", bonus);
        String loginInMessage = (String) request.getSession().getAttribute("loginStatus");
        if(loginInMessage != null && loginInMessage.equals("logIn"))
        {
        	member m = (member) request.getSession().getAttribute("nowUser");
        	ArrayList<String> kw = m.getkeywordList();
        	for(int i = 0; i < p.size(); i++) {
        		for(int j = 0; j < p.get(i).getKeywordList().size(); j++) {
        			for(int k = 0; k < kw.size(); k++) {
        				if(kw.get(k).equals(p.get(i).getKeywordList().get(j))) {
        					bonus.add(p.get(i));
        				}
        			}
        		}
        	}
        	System.out.println("bonus size" + bonus.size());
        	getServletContext().setAttribute("bonusPoll", bonus);
        }
        
        
        
        
        if((String) request.getParameter("type") == null) {
        	pollType = "-1";
        } else {
        	pollType = (String) request.getParameter("type");
        }
        int type = Integer.parseInt(pollType);
        ArrayList<Polls> poll = new ArrayList<Polls>();
        //決定各分類要顯示的問卷
        switch(type)
        {
        	case 0:
        		poll = (ArrayList<Polls>) getServletContext().getAttribute("bonusPoll");
	        	break;
	        case 1:
	        	poll = (ArrayList<Polls>) getServletContext().getAttribute("entertainmentPoll");
	        	break;
			case 2:
				poll = (ArrayList<Polls>) getServletContext().getAttribute("sportsPoll");
				break;
			case 3:
				poll = (ArrayList<Polls>) getServletContext().getAttribute("businessPoll");
				break;
			case 4:
				poll = (ArrayList<Polls>) getServletContext().getAttribute("politicalPoll");
				break;
			case 5:
				poll = (ArrayList<Polls>) getServletContext().getAttribute("technologyPoll");
				break;
			case 6:
				poll = (ArrayList<Polls>) getServletContext().getAttribute("lifePoll");
				break;
        }
        request.setAttribute("displayPoll", poll); //顯示點選分類的poll
        request.getSession().setAttribute("TYPE", type); //使用者停留的poll type
        
        RequestDispatcher view = request.getRequestDispatcher("mainPage.jsp");
	    view.forward(request, response);
	}
	
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		doGet(request, response);
	}
}
