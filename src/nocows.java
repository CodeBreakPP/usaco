/*
ID: xiny.d1
LANG: JAVA
TASK: nocows
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class nocows {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("nocows.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> vs=new ArrayList<Integer>();
		
		for(int i=K+K-1;i<=N;i+=2){
			vs.add(i);
			//System.out.println(i);
		}
		Collections.sort(vs);
		
		int V=vs.size();
		
		BigInteger two=new BigInteger("2");
		BigInteger zero=new BigInteger("0");
		BigInteger one=new BigInteger("1");
		
		BigInteger[][] dp=new BigInteger[V][N+1];
		
		BigInteger[][] dp2=new BigInteger[N+1][K+1];
		
		//System.out.println(dp2[5][3]);
		for(int i=0;i<=K;i++){
			for(int j=0;j<=N;j++){
				dp2[j][i]=zero;
			}
		}
		
		for(int i=0;i<V;i++){
			for(int j=0;j<=N;j++){
				dp[i][j]=zero;
			}
		}
		
		
		
		for(int i=1;i<=K;i++){
			for(int j=1;j<=N;j+=2){
				
				if(j==1&&i==1){
					dp2[j][i]=one;
					continue;
				}	
				int remain=j-1;
				
				for(int k=1;k<=(remain);k+=2){
					int oneside=k;
					int otherside=remain-k;
					BigInteger add=zero;

					for(int l=1;l<i-1;l++){
						add=add.add(dp2[oneside][i-1].multiply(dp2[otherside][l]).multiply(two));
						//add=add.add(dp2[oneside][l].multiply(dp2[otherside][i-1]));
						
					}
					
					add=add.add(dp2[oneside][i-1].multiply(dp2[otherside][i-1]));
					
					dp2[j][i]=dp2[j][i].add(add);
				}
			}
		}
		

/*		BigInteger[] different=new BigInteger[N+1];
		for(int i=1;i<=N;i+=2){
			different[i]=dp2[i][K];
			//System.out.println(i);
			//System.out.println(different[i]);
		}*/
		
		
		if(N%2==1){
		out.println(dp2[N][K].mod(new BigInteger("9901")));
		}else{
			out.println(0);
		}
		
/*		for(int i=0;i<V;i++){
			dp[i][0]=new BigInteger("1");
			for(int j=1;j<=N;j++){
				if(i==0&&j-vs.get(i)>=0){
					dp[i][j]=dp[i][j-vs.get(i)].multiply(different[vs.get(i)]);
				}else if(j-vs.get(i)>=0){
					dp[i][j]=(dp[i-1][j].add(dp[i][j-vs.get(i)].multiply(different[vs.get(i)])));
				}else if(i>0){
					dp[i][j]=dp[i-1][j];
				}
			}
		}*/
		
/*		if(V>0){
			System.out.println(dp[V-1][N]);
			out.println(dp[V-1][N].mod(new BigInteger("9901")));
		}else{
			out.println(0);
		}*/
		out.close();
		
	}
	
	
	
	
}
