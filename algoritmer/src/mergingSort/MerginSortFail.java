package mergingSort;

import java.util.ArrayList;

import javax.swing.SortingFocusTraversalPolicy;



public class MerginSortFail {
	  
	  
 public static void main(String [] args){
//new ArrayList<Integer>() = {1, 2, 4, 5, 3, 10, 7, 8, 11, 21, 31, 12, 134, 134, 124, 145, 144, 111, 289, 340, 502};
	//MergingOfSort(liste, 0, liste.length-1);
	
	
	 //int [] liste={1, 2, 6};
	//tester her ut hvordan jeg skal hente ut siste elementet i en array
	//System.out.println(liste[liste.length-1]);
 }
 
  
 


public static void MERGE(int[]A,int p, int q, int r){
	   
	  
	  int n1=q-p+1;
	  int n2=r-q;
	  int [] L= new int[n1+1];
	  int [] R= new int[n2+1];
	  int max=Integer.MAX_VALUE;
	  int max2=Integer.MAX_VALUE;
	  for(int i=0; i<n2;i++){
		  L[i]=A[p+i-1];
	
	  }
	  
	  for(int j=0;j<n2;j++){
		  R[j]=A[q+j];
		  
		  
	  }
	  L[n1+1]=max;
	  R[n2+1]=max2;
	  int i=0;
	  int j=0;
	  for(int k=p;k<=r;k++){
		  if (L[i]<= R[j]) {
			A[k]=L[i];
			i=i+1;
			
		}else  {
			A[k]=R[j];
			j=j+1;
		}
	  }
  }
  public static void MergingOfSort(int []A, int p, int r){
	  
	  //p=A[0];
	  //r=A[A.length-1];
	  int q;
	  
	  if (p<r) {
		  System.out.println("p:"+p);
		  System.out.println("r:"+r);
		  q=(int) Math.floor((p+r)/2);
		  System.out.println("q:"+q);
		  MergingOfSort(A, p, q);
		  MergingOfSort(A,q+1,r);
		  MERGE(A, p, q, r);
		
	}

  }
}
	 
  
