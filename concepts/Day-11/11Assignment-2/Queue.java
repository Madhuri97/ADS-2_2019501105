/**
 * @author Taheniyath
 */
import java.util.*;
/**
 * Here we implementing the iterable 
 * class to iterate all the items in the queue
 */
public class Queue<Item> implements Iterable<Item> {
    public Item[] q;
    public int n;
    public int first;
    public int last;

    public Queue() {
        this.q = (Item[]) new Object[2];
        this.n = 0;
        this.first = 0;
        this.last = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }
 
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }
    /**
     * this is used to enqueue the item in the queue
     * @param item
     */
    public void enqueue(Item item) {
        if (n == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }
    /**
     * this is used to dequeue the item which is in first place
     * @return item
     * 
     */
    public Item dequeue() {
        Item item = q[first];
        q[first] = null;
        n--;
        first++;
        if (first == q.length) first = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2); 
        return item;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public String toString(){
        String st = "";
        int i;
        for (i = 0; i < last ; i++) {
            st += q[i] + " ";
        }
        return st;
    }
    
}
