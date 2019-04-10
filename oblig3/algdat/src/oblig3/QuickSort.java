package oblig3;

import java.util.Random;

class QuickSort {

  public static int partition(int[] a, int p, int r) {

    int x = a[r - 1];
    int i = p - 1;
    int temp = 0;

    for (int j = p; j < r - 1; j++) {
      
      if (a[j] <= x) {

        i++;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;

      }

    }

    temp = a[i + 1];
    a[i + 1] = a[r - 1];
    a[r - 1] = temp;

    return i + 1;

  }

  public static int[] sort(int[] a, int p, int r) {

    if (p < r - 1) {

      int q = partition(a, p, r);
      sort(a, p, q);
      sort(a, q + 1, r);

    }

    return a;

  }

  private static Random random = new Random();

  public static int randomizedPartition(int[] a, int p, int r) {

    int i = p + random.nextInt(r - p);

    int temp = a[r - 1];
    a[r - 1] = a[i];
    a[i] = temp;
    
    return partition(a, p, r);

  }

  public static int[] randomizedSort(int[] a, int p, int r) {
    
    if (p < r - 1) {

      int q = randomizedPartition(a, p, r);
      randomizedSort(a, p, q);
      randomizedSort(a, q + 1, r);

    }

    return a;

  }

  

}

