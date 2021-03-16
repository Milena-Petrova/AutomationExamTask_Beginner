package help;

import java.util.Random;

/**
 * This is a class for generating different type of random strings
 */
public class RandomStringGenerator {
    private final static String letterUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String letterLowerCase = letterUpperCase.toLowerCase();
    private final static String digits = "1234567890";
    private static final String randomChars = letterUpperCase + letterLowerCase + digits;
    private static final int LENGTH_PASS_MAX = 20;
    private static final int LENGTH_NAME_MAX = 32;
    private static final int LENGTH_EMAIL = 10;
    private static final String EMAIL_DOMAIN = "gmail.com";

    /**
     * This method returns random generated email.
     *
     * @return
     */
    public static String randomEmail() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 1 ; i <=LENGTH_EMAIL ; i++) {
            int randomIndex = rand.nextInt(randomChars.length());
            sb.append(randomChars.charAt(randomIndex));
        }
        System.out.println(sb.toString() + "@" + EMAIL_DOMAIN);
        return sb.toString() + "@" + EMAIL_DOMAIN;
    }

    /**
     * This method returns random generated Name
     * @return
     */
    public static String randomName() {
         StringBuilder sb = new StringBuilder();
        String randomName = letterLowerCase + letterUpperCase;
        int i = 0;
        Random rand = new Random();
        while (i < LENGTH_NAME_MAX) {
            int randomIndex = rand.nextInt(randomName.length());
            sb.append(randomName.charAt(randomIndex));
            i++;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String randomPassword() {
        StringBuilder sb = new StringBuilder();
        String randomPass = letterLowerCase + letterUpperCase + digits + "!@#$%^&*+_-?";

        int i = 0;
        Random rand = new Random();
        while (i < LENGTH_PASS_MAX) {
            int randomIndex = rand.nextInt(randomPass.length());
            sb.append(randomPass.charAt(randomIndex));
            i++;
        }
        System.out.println("Pass is: "+sb.toString());
        return sb.toString();
    }

    public static String randomInvalidPassword() {
        System.out.println("Invalid pass is: "+randomPassword()+1);
       return randomPassword()+1;
    }
    public static String randomPhone() {
        StringBuilder sb = new StringBuilder();
        String randomPhone = digits;
        int i = 0;
        Random rand = new Random();
        while (i < randomPhone.length()) {
            int randomIndex = rand.nextInt(randomPhone.length());
            sb.append(randomPhone.charAt(randomIndex));
            i++;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}


