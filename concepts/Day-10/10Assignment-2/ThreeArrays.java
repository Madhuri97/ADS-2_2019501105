import java.util.*;
/**
 * Implementation for 3 arrays BST.
 * @author Taheniyath
 */
class ThreeArrays<Key extends Comparable<Key>>
{
    Key[] keys;
    Integer[] left;
    Integer[] right;
    int leftPt = 1;
    int rightPt = 1;

    public ThreeArrays()
    {
        keys = (Key[])new Comparable[40];
        left = new Integer[10];
        right = new Integer[10];
    }
    /**
     * inserts the keys and respective indices into the arrays
     * Time Complexity : O(N)
     * @param key key.
     */
    public void insert(Key key) {
        if (keys[1] == null) {
            keys[1] = key;
            return;
        }
        for (int i = 1; i < keys.length; ) {
            if (keys[i] != null && key.compareTo(keys[i]) > 0) {
                i = (2 * i) + 1;
            } else if (keys[i] != null && key.compareTo(keys[i]) < 0) {
                i = 2 * i;
            } else {
                keys[i] = key;
                if (i % 2 == 0) {
                    left[leftPt++] = i;
                }
                else {
                    right[rightPt++] = i;
                }
                break;
            }
        }
    }
    /**
     * @param key key.
     * @return string.
     * Time Complexity:O(n).
     */
    

    String toString(Key[] key) {
        String str = "";
        for (int i = 1; i < key.length; i++) {
            if (key[i] == null || key[i].equals(new Integer(0))) {
                str = str + -1 + " ";
                continue;
            }
            str = str + key[i] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        ThreeArrays obj = new ThreeArrays();
        obj.insert(16);
        obj.insert(4);
        obj.insert(12);
        obj.insert(15);
        obj.insert(29);
        obj.insert(33);
        obj.insert(9);
        obj.insert(21);
        obj.insert(13);
        obj.insert(23);
        obj.insert(9);
        obj.insert(17);
        
        System.out.println("keys = " + obj.toString(obj.keys));
        System.out.println("left = " + obj.toString(obj.left));
        System.out.println("right = " + obj.toString(obj.right));
        
    }
}