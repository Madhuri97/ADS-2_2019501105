/**
 * @author Taheniyath
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val)  {
            this.key  = key;
            this.val  = val;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
    }


    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return True if the key is present otherwise returns false
     * time complexity is O(1)
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *
     * time complexity is O(N)
     */
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        if(first.key.compareTo(key) == 0){
            return exchange(first);
        }
        Node current = first;
        while(current != null) {
            if(current.next.key.compareTo(key) == 0){
                return exchange(current);
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     *
     * @param  key the key
     * @param  val the value
     * time complexity is O(N)
     */
    public void put(Key key, Value val) {
        Node node = new Node(key, val);
        // if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (first == null) {
            first = node;
            return;
        }
        Node current = first;
        while(current != null){
            if(current.key.compareTo(key)==0){
                current.val = val;
                return;
            }
            current = current.next;
        }
        Node oldFirst = first;
        first = new Node(key,val);
        first.next = oldFirst;
    }
    /**
     *
     * @param current
     * @return Value
     * time complexity is O(N)
     */
    private Value exchange(Node current){
        Node temp = current.next;
        Value val = temp.val;
        current.next = current.next.next;
        Node node = first;
        while(node.next != null) {
            node = node.next;
        }
        node.next = temp;
        temp.next = null;
        return val;
    }



    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     * time complexity is O(N)
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        Node current = first;
        while(current != null) {
            queue.enqueue(current.key);
            current = current.next;
        }
        return queue;
    }
}
