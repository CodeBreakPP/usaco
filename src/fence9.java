/*
ID: xiny.d1
LANG: JAVA
TASK: fence9
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fence9 {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("fence9.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fence9.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());

		int output=0;
		
		for(int i=1;i<n;i++){
			
			double u=(double)m/n*i;
			
			int up=(int) Math.round(u);
			
			if((float)up/i<(float)m/n){
				
				output+=Math.max(0,up);
				System.out.println(i+" "+up);
				
			}else{
				
				output+=Math.max(0,up-1);
				System.out.println(i+" "+up);
			}
			
		}
		//output+=(m-1);
		
		if(p>n){
			
			if(n>0){
				output+=(m-1);
			}
			
			for(int i=n+1;i<p;i++){
				
				double u=(double)(m)/(p-n)*(p-i);
				
				int up=(int) Math.round(u);
				
				if((float)up/(p-i)<(float)m/(p-n)){
					
					output+=Math.max(0,up);
					System.out.println(i+" "+up);
					
				}else{
					
					output+=Math.max(0,up-1);
					System.out.println(i+" "+up);
				}
			}
			
		}else{
			for(int i=p+1;i<n;i++){
				
				double u=(double)m/(n-p)*(i-p);
				
				int up=(int) Math.round(u);
				
				if((float)up/(i-p)<=(float)m/(n-p)){
					
					output-=Math.max(0,up);
					System.out.println(i+" "+up);
					
				}else{
					
					output-=Math.max(0,up-1);
					System.out.println(i+" "+up);
				}
				
				
				
			}
			
			
		}
		

		System.out.println(output);
		out.println(output);
		out.close();

}
}
