/*
ID: xiny.d1
LANG: JAVA
TASK: ditch
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ditch {
	public static void main(String[] args) throws IOException {

		BufferedReader f=new BufferedReader(new FileReader("ditch.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ditch.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		HashMap<Integer,HashSet<Integer>>edges=new HashMap<Integer,HashSet<Integer>>();
		
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int[][] capa=new int[n+1][n+1];
		for(int i=0;i<n;i++){
			Arrays.fill(capa[i+1], 0);
			edges.put(i+1, new HashSet<Integer>());
		}
		
		int[][] flow=new int[n+1][n+1];
		int[][] residu=new int[n+1][n+1];
		//System.out.println(residu[1][1]);
		
		for(int i=0;i<m;i++){
			st=new StringTokenizer(f.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cap=Integer.parseInt(st.nextToken());
			capa[from][to]=cap;
			residu[from][to]=cap;
			edges.get(from).add(to);
			edges.get(to).add(from);
		}
		
		int totalflow=0;
		
		while(true){
			
			int[]pre=new int[n+1];
			int[]curflow=new int[n+1];
			Boolean[] visited=new Boolean[n+1];
			Arrays.fill(visited, false);
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(1);
			visited[1]=true;
			curflow[1]=Integer.MAX_VALUE;
			
			while(q.isEmpty()==false){
				Boolean find=false;
				int cur=q.poll();
				
				HashSet<Integer>hs=edges.get(cur);
				
				for(int h=1;h<=n;h++){
					
					if(residu[cur][h]>0&&(!visited[h])){
						
						pre[h]=cur;
						curflow[h]=Math.min(curflow[cur], capa[cur][h]-flow[cur][h]);
						visited[h]=true;
						if(h==n){
							find=true;
							break;
						}
						
						q.add(h);
					}	
					
				}
				
				if(find){
					break;
				}
			}
			
			//System.out.println(curflow[n]);
			if(curflow[n]==0){
				break;
			}
			int addflow=curflow[n];
			int pos=n;
			while(pos!=1){
				int prev=pre[pos];
				flow[prev][pos]+=addflow;
				flow[pos][prev]-=addflow;
				residu[prev][pos]-=addflow;
				residu[pos][prev]+=addflow;
				pos=prev;
			}
			totalflow+=addflow;
			
		}
		int output=0;
		int tocap=0;
		int toin=0;
		for(int i=1;i<=n;i++){
			if(flow[i][n]>0){
				output+=flow[i][n];
			}
			if(capa[i][n]>0){
				tocap+=capa[i][n];
			}
			if(capa[1][i]>0){
				toin+=capa[1][i];
			}
			
		}

		
		out.close();
		
		
	
	}

}
