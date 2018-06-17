package wbse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showPollServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //
        String title = (String) request.getAttribute("title");
        ArrayList<Polls> poll = (ArrayList<Polls>) getServletContext().getAttribute("polls");
        Polls p = new Polls();
        for(int i = 0; i < poll.size(); i++) {
        	if(poll.get(i).getTitle().equals(title)) { //��title�O�_�ۦP
				p = poll.get(i);
			}
        }
        request.setAttribute("pollWillAnswer", p);
        
        //RequestDispatcher view = request.getRequestDispatcher("");
	    //view.forward(request, response);
	}
}
