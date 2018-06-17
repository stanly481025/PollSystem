package wbse;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PollServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event)  { 
		ServletContext sc = event.getServletContext();
		int pollMaxNumber = Integer.parseInt(sc.getInitParameter("pollMaxNumber")); //取得全部問卷總數
		String f = "/WEB-INF/" + pollMaxNumber + ".txt";
        String fn = sc.getRealPath(f); //抓路徑
        ReadPoll rp = new ReadPoll(fn);
        rp.openFile();
		rp.readQuestions();
        rp.closeFile();
        ArrayList<Polls> p = rp.getPolls();
        // 設定問卷並分類
        ArrayList<Polls> bonusPoll = new ArrayList<Polls>();
        ArrayList<Polls> entertainmentPoll = new ArrayList<Polls>();
        ArrayList<Polls> sportsPoll = new ArrayList<Polls>();
        ArrayList<Polls> businessPoll = new ArrayList<Polls>();
        ArrayList<Polls> politicalPoll = new ArrayList<Polls>();
        ArrayList<Polls> technologyPoll = new ArrayList<Polls>();
        ArrayList<Polls> lifePoll = new ArrayList<Polls>();
        
        for(int i = 0; i < p.size(); i++) {
        	switch(p.get(i).getType()) {
			case 1:
				entertainmentPoll.add(p.get(i));
				break;
			case 2:
				sportsPoll.add(p.get(i));
				break;
			case 3:
				businessPoll.add(p.get(i));
				break;
			case 4:
				politicalPoll.add(p.get(i));
				break;
			case 5:
				technologyPoll.add(p.get(i));
				break;
			case 6:
				lifePoll.add(p.get(i));
				break;
        	}
        }
        //將各類問卷存到servlet context
        sc.setAttribute("polls", p);
        sc.setAttribute("bonusPoll", bonusPoll);
        sc.setAttribute("entertainmentPoll", entertainmentPoll);
        sc.setAttribute("sportsPoll", sportsPoll);
        sc.setAttribute("businessPoll", businessPoll);
        sc.setAttribute("politicalPoll", politicalPoll);
        sc.setAttribute("technologyPoll", technologyPoll);
        sc.setAttribute("lifePoll", lifePoll);
	}
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
}
