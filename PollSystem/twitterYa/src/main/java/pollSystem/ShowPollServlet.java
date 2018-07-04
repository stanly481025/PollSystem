package pollSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPollServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //
        int id = Integer.parseInt((String) request.getParameter("id"));
        ArrayList<Polls> poll = (ArrayList<Polls>) getServletContext().getAttribute("polls");
        Polls p = new Polls();
        for(int i = 0; i < poll.size(); i++) {
        	if(poll.get(i).getID() == id) { //比pollID是否相同
				p = poll.get(i);
			}
        }
        request.setAttribute("pollWillAnswer", p);
        
        RequestDispatcher view = request.getRequestDispatcher("questionPage.jsp");
	    view.forward(request, response);
	}
}
