package QuickSortAndRandomized;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	// Den første lagrer filen fra utsiden i en string og den andre ved hjelp av ArrrayIO lagrer disse verdiene fra fil inn i en int array list
	public static String fil= "C:\\Users\\Kamil\\Desktop\\a1.data";
	public static int[] utvalgt = ArrayIO.readArray(fil);
	//her laget jeg en egen int array liste med elementer 
	public static int [] liste = {6, 5, 4, 3 };
	 public static int [] liste2=ChooseArray(100,10000);
public static void main(String[]args){
	//long StartTime og EndTime satte jeg i starten og på slutten for å måle tiden, der syso som substituerer disse to og deler for å få tid i sek
	long StartTime= System.nanoTime();
	RandomizedQuickSort(liste2, 0, liste2.length);
	System.out.println(Arrays.toString(liste2));
	//int [] a= new int [10];
	//QuickSort(utvalgt,0,utvalgt.length-1);
	//QuickSort(liste,0,liste.length-1);
	//QuickSort(Randomized100(a),0,a.length-1);
	//QuickSort(liste2,0,liste2.length-1);
	//int [] liste=ChooseArray(10,50); //QuickSort(liste,0,liste.length-1);//QuickSort(ChooseArray(10,50),0,9);
	

	long EndTime=System.nanoTime();
	System.out.println(" took "+ (EndTime-StartTime)/1000000.0 + " ms");
}

// denne metoden laget jeg selv for å velge a- input størrelse og velg ut ifra blant b randomiserte tall
public static int[] ChooseArray(int a, int b){
	int [] array=new int[a];

	for(int i=0;i<array.length;i++){
		
		array[i]=new Random().nextInt(b);
	
		}
	return array;
}
// denne metoden 
public static int[] Randomized100(int []array){
	for(int i=0;i<array.length;i++){
		array[i]=new Random().nextInt(100);
		}
	return array;
}

	
// void metode som tar imot en liste og p og r element
	public static int[] QuickSort(int [] A, int p, int r){
	
		if (p < r-1){
			
			int q = Partition (A,p,r);
			
			QuickSort(A,p, q);
		
			QuickSort(A,q+1,r);
			
			
		}return A;
	}

	public static int Partition(int[] A, int p, int r) {
		//her lagres pivoten x som r elementet i A-arraylisten
		int x=A[r-1];
		// Veggen i her settes til å være på en posisjon mindre enn p
		int i=p-1;
		// her skaper jeg int j variabelen for forløkken jeg kunne har også ha skapt den inn i den og
		int j;
		int a=0;
		//forløkken inisierer at j variabelen som er currentelement er lik p , det er starten av forløkka så
		// går forløkken helt til r pivoten og stopper like før den
		for(j=p;j<r-1;j++){
			//dersom j elementet som er currentelementet i arrayen er mindre eller lik pivoten
			//så bytter den plass med det elementet som er til høyre for veggen altså i 
			// deretter øker den veggen med 1 siden den forrige delen er sortert
			if(A[j]<=x){
				
				i=i+1;
				// her exchanger jeg variabelen
				//  en måte å swappe på int a=A[i] = A[j];
				 a=A[i];
				A[i] = A[j];
				A[j]=a;
				
				
			}
		}
		a=A[i+1];
		A[i+1]=A[r-1];
		A[r-1]=a;
		//printN(A);
		
		return i+1 ;
		
		
	}
	public static int RandomizedPartition(int [] A, int p , int r){
		Random generator= new Random();
		int i=p+ generator.nextInt(r-p);
		
		int temporary= A[r-1];
		A[r-1]=A[i];
		A[i]=temporary;
		return Partition(A, p, r);
	}

	public static int[] RandomizedQuickSort(int[]A, int p , int r){
		if(p<r-1){
			int q=RandomizedPartition(A,p,r);
			RandomizedQuickSort(A, p, q);
			RandomizedQuickSort(A,q+1, r);
		}return A;
	}
	
	












	

	

	

}
