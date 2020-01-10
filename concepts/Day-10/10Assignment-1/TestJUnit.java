/**
 * This is JUnit that tests the lower method in StringHandling class.
 * This contains 1 testcases.
 * 
 * Please don"t run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase1).
 * 
 * @author Deepak Kumar
 */

import org.junit.Test;
import org.junit.Assert;
import java.util.*;
import java.lang.*;
// import static org.junit.Assert.assertEquals;

public class TestJUnit {
  @Test
  public void testCase1() {
    BST<Book,Integer> bst = new BST<Book,Integer>();
    bst.put(new Book("Algorithms","Bob Sedgewick",6000.0),1);
    bst.put(new Book("Python","eric",5000.0),2);
    Assert.assertEquals(new Integer(1), bst.get(new Book("Algorithms","Bob Sedgewick",6000.0)));
    bst.put(new Book("Hello","Ajay",200.0),5);
    bst.put(new Book("IT","Viswas",400.0),2);
    Assert.assertEquals("Python", bst.max().title);
    bst.deleteMax();
    bst.delete(new Book("Algorithms","Bob Sedgewick",6000.0));
    Assert.assertEquals("Hello", bst.min().title);
    bst.deleteMin();
    Assert.assertEquals(new Integer(2), bst.get(new Book("IT","Viswas",400.0)));
    Assert.assertEquals("IT", bst.min().title);
    Assert.assertEquals("IT",bst.select(0).title);
    }
@Test
  public void testCase2() {
    BST<Book,Integer> bst = new BST<Book,Integer>();
    bst.put(new Book("Harry","JK",600.0),1);
    bst.put(new Book("IT","Viswas",400.0),2);
    bst.put(new Book("Street","Kiran",800.0),6);
    Assert.assertEquals("Harry", bst.min().title);
    bst.deleteMin();
    bst.put(new Book("Street","Kiran",800.0),6);
    bst.put(new Book("Mental","Robert",1800.0),8);
    bst.put(new Book("TheBook","Joy",24000.0),9);
    Assert.assertEquals("TheBook", bst.max().title);
    bst.deleteMax();
    Assert.assertEquals(new Integer(6), bst.get(new Book("Street","Kiran",800.0)));
    bst.put(new Book("Hello","Ajay",200.0),5);
    Assert.assertEquals("Street",bst.floor(new Book("Street","Kiran",800.0)).title);
    bst.delete(new Book("Street","Kiran",800.0));
    Assert.assertEquals("Mental",bst.floor(new Book("Street","Kiran",800.0)).title);
    Assert.assertEquals(new Integer(5), bst.get(new Book("Hello","Ajay",200.0)));
    Assert.assertEquals("Hello", bst.min().title);
    bst.put(new Book("Hello","Ajay",200.0),7);
    Assert.assertEquals(new Integer(7), bst.get(new Book("Hello","Ajay",200.0)));
    Assert.assertEquals("Mental", bst.max().title);
    Assert.assertEquals("IT",bst.select(1).title);
    Assert.assertEquals(new Integer(2), bst.get(new Book("IT","Viswas",400.0)));
  }
@Test
  public void testCase3() {
    BST<Book,Integer> bst = new BST<Book,Integer>();
    bst.put(new Book("Harry","JK",600.0),1);
    Assert.assertEquals("Harry", bst.max().title);
    bst.put(new Book("IT","Viswas",400.0),2);
    Assert.assertEquals("Harry", bst.min().title);
    bst.put(new Book("Street","Kiran",800.0),6);
    bst.put(new Book("Anamy","Steave",1600.0),7);
    bst.put(new Book("Mental","Robert",1800.0),8);
    bst.put(new Book("TheBook","Joy",24000.0),9);
    Assert.assertEquals("TheBook",bst.floor(new Book("Ttreet","Kiran",800.0)).title);
    Assert.assertEquals("IT",bst.ceiling(new Book("Heet","Kiran",800.0)).title);
    bst.put(new Book("Hello","Ajay",200.0),5);
    Assert.assertEquals("IT",bst.select(3).title);
    bst.put(new Book("Hello","Ajay",200.0),7);
    Assert.assertEquals("Anamy", bst.min().title);
    bst.deleteMin();
    Assert.assertEquals("Harry", bst.min().title);
    Assert.assertEquals("TheBook", bst.max().title);
    bst.deleteMax();
    Assert.assertEquals("Street", bst.max().title);
    bst.delete(new Book("TheBook","Joy",24000.0));
    }



}

