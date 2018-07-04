package account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

import Firebase.FirebaseAdapter;

public class connectTwitterServlet extends HttpServlet {
	
	 final FirebaseDatabase database = FirebaseDatabase.getInstance();
	 DatabaseReference ref = database.getReference("server/saving-data/fireblog");
	 DatabaseReference usersRef = ref.child("users");
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		
		String twitterID = (String) request.getParameter("twitterID");
		System.out.println(twitterID);
		member nowUser= (member)session.getAttribute("nowUser");
		nowUser.setTwitter(twitterID);
		session.setAttribute("nowUser", nowUser);
		
		
	     member tempnowUser=nowUser;
		 FirebaseAdapter memberAdt=  new FirebaseAdapter();
		 memberAdt.UpdateMember(tempnowUser, nowUser.getAccountNumber());
		
		
			
		 RequestDispatcher view;	
		 view = request.getRequestDispatcher("exchangePage.jsp");
		 view.forward(request, response);
	}
}
