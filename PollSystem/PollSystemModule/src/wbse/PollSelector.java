package wbse;

import java.security.SecureRandom;

public class PollSelector {
	//隨機從全部問卷中選擇一個問卷
	private static final SecureRandom randomNumbers = new SecureRandom();
    
    public int select(int size){
        int choose = randomNumbers.nextInt(size) + 1;
        return choose;
    }
}