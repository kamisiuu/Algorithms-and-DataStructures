package Matrix;

public class MatrixMain {
// her må det lages to filer med matriser inn i for å få kjørt koden
public static String fil="C:\\Users\\Kamil\\Desktop\\m1.data";
public static String fil2="C:\\Users\\Kamil\\Desktop\\m1.data";
public static String s="sss";

	public static void main(String[] args) {
	
			
			
			Matrix a=MatrixIO.readMatrix(fil);
			
			Matrix b= MatrixIO.readMatrix(fil2);
			
			Matrix c = beregn(a,b);
			System.out.println(c);
			
		//System.out.println(MatrixIO.readMatrix(fil2).toString());
	}

	

	public static Matrix beregn(Matrix a, Matrix b) {
		
		int n= a.n;
			Matrix c = new Matrix(n);
		
			if(n == 1){
			
				c.set(0,0,a.get(0,0)*b.get(0,0));
		
				return c;
		
		}
		else{
			
			Matrix[] adel = a.partition(); 
			Matrix[] bdel = b.partition();
			Matrix[] cdel = c.partition();
			Matrix.add( 
				beregn(adel[0],bdel[0]), beregn(adel[1],bdel[2]), cdel[0] );
			Matrix.add( 
				beregn(adel[0],bdel[1]), beregn(adel[1],bdel[3]), cdel[1] );
			Matrix.add( 
				beregn(adel[2],bdel[0]), beregn(adel[3],bdel[2]), cdel[2] );
			Matrix.add( 
				beregn(adel[2],bdel[1]), beregn(adel[3],bdel[3]), cdel[3] );
			c.unPartition(cdel); 
		} 
		return c;
	}

	
	

}
