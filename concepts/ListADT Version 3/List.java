public class List extends AbstractList {
    public void add(int item) {
        if (size == intList.length){
            this.resize();
        }
        intList[this.size()] = item;
        size += 1;
        
    }
    public void addAll(List lst) {
        if ((size+lst.size) >= intList.length){
            this.resize();
        }
        for (int i=0; i<lst.size; i++){
            intList[size] = lst.intList[i];
            size += 1;
        }
    }
    public void addAll(int[] arr ){
        if ((size+arr.length) >= intList.length){
            this.resize();
        }
        for (int i=0; i<arr.length; i++){
            intList[size] = arr[i];
            size += 1;
        }
    }
    public int indexOf(int item) {
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                return i;
            }
        } return -1;
    }    
}