package RadixSort;

public class Radix {
	public static int[] radixsort(int[] A, int r) {
		int d = (int) Math.pow(2, r);
		int[] b = null;
		// Vi bruker max 32 biters integers, vi itererer antall ganger avhengig
		// på hvor mange bit vi jamforer per gang
        for (int p = 0; p < 32/r; p++) {
            int c[] = new int[1<<d];
            // Her starter Counting-Sort
            b = new int[A.length];
            for (int i = 0; i < A.length; i++)
                c[(A[i] >> d*p)&((1<<d)-1)]++;
            for (int i = 1; i < 1<<d; i++)
                c[i] += c[i-1];
            for (int i = A.length-1; i >= 0; i--)
                b[--c[(A[i] >> d*p)&((1<<d)-1)]] = A[i];
            A = b;
        }
        return b;
	}
}