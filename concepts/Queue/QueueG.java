public class QueueG <Item> {
    
    private Node first = null;
    private Node last = null;
    int size = 0;

    public class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        if(first == null) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void Enqueue(Item item) {
        Node oldLast = last; 
        last = new Node();
        last.item = item;
        last.next = null;
        // last.next = oldLast;
        size++;
        if(isEmpty()) {
            first = last;
        } else oldLast.next = last;
    }

    public Item Dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        size--;
        return item;
    }
}
