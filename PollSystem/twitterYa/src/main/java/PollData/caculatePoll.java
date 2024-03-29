package PollData;

import java.util.ArrayList;

public class caculatePoll {
	public String title;
	public int question_size;
	public int totalWriter;
	public ArrayList<caculateOption> questionList = new ArrayList<caculateOption>();

	public caculatePoll(String title, int size) {
		this.title = title;
		this.question_size = size;
		this.totalWriter = 0;
		initilize();
	}

	public void initilize() {
		for (int i = 0; i < this.question_size; i++) {
			caculateOption a = new caculateOption();
			this.questionList.add(a);
		}
	}

	public caculatePoll() {
	}

	public String getTitle() {
		return this.title;
	}

	public int getQuestion_size() {
		return this.question_size;
	}

	public int gettotalWriter() {
		return this.totalWriter;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public void setQustionSize(int question_size) {
		this.question_size = question_size;
	}

	public ArrayList<caculateOption> getQuestionList() {
		return this.questionList;
	}

	/*
	 * public ArrayList<Integer> PerQuestionList(int index){ return
	 * this.questionList.get(index).getAnswerList(); }
	 */
	public void setQustionAns(ArrayList<Integer> question_ans) {
		// once one person finish the poll
		// the writer count plus 1
		// and then set his answer correspond to the calculation

		// System.out.println("you pass the answer list here :"+ question_ans );
		// System.out.println("my caculate poll size:" + this.question_size );

		this.totalWriter += 1;
		for (int i = 0; i < this.question_size; i++) {
			// System.out.println(questionList.get(i));
			this.questionList.get(i).plus_caculate(question_ans.get(i));
		}
	}

	public void printQustionAns() {
		for (int i = 0; i < this.question_size; i++) {
			this.questionList.get(i).printCaculate();
			System.out.println();
		}
	}
}
