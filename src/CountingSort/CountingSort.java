package CountingSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CountingSort {

public static int range;

	public static void main (String [] args){
		int MAXvalue=Integer.MAX_VALUE;
		System.out.println(MAXvalue);
		range=2000000;
	
		int []a=new int []{22,11,44,55,33};
		a=CountingSort(a);
		printN(a);
		
	}
	
	
	private static void printN(int[] a) {
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
		}System.out.print("\n");
		
	}

	public static int[] CountingSort(int [] A){
		int [] values= new int [range +1];
		for ( int i=0; i<=range;i++){
			values[i]=0;
		}
		for(int i=0;i<A.length;i++){
			values[A[i]]++;
		}
		int[]B=new int[A.length];
		int k=0;
		for(int i=0;i<= range ; i++){
			for(int j=0; j< values[i];j++){
				B[k++]= i;
			}
		}//printN(A);
		return B;
	}
}
