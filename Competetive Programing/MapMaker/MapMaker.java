import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class MapMaker {
    public static void main(String[] args) {
        // int noOfArr = 4;
        // int phyAdd = 7;   
        Scanner s = new Scanner(System.in);
        String[] inp = s.nextLine().split(" ");
        int noOfArr = Integer.parseInt(inp[0]);
        int phyAdd = Integer.parseInt(inp[1]);
        HashMap<String, ArrayList<Integer>> hmap = new HashMap<String, ArrayList<Integer>>();
        StringTokenizer st;
        
        for (int i = 0; i < noOfArr; i++) {
            st = new StringTokenizer(s.nextLine());
            String name = st.nextToken();
            int bAdd = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int dim = Integer.parseInt(st.nextToken());
            int[] bound = new int[2*dim];
            for (int j = 0; j < bound.length; j++) {
                bound[j] = Integer.parseInt(st.nextToken())
            }
        }
    }
}