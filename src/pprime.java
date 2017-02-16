/*
ID: xiny.d1
LANG: JAVA
TASK: pprime
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {
	static ArrayList<Integer> output;
	static Integer aint;
	static Integer bint;
	static int[] primes={2,3,5,7,11,13,17,19,23,29,31,37,41,43, 47 ,53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
			127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
			179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
			233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
			283, 293, 307, 311, 313, 317, 331, 337, 347, 349};

	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String a=(st.nextToken());
		aint=Integer.parseInt(a);
		String b=(st.nextToken());
		bint=Integer.parseInt(b);
		Integer lena=a.length();
		Integer lenb=b.length();
		//System.out.println(b);
		//System.out.println(b.charAt(0));
		
		output=new ArrayList<Integer>();
		
		for(int i=lena;i<=lenb;i++){
			
			if(i==10)break;
			
			for(int j=1;j<=9;j+=2){
				if(i==lenb&j>(int)(b.charAt(0))){
					break;
				}
				if(i>=3){
					generatePan(i-2,j+"");
				}else{
					if(i==1){
			    		if(j>=aint&j<=bint&(j==5|j==7)){
			    			output.add(j);
			    		}	
					}	
			    	if(j==1&i==2){output.add(11);};
				}
			}
		}
		
		
		for(int k=0;k<output.size();k++){
			out.println(output.get(k));
			
		}
		out.close();

	}
	
	public static void generatePan(int digits,String front){

	    if(digits==1){
	    	
		    StringBuffer sb = new StringBuffer(front);
			String behind=sb.reverse().toString();
	    	
	    	for(int i=0;i<=9;i++){
	    		
	    		String news=front+i+behind;
	    		Integer newp=Integer.parseInt(news);
	    		if(newp>=aint&newp<=bint&isPrime(newp)){
	    			
	    			output.add(newp);
	    		}	
	    	}
	    	
	    }else if(digits==2){
		    StringBuffer sb = new StringBuffer(front);
			String behind=sb.reverse().toString();
			
	    	for(int i=0;i<=9;i++){
	    		
	    		String news=front+i+i+behind;
	    		Integer newp=Integer.parseInt(news);

	    		if(newp>=aint&newp<=bint&isPrime(newp)){
	    			output.add(newp);
	    		}
	    	}
	    	
	    }else{
	    	for(int i=0;i<=9;i++){
	    		generatePan(digits-2,front+i);
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