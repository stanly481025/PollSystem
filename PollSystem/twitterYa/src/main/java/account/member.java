package account;

import java.util.ArrayList;

public class member {
	private String name;
	private String accountNumber;
	private String twitterID;
	private String password;
	private ArrayList<String> keywordList= new ArrayList<String>();
	private ArrayList<memberGift> GiftList = new ArrayList<memberGift>();
	private int point;
	
	public member(String name, String accountNumber, String password) 
	{
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.point = 1500;
		this.twitterID = null;
		
		
		this.keywordList.add("2");
	 
	}
	public member() {}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getkeywordList() 
	{
		return this.keywordList;
	}
	
	public void setTwitter(String twitterID) {
		this.twitterID =twitterID ;
	}
	public String gettwitterID() {
		return this.twitterID ;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void addPoint(int p) 
	{
		this.point += p;
	}
	
	public void subPoint(int p) 
	{
		this.point -= p;
	}
	
	public void setPoint(int p) 
	{
		this.point = p;
	}
	
	public int getPoint() 
	{
		return this.point;
	}
	
	public void addKeyword(String newKeyword) 
	{  
		this.keywordList.add(newKeyword);
	}
	
	public void clearKeyword() 
	{
		this.keywordList.clear();
	}
	
	public void setkeywordList(ArrayList<String> keywordStr) 
	{
		this.keywordList = keywordStr;
	}
	
}
