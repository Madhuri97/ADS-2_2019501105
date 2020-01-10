/**
 * Implement card Deck sort. Put a deck of cards 
 * in order by suit (in the order spades, hearts, 
 * clubs, diamonds) and by rank within each suit, 
 * with the restriction that the cards must be laid
 * out face down in a row, and the only allowed 
 * operations are to check the values of two cards 
 * and to exchange two cards (keeping them face down).
 * (Sorting)
 */
import java.util.*;
import java.util.List;
import java.util.Collections;
/**
 * @author Madhuri
 * @reference http://www.mathcs.emory.edu/
 */

class DeckOfCards {
    /**
     * 
     * @param a [] an array of type Card
     * @return sorted card array for the given values
     * It sorts the array based on the compareTo method 
     * in Card class I sorted using selection sort method
     * Time complexity is O(n^2).
     */

    public Card[] selectionSort(Card[] a) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
            if (a[j].compareTo(a[min]) < 0) min = j;
        } 
            Card temp = a[i];
		    a[i] = a[min];
			a[min] = temp;
	} return a;
}


    public static void main(String[] args) {
        //taking two arrays one contains faces of card and another has suits.
        int [] value ={1,2,3,4,5,6,7,8,9,10,11,12,13};
        int [] type = {1,2,3,4};
        //declaring a new array where we will be storing our cards and it is type of card
        Card [] card = new Card[52];
        int n = 0;
        for(int i = 0; i < value.length; i++) {
            for(int j = 0; j < type.length; j++) {
               card[n++] = new Card(value[i], type[j]); 
            }
        } 
        //creating an object.
        DeckOfCards dc = new DeckOfCards();
        //to shuffel the array we are converting it into the List.
        List<Card> crdlst = Arrays.asList(card);
        Collections.shuffle(crdlst);
        //converting the list in to array as it is shuffled.
        crdlst.toArray(card);
        //using selection sort method we are sorting the array and printing.
        System.out.println(Arrays.toString(dc.selectionSort(card)));     
    }
}
