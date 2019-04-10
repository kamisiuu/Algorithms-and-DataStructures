package oblig3;

public class MerginSort {
	  
	  
	public static void main(String [] args){
		//new ArrayList<Integer>() = {1, 2, 4, 5, 3, 10, 7, 8, 11, 21, 31, 12, 134, 134, 124, 145, 144, 111, 289, 340, 502};
	
	
		int [] liste={1, 2, 6, 3, 4, 10, 7};
		MergingOfSort(liste, 0, liste.length);
		//tester her ut hvordan jeg skal hente ut siste elementet i en array
		for (int i = 0; i < liste.length; i++) {
			System.out.println(liste[i]);
		}
 }

public static void MERGE(int[]A,int p, int q, int r){
	   
	  int n1=q-p;
	  int n2=r-q;
	  int [] L= new int[n1+1];
	  int [] R= new int[n2+1];
	 
	  int i; 
	  for(i=0; i<n1;i++){
		  L[i]=A[p+i];
	  }
	  int j;
	  for(j=0;j<n2;j++){
		  R[j]=A[q+j];
	  }
	  L[n1]=Integer.MAX_VALUE;
	  R[n2]=Integer.MAX_VALUE;
	  i=0;
	  j=0;
	  for(int k=p;k<r;k++){
		  if (L[i]<= R[j]) {
			A[k]=L[i];
			i+=1;
		}else  {
			A[k]=R[j];
			j+=1;
		}
	  }
  }
  public static void MergingOfSort(int []A, int p, int r){
	  if (r - p > 1) {
		  int q = (p + r) / 2;
		  MergingOfSort(A, p, q);
		  MergingOfSort(A, q, r);
		  MERGE(A, p, q, r);
		
	  }

  }
}
	 
  
