package wbse;

import java.util.ArrayList;

public class Polls {
	public String title; //���ռ��D
	public int type; //��������
	public ArrayList<Question> questionList = new ArrayList<Question>(); //���D
	public ArrayList<String> keywordList = new ArrayList<String>(); //����r
	public String description; //���մy�z
	
	public Polls() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	public void addQuestionList(Question question) {
		this.questionList.add(question);
	}
	public ArrayList<String> getKeywordList() {
		return keywordList;
	}
	public void addKeywordList(String keyword) {
		this.keywordList.add(keyword);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}