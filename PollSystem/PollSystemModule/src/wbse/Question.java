package wbse;

import java.util.ArrayList;

public class Question {
	public String question; //���D
	public ArrayList<String> optionList = new ArrayList<String>(); //�ﶵ
	public String img; //�D�ت���
	//public String answer;
	
	public Question() {
		
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getOptionList() {
		return optionList;
	}
	public void addOptionList(String option) {
		this.optionList.add(option);
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	/*
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	*/
}
