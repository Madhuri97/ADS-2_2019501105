import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Madhuri
 */
public class WordNetD {
    public void hypernyms() throws FileNotFoundException {
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\hypernyms.txt"); 
        //load the data of the synsets file into program 
        //by passing the path as parameter
        Scanner sc = new Scanner(file); //scanner object
        while (sc.hasNextLine()) { // to read next line
            String[] arr = sc.nextLine().split(",");
            System.out.println(arr[0]);
        } 
        sc.close();
    }

    public void synsets() throws FileNotFoundException {
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\synsets.txt"); 
        //load the data of the synsets file into program 
        //by passing the path as parameter
        Scanner sc = new Scanner(file); //scanner object
        while (sc.hasNextLine()) {// to read next line
            String[] arr = sc.nextLine().split(",");
            System.out.println(arr[0]);
        } 
        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordNetD data = new WordNetD();
        data.hypernyms();
        System.out.println("-------");
        data.synsets();
    }
}
