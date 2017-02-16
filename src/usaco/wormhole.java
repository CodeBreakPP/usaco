package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: wormhole
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class wormhole {
	
	static public int[] right;
	static public int[] xi;
	static public int[] yi;
	static public int[] partner;
	static public Integer N;
	
	static public Boolean cycle_exist(){
		
		for(int i=1;i<=N;i++){
			Integer pos=i;
			for(int j=1;j<=N;j++){
				pos=right[partner[pos]];
			}
			if(pos!=0)return true;
		}
		
		return false;
	}
	
	static public Integer solve(){
		
		Integer first=0;
		for(int i=1;i<=N;i++){
			if(partner[i]==0){
				first=i;
				break;
			}
		}
		
		if(first==0){
			if(cycle_exist())return 1;
			else return 0;
		}
		
		int total=0;
		
		for(int j=first+1;j<=N;j++){
			if(partner[j]==0){
				partner[first]=j;
				partner[j]=first;
				total+=solve();
				System.out.println(total);
				partner[first]=0;
				partner[j]=0;
			}

		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    N = Integer.parseInt(st.nextToken()); 
	    // first integer
	    
		
	    right=new int[N+1];
	    xi=new int[N+1];
	    yi=new int[N+1];
	    partner=new int[N+1];
	    
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(f.readLine());
			xi[i]=Integer.parseInt(st.nextToken());
			yi[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(xi[i]>xi[j]&&yi[i]==yi[j]){
					if(right[j]==0||xi[i]<xi[right[j]]){
						right[j]=i;		
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++){
			
			System.out.print(i);
			System.out.println(right[i]);
		}
		
		Integer output=solve();
		System.out.print(output);
		out.println(output);
		out.close();
		
	}
	
	
	
	
}
