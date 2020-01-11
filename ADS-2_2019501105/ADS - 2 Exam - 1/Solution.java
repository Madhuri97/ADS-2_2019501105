import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    HashMap<Integer,String> hm = new HashMap<Integer,String>();  
    HashMap<Integer,String> hm1 = new HashMap<Integer,String>();
    ArrayList<String> recid = new ArrayList<String>(); //reciever id
    DiGraph ver;                                            
    public Solution() throws Exception {
        this.emails();
        ver = new DiGraph(hm.size());
        this.emailLogs();
        System.out.println("vertices: " + ver.size());
        int count = 0;
        for (int i = 0; i < ver.size(); i++) {
            count = count + ver.adj[i].size();
        }
        System.out.println("reciever:    " + count);
    }
    public void emailLogs() throws Exception {
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\ADS - 2 Exam - 1\\email-logs.txt"); 
        Scanner sc = new Scanner(file);  //scanner object
        while (sc.hasNextLine()) {       // to read next line
            String[] eml = sc.nextLine().split(",");
            System.out.println(eml[0]);
            for (int i = 1; i < eml.length; i++) {
                ver.addEdge(Integer.parseInt(eml[2]), Integer.parseInt(eml[i]));
            }
            for (int i = 1; i < eml.length; i++) {
                recid.add(eml[i]);
            }
        } 
        sc.close();
    }

    /**
     * this method is used to get the count of emails
     * @throws Exception
     */
    public void emails() throws Exception {
        File file = new File("C:\\Users\\M. LAKSHMI MADHURI\\Desktop\\javaps\\ADS-2_2019501105\\ADS - 2 Exam - 1\\emails.txt"); 
        
        Scanner sc = new Scanner(file); //scanner object
        while (sc.hasNextLine()) {      // to read next line
            String[] ems = sc.nextLine().split(";");
            // System.out.println(ems[0]);
            hm.put(Integer.parseInt(ems[0]),ems[1]);
        } 
        // System.out.println(hm.size());
        sc.close();
    }

    public static void main(String[] args) throws Exception {
        
        Solution data = new Solution();
        data.emailLogs();
        data.emails();
    }
}
