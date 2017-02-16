/*
ID: xiny.d1
LANG: JAVA
TASK: fact4
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class fact4 {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("fact4.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		int N=Integer.parseInt(f.readLine());
		
		BigInteger bi=new BigInteger("1");
		
		int total5=0;
		for(int i=2;i<=N;i++){
			bi=bi.multiply(new BigInteger(""+i));
			int j=i;
			while(j%5==0){
				total5+=1;
				j=j/5;
						
			}			
		}
		
		String bs=bi.toString();
		int length=bs.length();
			System.out.println(bs.charAt(length-total5-1));
			out.println(bs.charAt(length-total5-1));

		out.close();
		}
}
