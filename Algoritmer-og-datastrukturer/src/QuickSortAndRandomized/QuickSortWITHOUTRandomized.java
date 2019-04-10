package QuickSortAndRandomized;

import java.util.Arrays;
import java.util.Random;

public class QuickSortWITHOUTRandomized {
public static int []liste={10, 5, 3, 2, 1, 22}; 
	public static void main(String[]args){
		//long StartTime og EndTime satte jeg i starten og på slutten for å måle tiden, der syso som substituerer disse to og deler for å få tid i sek
		
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
		
			if (p < r){
				
				int q = Partition (A,p,r);
				
				QuickSort(A,p, q-1);
			
				QuickSort(A,q+1,r);
				
				
			}return A;
		}

		public static int Partition(int[] A, int p, int r) {
			//her lagres pivoten x som r elementet i A-arraylisten
			int x=A[r];
			// Veggen i her settes til å være på en posisjon mindre enn p
			int i=p-1;
			// her skaper jeg int j variabelen for forløkken jeg kunne har også ha skapt den inn i den og
			int j;
			int a=0;
			//forløkken inisierer at j variabelen som er currentelement er lik p , det er starten av forløkka så
			// går forløkken helt til r pivoten og stopper like før den
			for(j=p;j<r;j++){
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
			A[i+1]=A[r];
			A[r]=a;
			//printN(A);
			
			return i+1 ;
			
			
		}

}
