package wbse;

import java.security.SecureRandom;

public class PollSelector {
	//�H���q�����ݨ�����ܤ@�Ӱݨ�
	private static final SecureRandom randomNumbers = new SecureRandom();
    
    public int select(int size){
        int choose = randomNumbers.nextInt(size) + 1;
        return choose;
    }
}