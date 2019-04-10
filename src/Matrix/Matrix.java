package Matrix;
import java.util.Arrays;

/*
* En klasse som representerer en nxn matrise.  
*/
class Matrix {

  public float[] m;
  public int n;

  /*
  * Lager en ny matrise med st�rrelse nxn
  */
  public Matrix(int n) {
    this.m = new float[n*n];
    this.n = n;
  }
  /*
  * Lager en ny nxn matrise med spesifersert data
  */
  public Matrix(int n, float[] m) {
	  
    assert(n*n==m.length);
    this.m = m;
    this.n = n;
  }

  /*
  * Returnerer elementet p� rad i og kolonne j
  */
  public float get(int i, int j) {
    assert( i>=0 && i<n && j>=0 && j<n );
    return m[i*n+j];
  }

  /*
  * Setter elementet p� rad i og kolonne j til x
  */
  public void set(int i, int j, float x) {
    assert( i>=0 && i<n && j>=0 && j<n );
    m[i*n+j] = x;
  }

  /*
  * Partisjonerer en matrise til fire nye delmatriser med st�rrelse n/2 x n/2. 
  * Det allokeres nytt minne for hver delmatrise og innholdet fra 
  * forelder-matrisen kopieres inn.
  */
  public Matrix[] partition() {

    int partN = n / 2;        // Den nye st�rrelsen 
    Matrix[] parts = {       // De nye delmatrisene
      new Matrix(partN),
      new Matrix(partN),
      new Matrix(partN),
      new Matrix(partN) 
    };

    /* Kopierer inn innholdet delmatrisene */
    for (int p = 0; p < parts.length; p++) {

      int pI = p / 2;         // 0 for f�rste delrad i matrisen, 1 for andre
      int pJ = p % 2;        // 0 for f�rste delkolonne i matrisen, 1 for andre

      for (int i = 0; i < partN; i++)
        for (int j = 0; j < partN; j++)
          parts[p].set(i, j, get((pI * partN + i), (pJ * partN + j)));

    }

    return parts;

  }

  /*
  * Setter sammen fire delmatriser i en matrise. Den kopierer innholdet fra
  * delmatrisene i parts inn i matrisen.
  */
  public Matrix unPartition(Matrix[] parts) {

    int partN = n / 2;
    

    /* Kopierer inn innholdet fra delmatrisene inn p� korrekt plass*/
    for (int p = 0; p < parts.length; p++) {

      assert(partN==parts[p].n);

      int pI = p / 2;         // 0 for f�rste delrad i matrisen, 1 for andre
      int pJ = p % 2;         // 0 for f�rste delkolonne i matrisen, 1 for andre

      for (int i = 0; i < partN; i++)
        for (int j = 0; j < partN; j++)
          set((pI * partN + i), (pJ * partN + j), 
            parts[p].get(i, j));

    }

    return this;

  }

  /*
  * Adderer innholdet i a og b og legger resultatet i c
  */
  public static Matrix add(Matrix a, Matrix b, Matrix c) {

    for (int i = 0; i < a.m.length; i++)
      c.m[i] = a.m[i] + b.m[i];

    return c;

  }

  public String toString() {
    return Arrays.toString(m);
  }

}
