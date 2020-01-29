import java.util.Scanner;

class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int [] myArray = new int[length];
        System.out.println("Enter the elements of the array:");
        for(int i=0; i < length; i++) {
            myArray[i] = s.nextInt();
        }
        s.close();
        int i = 0;
        System.out.println("output is: ");
        while(i < length/2) {
            System.out.println(myArray[length - i - 1]);
            System.out.println(myArray[i]);
            i++;
        }
    }
}

          
// public static void main(String[] args) {
//     int[] num = {1,2,3,4,5,6};
//     int n = num.length;
//     int i = 0;
//         while(i < n/2) {
//             System.out.println(num[n - i - 1]);
//             System.out.println(num[i]);
//             i++;
//         }
//     }
// }

//123456
//615243