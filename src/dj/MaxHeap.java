package dj;


/*
* En max-heap. Jeg har implementert en utgave som gjenspeiler koden i boka, og
* har derfor ikke lagt vekt på OOP og Java design prinsipler. Dette gjør koden
* mindre gjenbrukbar, men forhåpentlig kommer selve datastrukturen og 
* algoritmene tydeligere frem.
*/
class MaxHeap {

  /*
  * Implementert etter Max-Heapify pseudokode
  */
  public static void heapify(int[] a, int i, int n) {

    int left = 2 * i + 1;
    int right = 2 * i + 2;

    int largest;
    if (left < n && a[left] < a[i])
      largest = left;
    else
      largest = i;
    if (right < n && a[right] < a[largest])
      largest = right;

    if (largest != i) {
      int temp = a[largest];
      a[largest] = a[i];
      a[i] = temp;
      heapify(a, largest, n);
    }

  }

  /*
  * Implementert etter Build-Max-Heap pseudokoden
  */
  public static void buildHeap(int[] a, int n) {
    
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(a, i, n);

  }


}