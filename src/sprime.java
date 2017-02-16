/*
ID: xiny.d1
LANG: JAVA
TASK: sprime
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class sprime {
	
	static ArrayList<Integer> output;
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		Integer N=Integer.parseInt(f.readLine());
		output=new ArrayList<Integer>();
		if(N==1){
			
			out.println(2);
			out.println(3);
			out.println(5);
			out.println(7);
			
		}else{
		
			int[] primes={2,3,5,7};
			for(int i=0;i<4;i++){
				genPrime(N-1,primes[i]+"");
			}
		
		
		
		for(int k=0;k<output.size();k++){
			out.println(output.get(k));
			
		}
		
		
		}
		
		out.close();

	}
	
	static void genPrime(int N,String pre){
		
		if(N==1){
		
		for(int i=1;i<=9;i+=2){
			Integer prime=Integer.parseInt(pre+i);
			if(isPrime(prime)){output.add(prime);};
			
		}
		
		}else{
			
			for(int i=1;i<=9;i+=2){
				Integer prime=Integer.parseInt(pre+i);
				if(isPrime(prime)){
					genPrime(N-1,pre+i);
				};
				
			}
			
			
			
		}
		
		
		
		
		
		
	}
	
	public static Boolean isPrime(Integer prime){
		
		
		for(int j=3;j<=Math.sqrt(prime);j+=2){
			if(prime%j==0){
				return false;
			}
		}
		
	return true;
	}
}