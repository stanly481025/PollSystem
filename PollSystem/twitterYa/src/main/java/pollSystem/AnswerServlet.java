package pollSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Firebase.FinishedPollAdapter;
import Firebase.calculatePollAdapter;
import PollData.PollFinished;
import PollData.caculatePoll;
import account.member;

public class AnswerServlet extends HttpServlet {
	// 使用者寫完問卷提交後來的地方
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ArrayList<Polls> p = (ArrayList<Polls>) getServletContext().getAttribute("polls");
		ArrayList<Integer> pollAnswer = new ArrayList<Integer>();

		member nowUser = (member) request.getSession().getAttribute("nowUser"); // 知道回答的人是誰
		String userAccount = nowUser.getAccountNumber();
		String pollID = (String) request.getParameter("id");

		int index = Integer.parseInt(pollID) - 1;
		Polls pp = p.get(index);
		for (int i = 0; i < pp.getQuestionList().size(); i++) {
			int answer = Integer.parseInt((String) request.getParameter("" + i));
			pollAnswer.add(answer);
		}
		// 給DB的參數: pollID, userAccount, PollAnswer
		System.out.println("pollAnswer:" + pollAnswer);
		
		System.out.println("Which one write the poll: " + userAccount);
		
		PollFinished pf = new PollFinished(pollID, userAccount, pollAnswer);
		FinishedPollAdapter fpa = new FinishedPollAdapter();
		fpa.createFinishedPoll(pf);
          
		caculatePoll cp = new caculatePoll();
		calculatePollAdapter cpa = new calculatePollAdapter();
		String json = cpa.getcaculatePOll(pollID);
		Gson gson = new Gson();
		cp = gson.fromJson(json, caculatePoll.class);
		cp.setQustionAns(pollAnswer);
		cpa.updateCalaulate(cp, pollID);
		
		boolean bonusFlag = false;
		Polls ck = p.get(Integer.parseInt(pollID)-1);
		for(int i = 0; i < ck.getKeywordList().size(); i++) {
			for(int j = 0; j < nowUser.getkeywordList().size(); j++) {
				if(nowUser.getkeywordList().get(j).equals(ck.getKeywordList().get(i))) {
					bonusFlag = true;
				}
			}
		}
		if(bonusFlag) {
			nowUser.addPoint(15);
		} else {
			nowUser.addPoint(10);
		}
		request.getSession().setAttribute("nowUser", nowUser);
		
		RequestDispatcher view = request.getRequestDispatcher("mainPage.jsp");
		view.forward(request, response);
		
	}
}
