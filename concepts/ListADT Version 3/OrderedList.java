import java.util.Arrays;
public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
        if (size == intList.length){
            this.resize();
        }
        intList[size()] = item;
        size += 1;
        Arrays.sort(intList);    
    }
    public void addAll(List lst) {
        if ((size+lst.size) >= intList.length){
            this.resize();
        }
        for (int i=0; i<lst.size; i++){
            intList[size] = lst.intList[i];
            size += 1;
        }
        Arrays.sort(intList);
    } 
    public void addAll(int[] arr ){
        if ((size+arr.length) >= intList.length){
            this.resize();
        }
        for (int i=0; i<arr.length; i++){
            intList[size] = arr[i];
            size += 1;
        }
        Arrays.sort(intList);
    }
    public int indexOf(int item) {
        int low = 0;
        int high = size-1;
        int mid = 0;
        for (int i=0; i<size/2; i++) {
            mid = (low+high)/2;
            if (intList[mid] == item){
                return mid;
            }else if (intList[mid] > item) {
                high = mid;
            }else if (intList[mid] < item) {
                low = mid;
            }
        } return -1;
    }

    public int rank(int item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item < intList[hi]) hi = mid - 1; 
            else if (item > intList[lo]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    public static void main(String[] args) {
        AbstractList lst = new OrderedList();
        lst.add(1, 1);
    }
    
}