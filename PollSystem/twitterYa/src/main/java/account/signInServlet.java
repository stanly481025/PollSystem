package account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Firebase.FirebaseAdapter;



public class signInServlet extends HttpServlet {
	
	Gson gson = new Gson();
	final FirebaseDatabase database = FirebaseDatabase.getInstance();
	DatabaseReference ref = database.getReference("server/saving-data/fireblog");
	DatabaseReference usersRef = ref.child("users");
	private ArrayList<String> memberList = new ArrayList<String>();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ServletContext sc = getServletContext();
		
		String errorText;
		String password = (String)request.getParameter("password");
		String checkPassword = (String)request.getParameter("passwordCheck");
		String accountNumber = (String)request.getParameter("accountNumber");
		String userName = (String)request.getParameter("userName");
		//之後會刪除-------
		//MemberData  user_data = (MemberData)sc.getAttribute("user_data");
	    
		
	    
		//ArrayList<member> memberList = (ArrayList<member>) sc.getAttribute("memberList");
		//ArrayList<String> memberList = new ArrayList<String>();
		RequestDispatcher view;		
		
		//check the password text1 and password text2
		if(checkPassword(password,checkPassword)) 
		{
			errorText = "請確認密碼是否正確!";
			sc.setAttribute("errorMessage", errorText);
			
			view = request.getRequestDispatcher("errorPage.jsp");
			view.forward(request, response);
		}
		else {
			//check the account have used or not
			//user_data.SelectAllMemberTable(memberList);
			
			// get all the member data from the firebase
			FirebaseAdapter getmember=  new FirebaseAdapter();
			memberList=getmember.getAllMember();
			
			
			if(checkAccountNumberUsed(accountNumber,memberList)) 
			{
				errorText = "會員帳號已經有使用過!";
				sc.setAttribute("errorMessage", errorText);
				
				
				view = request.getRequestDispatcher("errorPage.jsp");
				view.forward(request, response);
			}
			else 
			{
				member NewUser = new member(userName, accountNumber, password);
				String json = gson.toJson(NewUser);
				
				//user_data.insertTable(json);
		 		// user data insert to the firebase
				getmember.createMember(NewUser);
				

					
				//memberList.add(NewUser);
				//sc.setAttribute("memberList", memberList);
				String successText = "申請帳號成功!";
				
				//sc.setAttribute("successMessage", successText);
				view = request.getRequestDispatcher("successPage.jsp");
				view.forward(request, response);
			}
		}
	}
	
	public boolean checkPassword(String passwordText, String passwordCheckText) 
	{
		if(passwordText.equals(passwordCheckText)) 
			return false;
		else
			return true;
	}
	
	public boolean checkAccountNumberUsed(String accountNumber,ArrayList<String> memberList) 
	{
		for(int j = 0; j<memberList.size();j++)
		{
			member temp = gson.fromJson(memberList.get(j), member.class);
			if(accountNumber.equals(temp.getAccountNumber())) 
				return true;
		}
		return false;
	}
	
}
