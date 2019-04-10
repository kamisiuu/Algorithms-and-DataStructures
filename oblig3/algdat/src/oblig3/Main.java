package oblig3;

import java.util.Arrays;
import java.util.Random;
import oblig3.*;
public class Main {
	static int []a;
	
	public static void main(String[]args){
		char ch;
		int i=0;
		for ( ch='a'; ch<='z';ch++){
			i++;
			System.out.println(i+" "+ch);
		}
	}
	
	public static void FillArray(int ant,int MAXrange){
		a = new int [ant];
		for ( int i=0;i<ant;i++){
			Random rn= new Random();
		a[i]=rn.nextInt(MAXrange);
		}
			
	
	}
	
	
	public static int[] getA(){
		return a;
	}


	public static void setA(int[] a) {
		Main.a = a;
	}
	
}
