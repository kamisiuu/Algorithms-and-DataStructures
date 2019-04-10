package InsertionSort;

import java.util.Random;


public class InsertSort {


	public static String fil="C:\\Users\\Kamil\\Desktop\\a1.data";
	public static int [] utvalgt= ArrayIO.readArray(fil);
	
	
	    public static void main(String[] args) {
	         
	       int [] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
	       int [] liste= ChooseArray(2500,2500);
	        // insertionSort(input);
	        long StartTime = System.nanoTime();
	       // int [] a = new int [10];
	        
	        //for ( int i = 0 ; i<a.length ; i++){
	        	//a[i]= new Random().nextInt(100);
	        	
	        	
	       // } 
	        
	        insertionSort(liste);
	        printNumbers(liste);
	        
	        long EndTime=System.nanoTime();
	        
	    	System.out.println(" took "+ (EndTime-StartTime)/1000000.0 + " ms");
	        }
	    public static int [] ChooseArray(int a, int b){
	    	int [] array= new int[a];
	    	for(int i=0;i<array.length;i++){
	    		array[i]=new Random().nextInt(b);
	    	}
	    	return array;
	    }
	    private static void printNumbers(int[] input) {
	         
	        for (int i = 0; i < input.length; i++) {
	            System.out.print(input[i] + " ");
	        }
	        System.out.println("\n");
	    }
	 
	    public static void insertionSort(int array[]) {
	        int n = array.length;
	        for (int j = 1; j < n; j++) {
	            int key = array[j];
	            int i = j-1;
	            while ( (i > -1) && ( array [i] > key ) ) {
	                array [i+1] = array [i];
	                i--;
	            }
	            array[i+1] = key;
	           //printNumbers(array);
	        }
	    }
	}
