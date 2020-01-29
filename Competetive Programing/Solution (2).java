import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String[] inp = scan.nextLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int R = Integer.parseInt(inp[1]);
        HashMap<String, PhysicalAddress> map = new HashMap<String, PhysicalAddress>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(scan.nextLine());
            // System.out.println(Arrays.toString(tokens));
            String name = st.nextToken();
            int ba = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int dimension = Integer.parseInt(st.nextToken());
            int[] bound = new int[2*dimension];
            for(int j = 0; j < bound.length; j++) {
                bound[j] = Integer.parseInt(st.nextToken());
            }
            //storing details of each array into sep class
            PhysicalAddress phy_arr = new PhysicalAddress(ba,size,dimension,bound);

            map.put(name,phy_arr);
        }
        for(int i = 0; i < R; i++) {
            // String[] input = scan.nextLine().split(" ");
            st = new StringTokenizer(scan.nextLine());
            String key = st.nextToken();
            ArrayList<Integer> indexes = new ArrayList<>();
              while (st.hasMoreTokens()) {
                indexes.add(Integer.parseInt(st.nextToken()));
            }
            PhysicalAddress obj = map.get(key);
            if(obj != null) {
                System.out.println(key+indexes+" = "+ obj.getPhy(indexes));    
            }
        }
    }
}

class PhysicalAddress {
    int[] C;

    PhysicalAddress(int ba, int size, int dimension, int[] b) {
        C = new int[dimension+1];
        
        //Cd will be the size always
        C[dimension] = size;

        //Cd.....,C3, C2, C1
        for(int i = dimension-1; i > 0; i--) {
            C[i] = C[i+1]*(b[2*i +1] - b[2*i]+1);
        } 

        C[0] = ba;
        //calculate the C0 now
        for(int i = 1; i < dimension+1; i++) {
            C[0] -= (C[i]*b[2*i -2]); 
        }
    }

    public int getPhy(ArrayList<Integer> lis) {
    	//C0 + (C1 * i1) + (C2 * i2) ......
        int res = this.C[0];
        for(int i = 0; i < lis.size();i++) {
            res += this.C[i+1]*lis.get(i);
        }
        return res;
    }

    public String toString() {
        return Arrays.toString(this.C);
    }
}
