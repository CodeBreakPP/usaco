/*
ID: xiny.d1
LANG: JAVA
TASK: money
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class money {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("money.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int V=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int[] moneys=new int[V];
		for(int i=0;i<V;i++){
			if(st.hasMoreTokens()){
				moneys[i]=Integer.parseInt(st.nextToken());
			}else{
				st = new StringTokenizer(f.readLine());
				moneys[i]=Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp=new long[V][N+1];
		//dp[0][0]=1;
		System.out.println(moneys[V-1]);
		
		for(int i=0;i<V;i++){
			dp[i][0]=1;
			for(int j=1;j<=N;j++){
				if(i==0&&j-moneys[i]>=0){
					dp[i][j]=dp[i][j-moneys[i]];
				}else if(j-moneys[i]>=0){
					dp[i][j]=dp[i-1][j]+dp[i][j-moneys[i]];
				}else if(i>0){
					dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		
		
		out.println(dp[V-1][N]);
		out.close();
	
	}
}
