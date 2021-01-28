/**
 * @author Madhuri
 */
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.BinaryStdIn;

public class BurrowsWheeler {
    private static final int R = 256;

    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        int n = s.length();
        CircularSuffixArray csa = new CircularSuffixArray(s);
        
        // Find & write first
        for (int first = 0; first < csa.length(); first++) {
            if (csa.index(first) == 0) {
                BinaryStdOut.write(first);
                break;
            }
        }
        
        // Write t[]
        for (int i = 0; i < csa.length(); i++) {
            BinaryStdOut.write(s.charAt((n-1+csa.index(i)) % n));
        }
        
        BinaryStdOut.flush();
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        int n = t.length();
        int[] count = new int[R+1], next = new int[n];
        
        // Key-indexed counting
        for (int i = 0; i < n; i++) {
            count[t.charAt(i)+1]++;
        }
        for (int i = 1; i < R+1; i++) {
            count[i] += count[i-1];
        }
        
        // Compute next & write the original string
        for (int i = 0; i < n; i++) {
            next[count[t.charAt(i)]++] = i;
        }
        for (int i = next[first], c = 0; c < n; i = next[i], c++) {
            BinaryStdOut.write(t.charAt(i));
        }
        
        BinaryStdOut.flush();
    }
    public static void main(String[] args) {
        
    }
}