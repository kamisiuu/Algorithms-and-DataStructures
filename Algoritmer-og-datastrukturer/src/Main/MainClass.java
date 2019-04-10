package Main;

import java.util.Arrays;
import java.util.Random;

import mergingSort.MerginSort;
import CountingSort.CountingSort;
import InsertionSort.InsertSort;
import QuickSortAndRandomized.QuickSort;
import QuickSortAndRandomized.QuickSortWITHOUTRandomized;
import Trees.RadixSort;

public class MainClass {
public static int [] a;
//public static int []a={22, 11, 5, 66, 44, 33, 1 };
	public static void main(String[]args){
		a=ChooseArray(10,20);
		long StartTimeQS=System.nanoTime();
		 // Man m� endre Digits i RadixSort.RadixSort( a, ...) her i koden, dersom man vil bytte verdier i choosearray
		QuickSort.RandomizedQuickSort(a, 0, a.length);
		System.out.println(Arrays.toString(a));
		long EndTimeQS=System.nanoTime();
		System.out.println("RANDOMIZEDQuickSort took "+(EndTimeQS-StartTimeQS)/100000.0 +" ms");
		long StartTimeQqS=System.nanoTime();
		 // Man m� endre Digits i RadixSort.RadixSort( a, ...) her i koden, dersom man vil bytte verdier i choosearray
		QuickSortWITHOUTRandomized.QuickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		long EndTimeQqS=System.nanoTime();
		System.out.println("QuickSort took "+(EndTimeQqS-StartTimeQqS)/100000.0 +" ms");
		long StartTimeIS=System.nanoTime();
		InsertSort.insertionSort(a);
		System.out.println(Arrays.toString(a));
		long EndTimeIS=System.nanoTime();
		System.out.println("InsertionSort took "+(EndTimeIS-StartTimeIS)/100000.0 +" ms");
		long StartTimeMS=System.nanoTime();
		MerginSort.MergingOfSort(a,0,a.length);
		System.out.println(Arrays.toString(a));
		long EndTimeMS=System.nanoTime();
		System.out.println("MergeSort took "+(EndTimeMS-StartTimeMS)/100000.0 +" ms");
		long StartTimeRS=System.nanoTime();
		RadixSort.RadixSort(a,4);
		System.out.println(Arrays.toString(a));
		long EndTimeRS=System.nanoTime();
		System.out.println("RadixSort took "+(EndTimeRS-StartTimeRS)/100000.0 +" ms");
		
	}
	// denne metoden bestemmer a-antall elementer i en array og b-blant random tall fra 0-b
private static int[] ChooseArray(int a, int b){
	int []array=new int [a];
	
	for(int i=0;i<array.length;i++){
	array[i]=new Random().nextInt(b);
	
	}
	return array;
}
}
