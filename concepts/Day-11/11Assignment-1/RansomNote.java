/** Ransom note.
 * @author Prasanna.
 */
import java.util.*;
 class RansomNote<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           
    private int m;           
    private Key[] keys;      
    private Value[] vals;    


    /**
     * Initializes an empty symbol table.
     */
    public RansomNote() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public RansomNote(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Comparable[m];
        vals = (Value[]) new Comparable[m];
    }


    public int size() {
        return n;
    }
    private void resize(int capacity) {
        RansomNote<Key, Value> temp = new RansomNote<Key, Value>(capacity);
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
     * Returns true if this symbol table is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return bool
     * time complexity O(1)
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    
    private int hash(Key key) {
        return (key.hashCode() &                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            0x7fffffff) % m;
    }


    /**
     * Inserts the specified key-value pair into the symbol table
     * @param  key the key
     * @param  val the value
     * time complexity O(N)
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
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * time complexity O(N)
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * time complexity O(2N)
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
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

    public static int freq(String[] arofinput, String k)
    {
        int freq=0;
        for(int i=0;i<arofinput.length;i++)
        {
            if(arofinput[i].equals(k))
            {
                freq++;
            }
        }
        return freq;
    }
    public static void main(String[] args) {
        RansomNote<String, Integer> st = new RansomNote<String, Integer>();
        String[] arr = {"MSIT", "IIIT", "ADS", "203-C", "IIIT"};
        for(int i = 0; i < arr.length; i++)
        {
            if(st.contains(arr[i])){
                st.put(arr[i], (st.get(arr[i])+1));
            }else{
                st.put(arr[i],1);
            }
        }
        System.out.println(st.get("MSIT"));
        System.out.println(st.get("IIIT"));
        System.out.println(st.get("ADS"));
        System.out.println(st.get("203-C"));
        System.out.println("enter the input:");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int count = 0;

        for (char c : input.toCharArray())
         {
        if (c == ' ')
         {
           count++;
         }
        }
        

        String[] arrStr = new String[count+1];
        arrStr = input.split(" ",10);
        
        boolean b = false;
        for(int i = 0; i < arrStr.length ; i++)
        {
            if(!st.contains(arrStr[i]))
            {
                b = false;
                System.out.println("false");
                break;
            }
            else if (st.contains(arrStr[i]) && st.get(arrStr[i]) >= st.freq(arrStr, arrStr[i]) )
            {
                b = true;
            }
        }
        if(b == false)
        {
            System.out.println("No");
        }
        else
        {
            System.out.println("Yes");

        }

    }

}