package Firebase;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

import PollData.PollFinished;
import PollData.caculatePoll;
import pollSystem.Polls;

public class resultServlet extends HttpServlet {

	String poll_writer = "";
	String tmppoll_writer = "";
	private static final long serialVersionUID = 1L;

	public resultServlet() {
		super();
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String poll_id = (String) request.getParameter("id");
		//this.poll_writer = (String) request.getParameter("accountNumber");
		//tmppoll_writer = this.poll_writer;

		// initilize the firebase parameter

		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("server/saving-data/fireblog");
		DatabaseReference usersRef = ref.child("pollcaculate");

		// select a specific pollfin correspond to poll name and writer
		/*
		 * final DatabaseReference usersRef2 = ref.child("finpolls");
		 * usersRef2.orderByChild("title").equalTo(poll_id).
		 * addListenerForSingleValueEvent(new ValueEventListener() { public void
		 * onDataChange(DataSnapshot dataSnapshot) { if(dataSnapshot.exists()){
		 * PollFinished pf=new PollFinished(); Gson gson = new
		 * GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.
		 * IDENTITY).create(); for(DataSnapshot s: dataSnapshot.getChildren()) {
		 * if(s.child("writer").getValue().equals(tmppoll_writer)) {
		 * System.out.println("YYYYYYYYYYYYY"); String json = gson.toJson(s.getValue());
		 * pf = gson.fromJson(json, PollFinished.class); break; } }
		 * request.setAttribute("poll_fin",pf ); } } public void
		 * onCancelled(DatabaseError databaseError) { } });
		 */

		// select a calculate poll from the firebase and set it to the attribute

		caculatePoll cp = new caculatePoll();
		calculatePollAdapter cpa = new calculatePollAdapter();
		String json = cpa.getcaculatePOll(poll_id);
		Gson gson = new Gson();
		cp = gson.fromJson(json, caculatePoll.class);
		request.setAttribute("poll_caculate", cp);

		// 將該份問券放入request
		int id = Integer.parseInt(poll_id);
		ArrayList<Polls> tmp = ((ArrayList<Polls>) request.getServletContext().getAttribute("polls"));
		Polls poll = tmp.get(id - 1);

		request.setAttribute("poll", poll);
		// get the specific finished poll and the dispatch to the jsp
		RequestDispatcher view = request.getRequestDispatcher("resultPage.jsp");

		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
