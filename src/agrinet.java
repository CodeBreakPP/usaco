import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
ID: xiny.d1
LANG: JAVA
TASK: agrinet
*/
public class agrinet {
	public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("agrinet.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
		int N=Integer.parseInt(f.readLine());
		
		ArrayList<int[]> edges=new ArrayList<int[]>();
		int[][] distance=new int[N][N];
		
		for(int i=0;i<N;i++){
			
			StringTokenizer st = new StringTokenizer(f.readLine());
			
			for(int j=0;j<N;j++){
				
				if(st.hasMoreTokens()){
				
				int dist=Integer.parseInt(st.nextToken());
				
				distance[i][j]=dist;
				}else{
					st = new StringTokenizer(f.readLine());
					int dist=Integer.parseInt(st.nextToken());
					
					distance[i][j]=dist;
				}
				
			}
		}
		
		int output=0;
		
		HashSet<Integer> visited=new HashSet<Integer>();
		HashSet<Integer> unvisited=new HashSet<Integer>();
		
		visited.add(0);
		for(int i=1;i<N;i++){
			unvisited.add(i);
		}
		
		for(int i=1;i<N;i++){
			int mini=99999999;
			int nextu=-1;
			
			for(int v:visited){
				for(int u:unvisited){
					if(mini>distance[v][u]){
					mini=distance[v][u];
					nextu=u;
					}
				}
				
			}
			System.out.println(mini);
			output+=mini;
			visited.add(nextu);
			unvisited.remove(nextu);
			
		}

		System.out.println(output);
		out.println(output);
	
		out.close();
	
	}
}
