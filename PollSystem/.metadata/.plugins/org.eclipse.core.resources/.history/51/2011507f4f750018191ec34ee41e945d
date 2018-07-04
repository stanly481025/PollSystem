package Firebase;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import account.*;
import pollSystem.Polls;
import PollData.*;

public class FirebaseAdapter {
	private final FirebaseDatabase database = FirebaseDatabase.getInstance();
	private DatabaseReference ref = database.getReference("server/saving-data/fireblog");
	DatabaseReference usersRef = ref.child("users");
    
	private ArrayList<String> memberList = new ArrayList<String>();
	
	public FirebaseAdapter() {
	}

	// create the user to the firebase
	public void createMember(member user) {
		usersRef = ref.child("users");
		usersRef.push().setValueAsync(user);
		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update the user correspond to his accountnumber
	public void UpdateMember(final member user, String updateAccount) {
		final DatabaseReference usersRef2 = ref.child("users");
		// you have to set your get accountNumber here
		usersRef2.orderByChild("accountNumber").equalTo(updateAccount)
				.addListenerForSingleValueEvent(new ValueEventListener() {
					public void onDataChange(DataSnapshot dataSnapshot) {
						if (dataSnapshot.exists()) {
							for (DataSnapshot s : dataSnapshot.getChildren()) {
								System.out.println(s.getKey());
								usersRef2.child(s.getKey()).setValueAsync(user);
								break;
							}
						}
					}

					public void onCancelled(DatabaseError databaseError) {
					}
				});
		
		try {
			TimeUnit.MILLISECONDS.sleep(3300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> getAllMember() {
		memberList.clear();
		// get all member from firebase
		usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				// get you member list json value here
				Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
						.create();
				for (DataSnapshot d : dataSnapshot.getChildren()) {
					String json = gson.toJson(d.getValue());
					memberList.add(json);
				}
			}

			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub

			}
		});
		try {
			TimeUnit.MILLISECONDS.sleep(3300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;

	}

}
