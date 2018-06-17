package wbse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PollServlet extends HttpServlet {
	//�B�z���������e�{��servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //�w�]type��1
        String pollType = "";
        if((String) request.getParameter("type") == null) {
        	pollType = "1";
        } else {
        	pollType = (String) request.getParameter("type");
        }
        int type = Integer.parseInt(pollType);
        ArrayList<Polls> poll = new ArrayList<Polls>();
        //�M�w�U�����n��ܪ��ݨ�
        switch(type)
        {
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
        request.setAttribute("displayPoll", poll); //����I�������poll
        request.getSession().setAttribute("TYPE", type); //�ϥΪ̰��d��poll type
        
        //RequestDispatcher view = request.getRequestDispatcher("");
	    //view.forward(request, response);
	}
}