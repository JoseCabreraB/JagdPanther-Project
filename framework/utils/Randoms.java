package framework.utils;

/**Created by Jose Cabrera
 * 1/27/15
 * 
 */
import java.util.Random;

/**
 * @title  Randoms
 * @author Jose Cabrera
 * @description Is the class used for generate different types of data random
 * 
 *  */
public class Randoms {

	public int getNumber() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9);
		return randomInt;
	}
	
	public int getNumber(int num){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(num)+1;
		return randomInt;
	}
	
	public String generateRandomString(){
		String CHAR_LIST =
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int RANDOM_STRING_LENGTH = 10;     
	    StringBuffer randStr = new StringBuffer();
	    for(int i = 0; i < RANDOM_STRING_LENGTH; i++){
	            int number = getNumber(52);
	            char ch = CHAR_LIST.charAt(number - 1);
	            randStr.append(ch);
	    }
	    return randStr.toString();
	}
}
