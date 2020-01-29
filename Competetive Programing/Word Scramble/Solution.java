import java.util.*;

public class Solution {

    public static void reverseWord(String s) {
        for (int j = s.length() - 1; j >= 0; j--) {
            System.out.print(s.charAt(j));
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        String in = s.nextLine();
        String[] str = in.split(" ");
        for (int i = 0; i < str.length; i++) {
            // System.out.println(str[i]);
            reverseWord(str[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    s.close();
    }
}
