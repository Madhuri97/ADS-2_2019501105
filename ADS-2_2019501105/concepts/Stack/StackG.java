public class StackG<Item> {

    private Node first = null;
    int size = 0;
    
    public class Node {
        Item item;
        Node next;
    }
    
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(first == null) {
            return true;
        }
        return false;
    }
}
