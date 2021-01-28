/**
 * @author Madhuri
 * Prove that building a minimum-oriented 
 * priority queue of size N then doing N - k 
 * replace the minimum (insert followed by 
 * removing the minimum) operations leave the 
 * k largest of the N items in the priority 
 * queue. Analyze the complexity to find k 
 * largest elements in this method(Priority Queue)
 */
import java.util.Arrays;

class MinOriPQ {

    /**
     * this method is used to do insert and delete 
     * the n - k elements.
     * @param a
     * @param k
     * @return integer value 
     */
    public int[] maximum(int[] a, int k) {
        int n = a.length;
        MinPQ<Integer> MinP = new MinPQ();
        for(int i = 0; i < n; i++) {
            MinP.insert(a[i]);
        }
        int s = n - k;
        int [] p = new int[s];
        int [] q = new int[k];
        for(int i = 0; i < s; i++) {
            p[i] = MinP.delMin();
        }
        for(int i = 0; i < k; i++) {
            q[i] = MinP.delMin();
        }
        System.out.println("maximum elements : " + Arrays.toString(q));
        return p;
    }
    
}
