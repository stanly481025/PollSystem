package pollSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadPoll {
	private Scanner input;
	private String filename = "1.txt";
	private Polls polls = new Polls();

	public ReadPoll(){

	}
	public ReadPoll(String filename){
		this.filename = filename;
	}// enable user to open file
	
	public void openFile ()
	{
		try
		{
			input = new Scanner(new File(filename), "utf-8");
		} // end try
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		} // end catch
	} // end method openFile
	
	// read quiz from file
	public void readQuestions ()
	{
		try
		// read records from file using Scanner object
		{
			polls.setTitle(input.nextLine());
			String type = input.nextLine();
			switch(type) {
				case "entertainment":
					polls.setType(1);
					break;
				case "sports":
					polls.setType(2);
					break;
				case "business":
					polls.setType(3);
					break;
				case "political":
					polls.setType(4);
					break;
				case "technology":
					polls.setType(5);
					break;
				case "life":
					polls.setType(6);
					break;
			}
			
			polls.setDescription(input.nextLine());
			StringTokenizer tokens = new StringTokenizer(input.nextLine());
			while(tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				polls.keywordList.add(token);
			}
			
			String buf = input.nextLine();
			while (input.hasNextLine())
			{
				Question q = new Question();
				q.setQuestion(input.nextLine());
				while (input.hasNextLine())
				{
					buf = input.nextLine();
					//System.out.println(buf);
					if(buf.length() == 0) {
						//System.out.println("HI~");
						break;
					} else {
						String option = buf;
						q.addOptionList(option);
					}
				}
				polls.addQuestionList(q);
			} // end while
		} // end try
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		} // end catch
	} // end method readRecords
	// close file and terminate application
	public void closeFile ()
	{
		if (input != null)
			input.close(); // close file
	} // end method closeFile
	public Polls getPolls(){
		return polls;
	}
	public static void main (String args[])
	{
		int maxPollNumber = 2;
		for(int k = 1; k <= maxPollNumber; k++) {
			ReadPoll rp = new ReadPoll( k +".txt");
			rp.openFile();
			rp.readQuestions();
			Polls pp = new Polls();
			pp = rp.getPolls();
			System.out.println(pp.getTitle());
			System.out.println(pp.getType());
			System.out.println(pp.getDescription());
			System.out.println(pp.getKeywordList());
			for(int i = 0; i < pp.getQuestionList().size(); i++){
				System.out.println("Q" + i + ":" + pp.getQuestionList().get(i).getQuestion());
				for(int j = 0; j < pp.getQuestionList().get(i).getOptionList().size(); j++)
				System.out.println("Option"+ j + ":" + pp.getQuestionList().get(i).getOptionList().get(j));
			}
			rp.closeFile();
		}
	}// end main
}