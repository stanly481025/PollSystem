package PollData;

import java.util.ArrayList;

public class calculTest {
	public static void main (String args[]){
		 ArrayList<Integer> answerList_2 = new ArrayList<Integer>();
			answerList_2.add(2);
			answerList_2.add(3);
			answerList_2.add(1);
			answerList_2.add(1);
			answerList_2.add(2);
			answerList_2.add(4);
		caculatePoll pollcal =new caculatePoll("hello",answerList_2.size());
		pollcal.setQustionAns(answerList_2);
		pollcal.printQustionAns();
	}
}
