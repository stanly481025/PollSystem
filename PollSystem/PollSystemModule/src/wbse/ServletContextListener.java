package wbse;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {
	public Date browseTime;
	public String hotKeyword;
	public ArrayList<Polls> pollList;
	
	public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }
	public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
}
