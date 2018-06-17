package wbse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KeywordSearchServlet extends HttpServlet {
	//����r�j�M��servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword"); //��keyword parameter
		ArrayList<Polls> polls = new ArrayList<Polls>();
		polls = (ArrayList<Polls>) getServletContext().getAttribute("polls"); //�����ݨ�
		
		ArrayList<Polls> displayPoll = new ArrayList<Polls>(); //�ŦXkeyword��Poll array
		//���title�O�_�ŦXkeyword
		for(int i = 0; i < displayPoll.size(); i++) {
			if(polls.get(i).getTitle().contains(keyword)) { //��title
				displayPoll.add(polls.get(i));
			}
		}
		request.setAttribute("afterSearchPolls", displayPoll); //��L����r�᪺����
		
		//RequestDispatcher view = request.getRequestDispatcher("");
	    //view.forward(request, response);
	}
}
