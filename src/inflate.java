/*
ID: xiny.d1
LANG: JAVA
TASK: inflate
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class inflate {
	public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("inflate.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int[]dp=new int[M+1];
		int[] weights=new int[N];
		int[] values=new int[N];
		
		for(int i=0;i<N;i++){
			
			st = new StringTokenizer(f.readLine());
			values[i]=Integer.parseInt(st.nextToken());
			weights[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int j=weights[0];j<=M;j++){
			dp[j]=dp[j-weights[0]]+values[0];
			//System.out.println(j+" "+dp[0][j]);
		}
		
		for(int i=1;i<N;i++){
			for(int j=weights[i];j<=M;j++){
				dp[j]=Math.max(dp[j-weights[i]]+values[i],dp[j]);	
			}
			
		}
		
		System.out.println(dp[M]);
		out.println(dp[M]);
		out.close();
	}
}
