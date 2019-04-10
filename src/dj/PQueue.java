package dj;

class PQueue {

	  /*
	  * Implementert etter pseudokoden i Heap-Maximum
	  */
	  public static int maximum(int[] a) {

	    return a[0];

	  }
	  
	  /*
	  * Implementert etter pseudokoden i Heap-Extract-Max
	  */
	  public static int extractMax(int[] a, int n) throws Exception {
	    
	    if (n < 1)
	      throw new Exception("heap underflow");

	    int max = a[0];
	    a[0] = a[n - 1];
	    MaxHeap.heapify(a, 0, n - 1);
	    
	    return max;

	  }

	  /*
	  * Implementert etter pseudokoden i Heap-Increase-Key
	  */
	  public static void increaseKey(int[] a, int i, int key) throws Exception {

	    if (key > a[i])
	      throw new Exception("new key is smaller than current key");

	    a[i] = key;
	    
	    int parent = (i - 1) / 2;
	    while (i > 0 && a[parent] > a[i]) {
	      int temp = a[parent];
	      a[parent] = a[i];
	      a[i] = temp;
	      i = parent;
	      parent = (i - 1) / 2;
	    }

	  }

	  /*
	  * Implementert etter pseudokoden i Max-Heap-Insert. Legg merke til at n 
	  * refererer til størrelsen på heap før innsettingen
	  */
	  public static void insert(int[] a, int key, int n) throws Exception {

	    a[n] = Integer.MAX_VALUE;
	    increaseKey(a, n, key);

	  }

	  public static void main(String[] args) {

	    int[] a = new int[100];

	    try {
	      insert(a, 23, 0);
	      insert(a, 10, 1);
	      insert(a, 2, 2);
	      insert(a, 21, 3);
	      insert(a, 9, 4);
	      insert(a, 22, 5);

	      System.out.println("max: " + extractMax(a, 6));
	      System.out.println("max: " + extractMax(a, 5));
	      System.out.println("max: " + extractMax(a, 4));
	      System.out.println("max: " + extractMax(a, 3));
	      System.out.println("max: " + extractMax(a, 2));
	      System.out.println("max: " + extractMax(a, 1));
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }

	  }

	}