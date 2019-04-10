package oblig3;

import java.util.Random;

public class InsertionSort {
	
public static void InsertionSort(int [] array){

	for(int i=1;i<array.length;i++){
		 int element = array[i];
		 int j = i;
		 
		 while( j> 0 && array[j-1] > element){
			 array[j] = array[j -1];
			 j = j - 1;
			 
		 }array[j] = element;
	}for(int k=0;k<array.length;k++){
		System.out.println(array[k]);
	}
	

	
}

}
