/*
ID: xiny.d1
LANG: JAVA
TASK: numtri
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class numtri {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		ArrayList<int[]>triangle=new ArrayList<int[]>();
		int[][] dp=new int[N][N];
		
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			
			int[] layer=new int[i+1];
			int index=0;
			while(st.hasMoreTokens()){
				layer[index]=Integer.parseInt(st.nextToken());
				index++;
			}
			triangle.add(layer);
		}
		
		for(int i=0;i<N;i++){
			if(i==0){
				dp[0][0]=triangle.get(0)[0];
			}else{
				
				int[] thislayer=triangle.get(i);
				for(int j=0;j<=i;j++){
					
					if(j==0){
						dp[i][j]=dp[i-1][j]+thislayer[j];
						
					}else if(j==i){
						
						dp[i][j]=dp[i-1][j-1]+thislayer[j];
					}else{
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+thislayer[j];
					}
				}	
			}
		}
		
		 int max=dp[N-1][0];
		 for(int k=0;k<N;k++){
			 if(dp[N-1][k]>max)max=dp[N-1][k];
		 }
		
		out.println(max);
		out.close();
	}
}