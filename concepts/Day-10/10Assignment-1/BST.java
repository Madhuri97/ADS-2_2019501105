/**
 * @author Taheniyath
 */

import java.util.*;
/**
 * BST Class to implement Inerface of Binary Search Tree
 */
public class BST<Key extends Comparable<Key>, Value>{
    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public int count;
        /**
         * Constructor for class Node
         * @param key
         * @param value
         * @param count
         */
        public Node(Key key, Value value, int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
    private Node root; 
    /**
     * Put Method to insert element into Tree
     * Time Complexity : O(N)
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(x.key);
        if(compare > 0){
            x.right = put(x.right, key, value);
        }else if(compare < 0){
            x.left = put(x.left, key, value);
        }else {
            x.value = value;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * Get method to get the value of a particular key
     * Time Complexity : O(logN)
     * @param key
     * @return value
     */
    public Value get(Key key){
        Node x = root;
        while(x != null){
            int compare = key.compareTo(x.key);
            if(compare > 0){
                x = x.right;
            } else if(compare < 0){
                x = x.left;
            }else{
                return x.value;
            }
        }
        return null;
    }
    /**
     * Size method to get the size of the Tree
     * Time Complexity : O(1)
     * @return count
     */
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        return x.count;
    }
    /**
     * Floor method returns the Key that is largest key less than or equal to key
     * Time Complexity : O(LogN)
     * @param key
     * @return key
     */
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0){
            return x;
        }
        if(compare < 0){
            return floor(x.left, key);
        }
        Node t = floor(x.right,key);
        if(t != null){
            return t;
        }else{
            return x;
        }
    }
    /**
     * Time Complexity : O(LogN)
     * @param key
     * @return int number of keys less than key
     */
    public int rank(Key key){
        return rank(key, root); 
    }

    private int rank(Key key, Node x){
        if (x == null){
            return 0;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0){
            return rank(key, x.left);
        }else if (compare > 0){
            return 1 + size(x.left) + rank(key, x.right);
        }else{
            return size(x.left);
        }
    }
    /**
     * Method to delete the Minimum element form a given tree
     */
    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * Method to delete the Maximum element from a given tree
     */
    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.count = 1 + size(x.right) + size(x.left);
        return x;
    }
    /**
     * Method to delete the given Key
     * @param key
     */
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0){
            x.left = delete(x.left, key);
        }else if (compare > 0){
            x.right = delete(x.right, key);
        }else {
            if (x.right == null){
                return x.left;
            }
            if (x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * Method to get the Minimum element of a particular tree
     * @return Minimum value Key
     */
    public Key min() {
        return min(root).key;
    }
    
    private Node min(Node x){
        if (x.left == null){
            return x;
        }
        else{
            return min(x.left);
        }
    }
    /**
     * Method to get the Minimum element of a particular tree
     * @return Maximum value key
     */
    public Key max() {
        return max(root).key;
    }
    
    private Node max(Node x){
        if (x.right == null){
            return x;
        }
        else{
            return max(x.right);
        }
    }
    /**
     * Select Method returns key of rank k
     * @param k
     * @return Key of a Particular Rank
     */
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null){
            return null;
        } 
        int t = size(x.left); 
        if(t > k){
            return select(x.left,  k);
        }else if (t < k){
            return select(x.right, k-t-1);
        }else{
            return x;
        }
    }
    /**
     * Ceiling Method is used to find smallest key greater than or equal to key
     * @param key
     * @return Key 
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null){
            return null;
        }
        else{
            return x.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null){
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0){
            return x;
        }
        if (compare < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null){
                return t;
            }
            else{
                return x;
            }
        } 
        return ceiling(x.right, key); 
    }
}