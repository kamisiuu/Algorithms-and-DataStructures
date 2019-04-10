package RadixSort;

import java.util.*;
/* Radix funker veldig effektivt når det gjelder tall som ikke overstiger 100 000 tall i inputen , når det blir større input tar det mye lenger tid å sortere,
 * men det er jo ikke fast bestemt det er jo mye annet som påvirker tiden for denne algoritmer som ressurser og hvordan for eks tallene er randomisert i det tilfellet her.
* tiden for denne algoritmen er liniær på grunn av antallet av elementer og forskjellen mellom de elementene i verdien, alikevel klarer den å håndtere ganske store input.
*/
public class MainRadix {
	public static int[] a ;
	public static void main(String[] args) {		
		// ved å kalle på ChooseArray kan jeg bestemme størrelse på lista mi og blant hvilke tall jeg kan velge ut randome tall 
		
		a=ChooseArray(10000, 10000);
		
		//Antall tall
		System.out.println("Total Numbers: " + a.length);
		
		double start = System.nanoTime();	
		int[] nyA = Radix.radixsort(a, 1);
		double end = System.nanoTime();
		System.out.println("After RadixSort:");
		System.out.println(Arrays.toString(nyA));
		System.out.println("Took " + (end - start)/1000000 + " milliseconds");

	}
	private static int[] ChooseArray(int a, int b){
		int []array=new int [a];
		
		for(int i=0;i<array.length;i++){
		array[i]=new Random().nextInt(b);
		
		}
		return array;
	}
}