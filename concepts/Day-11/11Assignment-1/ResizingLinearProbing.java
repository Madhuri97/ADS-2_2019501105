import java.util.Scanner;
/**
 * Linear probing implementation.
 * @author Taheniyath
 */
public class ResizingLinearProbing<Key, Value> {
    private static final int CAPACITY = 4;
    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    /**
     * Initializes an empty symbol table.
     */
    public ResizingLinearProbing() {
        this(CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public ResizingLinearProbing(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return true if this symbol table is empty
     * false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return true if this symbol table contains key
     * false otherwise
     *
     */
    public boolean contains(Key key) {
      
        return get(key) != null;
    }

    /**
     * hash function for keys - returns value
     * between 0 and M-1
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * resizes the hash table to the given capacity by
     * re-hashing all of the keys
     */
    private void resize(int capacity) {
        ResizingLinearProbing<Key, Value> temp = new ResizingLinearProbing<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair into the symbol table.
     * @param  key the key
     * @param  val the value
     * 
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m/2) resize(2*m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with key;
     * null if no such value
     * 
     */
    public Value get(Key key) {       
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    /**
     * Removes the specified key and its associated value
     * from this symbol table
     * @param  key the key
     * 
     */
    public void delete(Key key) {        
        if (!contains(key)) return;        
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }        
        keys[i] = null;
        vals[i] = null;       
        i = (i + 1) % m;
        while (keys[i] != null) {           
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;        
        if (n > 0 && n <= m/8) resize(m/2);        
    }
    public static void main(String[] args) {
        ResizingLinearProbing<String, Integer> obj = new ResizingLinearProbing<String, Integer>();
        obj.put("key", 20);
        obj.put("ads", 203);
        obj.delete("key");
        System.out.println(obj.get("key"));
    }
}    
