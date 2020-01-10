import java.util.*;

public class CommonEle {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,5,2,8,3,4,6};
        int[] arr2 = new int[] {7,3,6,9,10,2,5,1};
        int cnt = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int N1 = arr1.length;
        int N2 = arr2.length;

        for(int i = 0; i < N1-1; i++) {
            for(int j = 0; j < N2-1; j++) {
                if(arr1[i] == arr2[j]) {
                    System.out.println(arr1[i]);
                    System.out.println(arr2[j]);
                    System.out.println(" ");
                    cnt++;
                }
            }
        }
        System.out.println("Number of common elements: " + cnt);
    }
}



// public class QueueG <Item> {
//     private Node first = null;
//     private Node last = null;
//     int size = 0;

//     public class Node {
//         Item item;
//         Node next;
//     }

//     public void Enqueue(Item item) {
//         Node oldFirst = first;
//         first = new Node();
//         first.item = item;
//         first.next = oldFirst;
//         size++;
//     }

//     public Item Dequeue() {
        
//     }
// }