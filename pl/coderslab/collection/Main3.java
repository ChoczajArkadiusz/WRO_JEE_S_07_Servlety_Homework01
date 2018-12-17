package pl.coderslab.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    private static final Pattern PATERN_1 = Pattern.compile(".{5,}");
    private static final Pattern PATERN_2 = Pattern.compile("[^a-zA-Z0-9_-]");
    private static final Pattern PATERN_3 = Pattern.compile("^[0-9]+");

    public static void main(String[] args) {

        String email1 = "AbCdEfGhI123";
        String email2 = "abcdl_q-efa";
        String email3 = "?asdasdfasf";
        String email4 = "2asdfnk123";
        String email5 = "123";
        String email6 = "abc";
        String email7 = "___abc---";

        int counter = 1;
        System.out.println((counter++) + " " + verifyLogin(email1));
        System.out.println((counter++) + " " + verifyLogin(email2));
        System.out.println((counter++) + " " + verifyLogin(email3));
        System.out.println((counter++) + " " + verifyLogin(email4));
        System.out.println((counter++) + " " + verifyLogin(email5));
        System.out.println((counter++) + " " + verifyLogin(email6));
        System.out.println((counter++) + " " + verifyLogin(email7));

    }


    static boolean verifyLogin(String email) {
        Matcher matcher1 = PATERN_1.matcher(email);
        Matcher matcher2 = PATERN_2.matcher(email);
        Matcher matcher3 = PATERN_3.matcher(email);
        if (matcher1.matches() && !matcher2.find() && !matcher3.find()) {
            return true;
        }
        return false;
    }

}
