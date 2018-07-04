package account;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class accountServletContextListener implements ServletContextListener {

	
	public void contextInitialized(ServletContextEvent event) {
		//this part will set in the firebase be a member list
		ServletContext sc = event.getServletContext();
		ArrayList<member> memberList = new ArrayList<member>();
		sc.setAttribute("memberList", memberList);
		//---------------------------------------------------
		/*MemberData  user_data = new MemberData();
	    user_data.createTable();
	    sc.setAttribute("user_data", user_data);*/
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		// nothing to do here
	}
}
