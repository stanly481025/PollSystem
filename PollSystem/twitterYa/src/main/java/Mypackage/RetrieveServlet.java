package Mypackage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import PollData.*;
import account.*;

public class RetrieveServlet extends HttpServlet {
	
	private  ArrayList<String> memberList = new ArrayList<String>();;
	private static final long serialVersionUID = 1L;
	  public RetrieveServlet() {
	        super();
	    }

    
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		 
		 
		 
		 final FirebaseDatabase database = FirebaseDatabase.getInstance();
		 DatabaseReference ref = database.getReference("server/saving-data/fireblog");
		 DatabaseReference usersRef = ref.child("users");
	
		member testuser =new member("jjj","aaa","1232");
		testuser.addKeyword("water");
		
			//-------------------------------------------------------------------
			
			// get all member from firebase
			usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
			     public void onDataChange(DataSnapshot dataSnapshot) {
			    	 ArrayList<member> articles= new ArrayList<member>();
			         Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create(); 
			         for (DataSnapshot d : dataSnapshot.getChildren()) {
			             String json = gson.toJson(d.getValue());
			             System.out.println(json);
			         }		        
			     }

				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub
					
				}});
			
			
			
			System.out.println("you guess");			
			
	}	
}

