package Firebase;

import java.util.concurrent.TimeUnit;

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
import account.member;

public class calculatePollAdapter {
	final FirebaseDatabase database = FirebaseDatabase.getInstance();
	DatabaseReference ref = database.getReference("server/saving-data/fireblog");
	DatabaseReference usersRef = ref.child("pollcaculate");
	private boolean decision = false;
	private boolean tmpdecision;

	public calculatePollAdapter() {
	}

	String jsonvalue = "";
	String tmpjsonvalue = "";

	// create the pollCalculate to the firebase
	public void createCalculatePoll(caculatePoll cp) {
		usersRef.push().setValueAsync(cp);
		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// select the pollCalculate from the firebase by its name
	public String getcaculatePOll(String id) {
		tmpjsonvalue = "";
		final DatabaseReference usersRef2 = ref.child("pollcaculate");
		usersRef2.orderByChild("title").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				caculatePoll pollget = new caculatePoll();
				if (dataSnapshot.exists()) {
					Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
							.create();
					for (DataSnapshot s : dataSnapshot.getChildren()) {
						System.out.println(s.getValue());
						String json = gson.toJson(s.getValue());
						pollget = gson.fromJson(json, caculatePoll.class);
						System.out.println("You get it");
						tmpjsonvalue = json;
					}
				}

			}

			public void onCancelled(DatabaseError databaseError) {
			}
		});

		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("You will get this json :"+ this.jsonvalue);
		this.jsonvalue = tmpjsonvalue;
		return this.jsonvalue;

	}

	// update the pollCalaulate by its name
	public void updateCalaulate(final caculatePoll poll, String updatePollId) {
		final DatabaseReference usersRef2 = ref.child("pollcaculate");
		// you have to set your get accountNumber here
		usersRef2.orderByChild("title").equalTo(updatePollId).addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					for (DataSnapshot s : dataSnapshot.getChildren()) {
						System.out.println(s.getKey());
						usersRef2.child(s.getKey()).setValueAsync(poll);
						break;
					}
				}
			}

			public void onCancelled(DatabaseError databaseError) {
			}
		});

		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ckecked the caculate poll data existed or not
	public boolean pollCaculateChecked(String id) {
		tmpdecision = false;
		System.out.println("the caculate poll id you want to create: " + id);

		final DatabaseReference usersRef2 = ref.child("pollcaculate");
		usersRef2.orderByChild("title").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					System.out.println("You get the caculate poll here");
					tmpdecision = true;
				}
			}

			public void onCancelled(DatabaseError databaseError) {
			}
		});

		try {
			TimeUnit.MILLISECONDS.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.decision = tmpdecision;
		System.out.println("Pass you checked boolean to the cntext listener:  " + this.decision);
		return this.decision;
	}

}
