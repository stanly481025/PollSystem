package PollData;

import java.util.ArrayList;

public class PollFinished {
	private String title;
	private String writer;
	private ArrayList<Integer> answerlist = new ArrayList<Integer>();

	public PollFinished() {
	}

	public PollFinished(String name, String writer, ArrayList<Integer> answerlist) {
		this.title = name;
		this.writer = writer;
		this.answerlist = answerlist;
	}

	public String getTitle() {
		return this.title;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public ArrayList<Integer> getAnswerlist() {
		return this.answerlist;
	}

}
