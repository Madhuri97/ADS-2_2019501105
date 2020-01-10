/**
 * @author Madhuri
 * @reference Robert Sedgewick
 */
public class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    
    public Queue() {
        first=null;
        last=null;
        n=0;
    }
    
    /**
     * this method is used to find out the queue is empty.
     * @return bool value
     */
    public boolean isEmpty() {
        return first==null;
    }
    
    /**
     * this method is used to find out the size.
     * @return n
     */
    public int size() {
        return n;
    }
    
    public Item peek() {
        if(isEmpty()) {
            System.out.println("queue underflow");
        }
        return first.item;
    }
    
    /**
     * this method is used to insert value into queue.
     * @param item
     */
    public void enqueue(Item item) {
        Node<Item> oldlast=last;
        last=new Node<Item>();
        last.item=item;
        last.next=null;
        if(isEmpty()) {
            first=last;
        } else {
            oldlast.next=last;
        }
        n++;
    }
    
    /**
     * this method is used to delete the elements from queue.
     * @return
     */
    public Item dequeue() {
        if(isEmpty()) {
            System.out.println("queue is underflow");
        }
        Item item=first.item;
        first=first.next;
        n--;
        if(isEmpty()) { 
            last=null;
        }
        return item;
    }
}
