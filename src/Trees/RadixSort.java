package Trees;
import java.util.Random;

import CountingSort.CountingSort;
public class RadixSort extends CountingSort{
static int [] a={29,28,111,26,30};
	public static void main(String[] args) {
	
		//a=CountingSort(a);
		//int []b=ChooseArray(100,1000);
		a=RadixSort(a,3);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
			//System.out.print("\n");
		}

	}

	public static int[] RadixSort(int []A, int d){

		range = range_method(d);
		A=CountingSort(A);
		return A;
	}
	public static int range_method(int d) {
		return (int)(Math.pow(10, d) - 1);
		
	}
public static int []ChooseArray(int a, int b){
	int [] array=new int [a];
	for(int i=0;i<array.length;i++){
		array[i]=new Random().nextInt(b);
	}
	return array;
}
	
}
