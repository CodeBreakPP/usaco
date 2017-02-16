/*
ID: xiny.d1
LANG: JAVA
TASK: butter
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class butter {
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("butter.in"));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		HashMap<Integer,HashSet<Integer>>edge=new HashMap<Integer,HashSet<Integer>>();
		//HashMap<String,Integer>distance=new HashMap<String,Integer>();
		
		int[][] distance=new int[P+1][P+1];
		
		int[] cows=new int[N];
		
		int i,j;
		for(i=0;i<N;++i){
			cows[i]=Integer.parseInt(f.readLine());
		}
		
		int to,from,dis;
		for(i=0;i<C;++i){
			st=new StringTokenizer(f.readLine());
			from=Integer.parseInt(st.nextToken());
			to=Integer.parseInt(st.nextToken());
			dis=Integer.parseInt(st.nextToken());
			
			if(edge.containsKey(from)){
				edge.get(from).add(to);
				
			}else{
				HashSet<Integer> hs=new HashSet<Integer>();
				hs.add(to);
				edge.put(from, hs);
			}
			
			
			if(edge.containsKey(to)){
				edge.get(to).add(from);
				
			}else{
				HashSet<Integer> hs=new HashSet<Integer>();
				hs.add(from);
				edge.put(to, hs);
			}
			distance[from][to]=dis;
			distance[to][from]=dis;
			//distance.put(from+" "+to, dis);
			//distance.put(to+" "+from, dis);
			
		}
		
		f.close();
		
		int[][]dists=new int[N][P+1];
		
		
		for(i=0;i<N;++i){
			int cowi=cows[i];
			//int[] idis=new int[P+1];
			//HashSet<Integer> visited=new HashSet<Integer>();
			Arrays.fill(dists[i], 10000000);
			dists[i][cowi]=0;
			//visited.add(cowi);
			
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(cowi);
			
			while(!q.isEmpty()){
				int cur=q.poll();
				HashSet<Integer>es=edge.get(cur);
				for(Integer e:es){
					
					
					int tmp=distance[cur][e];
					
					if(dists[i][e]>dists[i][cur]+tmp){
						dists[i][e]=dists[i][cur]+tmp;
						q.add(e);
						//visited.add(e);
					}
					
				}
			}
			//dists[i]=idis;
		}
		
		

		int output=10000000;

			for(i=1;i<=P;++i){
			int wholedistance=0;
				
			for(j=0;j<N;j++){
				wholedistance+=dists[j][i];
			}
			if(output>wholedistance){
				output=wholedistance;
			}
			
		}

		System.out.println(output);
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
		out.println(output);
		out.close();
	
	}

}
