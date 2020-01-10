public class SortedArray {
    public static void main(String[] args) {

       int[] arr1 = {2,11,5,67,2};
       int[] arr2 = {4,2,15,42,1};
       
       int n2 = arr2.length;
       int n1 = arr1.length;
       
       int[] arr = new int[n1 + n2];
       
       int i = 0; 
       int j = 0; 
       int k = 0;
       
       while (i < n1 && j < n2) {
          if (arr1[i] < arr2[j]) {
             arr[k++] = arr1[i++];
          } else {
             arr[k++] = arr2[j++];
       }
       while (i < n1) {
          arr[k++] = arr1[i++];
       }
       while (j < n2) {
          arr[k++] = arr2[j++];
       }
       for (int x = 0; x < n1 + n2; x++) {
          System.out.print(arr[x] + " ");
    }
 }
}
}