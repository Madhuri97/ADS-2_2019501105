import java.util.*;
import java.util.Arrays;

/**
 * @author Madhuri
 * @reference Robert Sedgewick
 * Ordered insertions. Modify BinarySearchST
 * so that inserting a key that is larger 
 * than all keys in the table takes constant 
 * time (so that building a table by calling 
 * put() for keys that are in order takes 
 * linear time). (Symbol Table)
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static int capacity = 2;
    public Key[] keys;
    public Value[] vals;
    private int n = 0;
    
    public BinarySearchST() {
        this(capacity);
    }

    /**
     * it is used to store the keys and values within the capacity
     * @param capcty
     */
    public BinarySearchST(int capcty) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }

    /**
     * it is used when the size reaches the given capacity
     * then it will resize the array
     * @param capacity
     */
    public void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    // used to return size as n
    public int size() {
        return n;
    }   
    // it checks if the array is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }
    // it used to check if the key present the array or not
    public boolean contains(Key key) {
        if(key == null) throw new IllegalArgumentException("contains argument is null");
        return get(key) != null;
    }

    /**
     * this rank is used for searching the elements in the Symboltable
     * O(logn)
     * @param key
     * @return int value
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) {
                hi = mid - 1;
            } else if(cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * this is used for getting the value for the given key
     * O(log n)
     * @param key
     * @return value for given key
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if(isEmpty()) {
            return null;
        }
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    /**
     * this is used to delete the corresponding value for a given key
     * O(n)
     * @param key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if(isEmpty()) return;

        int i = rank(key);
        if(i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for(int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        n--;
        keys[n] = null;
        vals[n] = null;
    }

    /**
     * this method is to insert key and value into the Symboltable
     * O(1)
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if(key == null) throw new IllegalArgumentException("first argument to put() is null");
        if(val == null) {
            delete(key);
            return;
        }
        //this is the code for getting O(1)
        if(n != 0 && key.compareTo(keys[n - 1]) > 0){
            keys[n] = key;
            vals[n] = val;
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        // insert new key-value pair
        if (n == keys.length) resize(2 * keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    } 
}
