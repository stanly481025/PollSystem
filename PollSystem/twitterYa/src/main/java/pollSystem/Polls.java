package pollSystem;

import java.util.ArrayList;

public class Polls {
	public String title; //民調標題
	public int type; //民調類型
	public ArrayList<Question> questionList = new ArrayList<Question>(); //問題
	public ArrayList<String> keywordList = new ArrayList<String>(); //關鍵字
	public String description; //民調描述
	public int ID;
	
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
	public int getID() {
		return ID;
	}
	public void setID(int ID){
		this.ID = ID;
	}
}
