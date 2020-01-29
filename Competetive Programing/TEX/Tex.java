import java.util.Scanner;

// import java.util.Scanner;

class Tex {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
        String str = s.nextLine();
        // String str = "\"To be or not to be,\" quoth the Bard, \"thatis the question\".The programming contestant replied: \"I must disagree.To `C' or not to `C', that is The Question!\"";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '\"') {
                count++;
                if(count%2 != 0) {
                    System.out.println("``");
                } else {
                    System.out.println("''");
                }
            } else {
                System.out.print(str.charAt(i));
            }
        } 
        System.out.println("\n");
    }
}
}