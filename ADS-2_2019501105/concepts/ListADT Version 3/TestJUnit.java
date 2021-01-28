 /**
 * This is JUnit that tests the methods of the Clock.
 * This contains 2 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase2).
 * 
 * @author Siva Sankar
 * @author Jagan
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class TestJUnit {

   @Test
   public void testCase1() {
      System.out.println("TestCase for Add method in Lists.");
      List lst = new List();
      lst.add(5);
      System.out.println(lst.toString());
      assertEquals("1. List Object", "[5]", lst.toString());

      AbstractList lst1 = new List();
      for (int i = 0; i < 20; i++) {
         lst1.add(i);
         System.out.println(lst1.toString());
      }
      assertEquals("2. List Object through abstract class", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst1.toString());
      
      ListInterface lst2 = new List();
      for (int i = 0; i < 20; i++)
         lst2.add(i);
      System.out.println(lst2.toString());
      assertEquals("3. List Object through interface", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst2.toString());
   }

   @Test
   public void testCase2() {
      System.out.println("TestCase for Add element at specific position menthod in Lists.");
      List lst = new List();

      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      lst.add(2, 7);
      assertEquals("1. List Object", "[1,2,7,3,4,5,6]", lst.toString());
      
      lst.add(8, 7);
      assertEquals("2. List Object", "[1,2,7,3,4,5,6]", lst.toString());

      lst.add(-1, 7);
      assertEquals("3. List Object", "[1,2,7,3,4,5,6]", lst.toString());

      lst.add(0, 7);
      assertEquals("4. List Object", "[7,1,2,7,3,4,5,6]", lst.toString());
   }

   @Test
   public void testCase3() {
      System.out.println("TestCase for AddAll method in Lists.");
      List lst = new List();
      AbstractList lst1 = new List();
      ListInterface lst2 = new List();

      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "[5,1,2,3,4,5,6]", lst.toString());

      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "[6,1,2,3,4,5,6]", lst1.toString());

      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "[7,1,2,3,4,5,6]", lst2.toString());
   }

   @Test
   public void testCase4() {
      System.out.println("TestCase for Size method in Lists.");
      List lst = new List();

      assertEquals("0. List Object", "0", "" + lst.size());
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "7", "" + lst.size());

      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "7", "" + lst1.size());

      ListInterface lst2 = new List();
      lst2.add(7);      
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "7", "" + lst2.size());
   }

   @Test
   public void testCase5() {
      System.out.println("TestCase for Get method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "5", "" + lst.get(5));
      assertEquals("1. List Object", "-1", "" + lst.get(8));
      assertEquals("1. List Object", "-1", "" + lst.get(-1));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "4", "" + lst1.get(4));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.get(100));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.get(-1));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "7", "" + lst2.get(0));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(45));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(-2));
   }  

   @Test
   public void testCase6() {
      System.out.println("TestCase for Indexof method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "0", "" + lst.indexOf(5));
      assertEquals("1. List Object", "-1", "" + lst.indexOf(8));
      assertEquals("1. List Object", "-1", "" + lst.indexOf(-1));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "4", "" + lst1.indexOf(4));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.indexOf(100));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.indexOf(-1));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "6", "" + lst2.indexOf(6));
      assertEquals("3. List Object through interface", "-1", "" + lst2.indexOf(45));
      assertEquals("3. List Object through interface", "-1", "" + lst2.indexOf(-2));
   }

   @Test
   public void testCase7() {
      System.out.println("TestCase for Contains method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "true", "" + lst.contains(5));
      assertEquals("1. List Object", "false", "" + lst.contains(8));
      assertEquals("1. List Object", "false", "" + lst.contains(-1));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "true", "" + lst1.contains(4));
      assertEquals("2. List Object through abstract class", "false", "" + lst1.contains(100));
      assertEquals("2. List Object through abstract class", "false", "" + lst1.contains(-1));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "true", "" + lst2.contains(3));
      assertEquals("3. List Object through interface", "false", "" + lst2.contains(45));
      assertEquals("3. List Object through interface", "false", "" + lst2.contains(-2));
   }

   @Test
   public void testCase8() {
      System.out.println("TestCase for Remove method in Lists.");
      
      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      lst.remove(5);
      assertEquals("1. List Object", "[5,1,2,3,4,6]", lst.toString());
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      lst1.remove(3);
      assertEquals("2. List Object through abstract class", "[6,1,2,4,5,6]", lst1.toString());
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      lst2.remove(5);
      assertEquals("3. List Object through interface", "[7,1,2,3,4,6]" ,lst2.toString());
   }

   @Test
   public void testCase9() {
      System.out.println("TestCase for LastIndexOf method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "5", "" + lst.lastIndexOf(5));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("2. List Object through abstract class", "6", "" + lst1.lastIndexOf(6));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.lastIndexOf(16));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("3. List Object through interface", "6" ,""+ lst2.lastIndexOf(6));
      assertEquals("2. List Object through abstract class", "-1", "" + lst2.lastIndexOf(16));
   }

   @Test
   public void testCase10() {
      System.out.println("TestCase for Count method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      assertEquals("1. List Object", "2", "" + lst.count(5));
      assertEquals("2. List Object through interface", "0" ,""+ lst.count(16));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      assertEquals("3. List Object through abstract class", "2", "" + lst1.count(6));
      assertEquals("4. List Object through interface", "0" ,""+ lst1.count(16));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      assertEquals("5. List Object through interface", "1" ,""+ lst2.count(6));
      assertEquals("6. List Object through interface", "0" ,""+ lst2.count(16));
   }

   @Test
   public void testCase11() {
      System.out.println("TestCase for Set method in Lists.");
      List lst = new List();
      AbstractList lst1 = new List();
      ListInterface lst2 = new List();

      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      lst.set(2,7);
      assertEquals("1. List Object", "[5,1,7,3,4,5,6]", lst.toString());
   }

   @Test
   public void testCase12() {
      System.out.println("TestCase for SubList method in Lists.");
      List lst = new List();
      List lstout;

      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      lst.addAll(arr);
      lstout = lst.subList(1,4);
      assertEquals("1. List Object", "[1,2,3]", lstout.toString());
      // 6,1,2,3,4,5,6
      AbstractList lst1 = new List();
      lst1.add(6);
      lst1.addAll(arr);
      lstout = lst1.subList(2,6);
      assertEquals("2. List Object through abstract class", "[2,3,4,5]", lstout.toString());
      
      ListInterface lst2 = new List();
      lst2.add(7);
      lst2.addAll(arr);
      lstout = lst2.subList(3,5);
      assertEquals("3. List Object through interface", "[3,4]" ,lstout.toString());
      lstout = lst2.subList(0, lst2.size());
      assertEquals("3. List Object through interface", "[7,1,2,3,4,5,6]" ,lstout.toString());
      lstout = lst2.subList(0, lst2.size()-1);
      assertEquals("3. List Object through interface", "[7,1,2,3,4,5]" ,lstout.toString());
      assertNull("3. List Object through interface" , lst2.subList(-1, lst2.size()));
      assertNull("3. List Object through interface" , lst2.subList(0, 0));
      assertNull("3. List Object through interface" , lst2.subList(lst2.size(), lst2.size()));
   }

   @Test
   public void testCase13() {
      System.out.println("TestCase for Add List method in Lists.");
      List lst = new List();
      List lstin = new List();

      int[] arr = {1,2,3,4,5,6};
      lstin.addAll(arr);
      lst.addAll(lstin);
      assertEquals("1. List Object", "[1,2,3,4,5,6]", lst.toString());
      
      AbstractList lst1 = new List();
      lst1.addAll(lstin);
      assertEquals("2. List Object through abstract class", "[1,2,3,4,5,6]", lst1.toString());
      
      ListInterface lst2 = new List();
      lst2.addAll(lstin);
      assertEquals("3. List Object through interface", "[1,2,3,4,5,6]" ,lst2.toString());
   }

   @Test
   public void testCase14() {
      List l = new List();
      l.add(5);
      l.add(-1);
      assertEquals("1. ", 2, l.size());
      assertEquals("2. ", "[5,-1]", l.toString());
      l.add(0);
      l.add(99);
      assertEquals("3. ", "[5,-1,0,99]", l.toString());
      l.remove(1);
      assertEquals("4. ", "[5,0,99]", l.toString());
      assertEquals("5. ", 3, l.size());
      assertEquals("6. ", "[5,0,99]", l.toString());
      assertEquals("7. ", -1, l.indexOf(-1));
      assertEquals("8. ", 99, l.get(2));
      assertEquals("9. ", true, l.contains(5));
   }

   @Test
   public void testCase15() {
      List lst = new List();
      lst.add(8);
      lst.add(12);
      lst.add(97);
      assertEquals("1. ", "[8,12,97]", lst.toString());
      lst.add(11);
      assertEquals("2. ", 4, lst.size());
      lst.remove(12);
      assertEquals("3. ", "[8,12,97,11]", lst.toString());
      assertEquals("4. ", 4, lst.size());
      assertEquals("5. ", 0, lst.indexOf(8));
      assertEquals("6. ", 97, lst.get(2));
      assertEquals("7. ", -1, lst.get(12));
      assertEquals("8. ", -1, lst.get(5));
      assertEquals("9. ", -1, lst.get(50));
      assertEquals("9. ", true, lst.contains(97));
      lst.remove(1);
      assertEquals("10. ", false, lst.contains(12));
   }
}