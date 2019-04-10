package oblig3;

class RadixSort {

  public static int[] sort(int[] a, int r) {
    
    int d = 32 / r + ((32 % r) > 0 ? 1 : 0);
    int[] b = new int[a.length];      // Output array
    int[] temp = null;                // Used to switch between a and b between
                                      // digit iterations
    int mask = (int)Math.pow(2, r)-1; // A mask that is used to fetch r lowest
                                      // bits from an integer
    int k = (int)Math.pow(2, r);
    int[] c = new int[k];

    for (int i = 0; i < d; i++) {
      
      // Counting sort

      for (int l = 0; l < k; l++)
        c[l] = 0;
      for (int j = 0; j < a.length; j++) 
        c[(a[j] >> (i * r) & mask)] += 1;
      for (int l = 1; l < k; l++)
        c[l] += c[l-1];
      for (int j = a.length - 1; j >= 0; j--) {
        int digit = (a[j] >> (i * r) & mask);
        b[c[digit]-1] = a[j];
        c[digit] -= 1;
      }
      
      temp = b;
      b = a;
      a = temp;

    }

    return a;

  }

  

}
