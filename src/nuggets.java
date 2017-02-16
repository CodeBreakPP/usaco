/*
ID: xiny.d1
LANG: JAVA
TASK: nuggets
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class nuggets {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("nuggets.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("nuggets.out")));
		int N=Integer.parseInt(f.readLine());
		HashSet<Integer> intset=new HashSet<Integer>();
		Integer[]ns=new Integer[N];
		
		for(int i=0;i<N;i++){
			intset.add(Integer.parseInt(f.readLine()));
		}
		
		intset.toArray(ns);
		Arrays.sort(ns);
		int len=ns.length;
		int mini=ns[0];
		
		if(len==1){
			out.println(0);
		}else if(mini==1){
			
			
			out.println(0);
			
		}else{
			
			int divisor=mgcd(ns);
			
			if(divisor>1){
				
				out.println(0);
			}else{
			
			
			Set<Integer> is=new HashSet<Integer>();
			int j=mini;
			
			for(int k=0;k<len;k++){
				
				is.add(ns[k]);
				
			}
			int con=0;
			int output=j-1;
			
			while(true){
				
				if(is.contains(j)){
					
					for(int k=0;k<len;k++){
						
						is.add(j+ns[k]);
						
					}
					con++;
					
				}else{
					
					output=j;
					con=0;
					
				}
				
				if(con==mini){
					break;
				}
				
				++j;
			}
			System.out.println(output);
			out.println(output);
			
			}
			
		}
		
		out.close();
}


public static int mgcd(Integer[] ary){
	int len=ary.length;
	int output=ary[0];
	for(int i=1;i<len;i++){
		output=gcd(output,ary[i]);
	}
	return output;
	
/*	int[] outputs=new int[len];
	for(int i=0;i<len;i++){
		
		outputs[i]=ary[i]/output;
		
	}
	
	return outputs;*/
	
}

public static int gcd(int x,int y){
	
	if(x==0||y==0){
		return Math.max(x, y);
	}
	
	if(x<y){
		int swap=x;
		x=y;
		y=swap;
	}
	
	int r=x%y;
	
	while(r>0){
		
		x=y;
		y=r;
		r=x%y;

	}
	
	return y;
	
}


}
