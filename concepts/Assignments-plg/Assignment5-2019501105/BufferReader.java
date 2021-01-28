/**
 * @author Madhuri
 * @reference stackOverFlow
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//this is used to take the input from user and we have printed key value pair.
public class BufferReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter size: ");
        int size = Integer.parseInt(reader.readLine());
        String[] keys = new String[size];
        int[] values = new int[size];
        BinarySearchST<String,Integer> oi = new BinarySearchST<String,Integer>();
        System.out.println("enter key value pairs: ");
        for(int i = 0; i < size; i++) {
            keys[i] = reader.readLine();
            values[i] = Integer.parseInt(reader.readLine());
            for(int j = 0; j < size; j++) {
                oi.put(keys[i], values[i]);
            }
        }
        System.out.println("the keys are: " + Arrays.toString(oi.keys));
        System.out.println("the values are: " + Arrays.toString(oi.vals));
    }
}
