/**
 * @author Madhuri
 * here in this method used scanner to get
 * input from the system
 */
import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int k = scan.nextInt();
        int [] arr = new int[size];
        System.out.println("enter elements in array : ");
        for(int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        MinOriPQ mpq = new MinOriPQ();
        System.out.println("n - k elements are deleted : " + Arrays.toString(mpq.maximum(arr, k)));
    }
}
