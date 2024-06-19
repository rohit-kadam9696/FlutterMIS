package com.twd.flutter.android.constant;

import java.util.Random;

public class RandomString {

	 
    private static final String CHAR_LIST =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 15;
    private static final int RANDOM_NUMBER_LENGTH = 5;
     
    /**
     * This method generates random string
     * @return
     */
    public static String generateRandomString(){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    public String generateRandomString(int len){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<len; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    
    public static String generateRandomNumber(){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_NUMBER_LENGTH; i++){
            int number = getRandomNumberN();
            randStr.append(number);
        }
        return randStr.toString();
    }
    
    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    private static int getRandomNumberN() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(9);
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

}
