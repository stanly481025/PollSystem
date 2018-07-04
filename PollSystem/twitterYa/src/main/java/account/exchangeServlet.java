package account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import Firebase.FirebaseAdapter;



public class exchangeServlet extends HttpServlet {
	 Gson gson = new Gson();
	 final FirebaseDatabase database = FirebaseDatabase.getInstance();
	 DatabaseReference ref = database.getReference("server/saving-data/fireblog");
	 DatabaseReference usersRef = ref.child("users");
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession();
		RequestDispatcher view;		
		System.out.println(((member)session.getAttribute("nowUser")).getPoint());
		member nowUser = (member) session.getAttribute("nowUser");
		
		int reward1 = Integer.parseInt(request.getParameter("reward1"));
		int reward2 = Integer.parseInt(request.getParameter("reward2"));
		int reward3 = Integer.parseInt(request.getParameter("reward3"));
		int totalNeed = reward1 * 250 + reward2 * 100 + reward3 * 1;
		//MemberData  user_data = (MemberData)sc.getAttribute("user_data");
	
		
		if((nowUser.getPoint() - totalNeed) < 0) 
		{
			String errorMessage = "點數不足!";
			sc.setAttribute("errorMessage", errorMessage);
			view = request.getRequestDispatcher("errorPage.jsp");
			view.forward(request, response);
		}
		else
		{
			//need set to the firebase
			nowUser.subPoint(totalNeed);
			
			//user_data.replace_data(gson.toJson(nowUser), nowUser.getAccountNumber());
		    // update the now user_data by its user accountNumber	
			
			// update the user data to the firebase
			
		    member tempnowUser=nowUser;
			FirebaseAdapter memberAdt=  new FirebaseAdapter();
			memberAdt.UpdateMember(tempnowUser, nowUser.getAccountNumber());
			

			
			//sc.setAttribute("nowUser", nowUser);
			request.setAttribute("reward1", reward1);
			request.setAttribute("reward2", reward2);
			request.setAttribute("reward3", reward3);
			view = request.getRequestDispatcher("showReward.jsp");
			view.forward(request, response);
		}
	}
}
