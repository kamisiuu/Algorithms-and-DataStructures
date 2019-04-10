package InsertionSort;

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class ArrayIO {

	  /*
	  * Les inn en array med heltall fra fil
	  */
	  public static int[] readArray(String filename) {
	    try {
	      StreamTokenizer tokens = new StreamTokenizer(new FileReader(filename));
	      int n = readN(tokens);
	      return readData(tokens, n); 
	    }
	    catch (Exception e) {
	      return null;
	    }
	  }

	  public static void printArray(int[] a) {
	    System.out.println(Arrays.toString(a));
	  }

	  private static int readN(StreamTokenizer tokens) throws Exception {
	    int token = tokens.nextToken();
	    assert(token==StreamTokenizer.TT_NUMBER);
	    return (int)tokens.nval;
	  }

	  private static int[] readData(StreamTokenizer tokens, int num) 
	      throws Exception {
	    int i = 0;
	    int[] data = new int[num];
	    while (i<num) {
	      int token = tokens.nextToken();
	      assert(token==StreamTokenizer.TT_NUMBER);
	      data[i++] = (int)tokens.nval;
	    }
	    return data;
	  }

	}
