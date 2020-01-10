/**
 * This is JUnit that tests the lower method in StringHandling class.
 * This contains 79 testcases.
 * 
 * Please don"t run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase6).
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
  BinarySearchST<String, Integer> symbolTable = new BinarySearchST<String, Integer>();
  symbolTable.put("S",0);
  symbolTable.put("E",1);
  symbolTable.put("A",2);
  symbolTable.put("R",3);
  symbolTable.put("C",4);
  symbolTable.put("H",5);
  symbolTable.put("E",6);
  symbolTable.put("X",7);
  symbolTable.put("A",8);
  symbolTable.put("M",9);
  symbolTable.put("P",10);
  symbolTable.put("L",11);
  symbolTable.put("E",12);
  Assert.assertEquals("X", symbolTable.max());
  Assert.assertEquals("R", symbolTable.floor("R"));
  Assert.assertEquals(1, symbolTable.rank("B"));
  symbolTable.deleteMin();
  Assert.assertEquals(true, symbolTable.contains("C"));
  // String[] arr = {"C","E","H","L","M","P","R","S","X"};
  List<String> arr = new ArrayList<String>(List.of("C","E","H","L","M","P","R","S","X"));
  String res = "";
  for(String s: arr){
  	res += s + " ";
  }
  Assert.assertEquals(res, symbolTable.keys().toString());
}

@Test
public void testCase2() {
  BinarySearchST<String, Integer> symbolTable = new BinarySearchST<String, Integer>();
  symbolTable.put("E",0);
  symbolTable.put("A",1);
  symbolTable.put("S",2);
  symbolTable.put("Y",3);
  symbolTable.put("Q",4);
  symbolTable.put("U",5);
  symbolTable.put("E",6);
  symbolTable.put("S",7);
  symbolTable.put("T",8);
  symbolTable.put("I",9);
  symbolTable.put("O",10);
  symbolTable.put("N",11);
  symbolTable.deleteMin();
  symbolTable.deleteMin();
  symbolTable.deleteMin();
  symbolTable.deleteMin();
  Assert.assertEquals("Y", symbolTable.max());
  List<String> arr = new ArrayList<String>(List.of("O","Q","S","T","U","Y"));
  String res = "";
  for(String s: arr){
  	res += s + " ";
  }
  Assert.assertEquals(res, symbolTable.keys().toString());
  Assert.assertEquals("Y", symbolTable.floor("Z"));
  Assert.assertEquals("Y", symbolTable.floor("Y"));
  Assert.assertEquals("O", symbolTable.floor("P"));
  Assert.assertEquals(1, symbolTable.rank("P"));
  Assert.assertEquals(false, symbolTable.contains("Z"));
}
@Test
public void testCase3() {
  BinarySearchST<String, Integer> symbolTable = new BinarySearchST<String, Integer>();
  symbolTable.put("S",0);
  symbolTable.put("O",1);
  symbolTable.put("R",2);
  symbolTable.put("T",3);
  symbolTable.put("E",4);
  symbolTable.put("X",5);
  symbolTable.put("A",6);
  symbolTable.put("M",7);
  symbolTable.put("P",8);
  symbolTable.put("L",9);
  symbolTable.put("E",10);
  Assert.assertEquals("X", symbolTable.max());
  symbolTable.deleteMin();
  List<String> arr = new ArrayList<String>(List.of("E","L","M","O","P","R", "S", "T", "X"));
  String res = "";
  for(String s: arr){
  	res += s + " ";
  }
  Assert.assertEquals(res, symbolTable.keys().toString());
  Assert.assertEquals(0, symbolTable.rank("A"));
  Assert.assertEquals(0, symbolTable.rank("B"));
  Assert.assertEquals(0, symbolTable.rank("C"));
  Assert.assertEquals(0, symbolTable.rank("D"));
  Assert.assertEquals(0, symbolTable.rank("E"));
  Assert.assertEquals(9, symbolTable.rank("Z"));
  Assert.assertEquals(9, symbolTable.rank("Y"));
  Assert.assertEquals(true, symbolTable.contains("X"));
  Assert.assertEquals(new Integer(5), symbolTable.get("X"));
  Assert.assertEquals("T", symbolTable.floor("T"));

}

}

