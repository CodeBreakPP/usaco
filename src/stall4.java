/*
ID: xiny.d1
LANG: JAVA
TASK: stall4
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

public class stall4 {
	public static void main(String[] args) throws IOException {

		BufferedReader f=new BufferedReader(new FileReader("stall4.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("stall4.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		HashMap<Integer,HashSet<Integer>>edges=new HashMap<Integer,HashSet<Integer>>();
		int[][] capa=new int[n+m+2][n+m+2];
		int[][] flow=new int[n+m+2][n+m+2];
		int[][] residu=new int[n+m+2][n+m+2];
		
		for(int i=0;i<=n+m+1;i++){
			Arrays.fill(capa[i], 0);
			edges.put(i, new HashSet<Integer>());
		}
				
		
		for(int i=0;i<n;i++){
			st=new StringTokenizer(f.readLine());
			
			int num=Integer.parseInt(st.nextToken());
			
			int from=i;
			
			for(int j=0;j<num;j++){
				int to=Integer.parseInt(st.nextToken())+n;;
				edges.get(from).add(to);
				edges.get(to).add(from);
				capa[from][to]=1;
				residu[from][to]=1;
			}
		}
	
		for(int i=1;i<=n;i++){
			edges.get(0).add(i);
			edges.get(i).add(0);
			capa[0][i]=1;
			residu[0][i]=1;
		}
		
		
		for(int i=n+1;i<=n+m;i++){
			edges.get(n+m+1).add(i);
			edges.get(i).add(n+m+1);
			capa[i][n+m+1]=1;
			residu[i][n+m+1]=1;
		}
		
		int totalflow=0;
		
		while(true){
			
			int[]pre=new int[n+m+2];
			int[]curflow=new int[n+m+2];
			Boolean[] visited=new Boolean[n+m+2];
			Arrays.fill(visited, false);
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(0);
			visited[0]=true;
			curflow[0]=Integer.MAX_VALUE;
			
			while(q.isEmpty()==false){
				Boolean find=false;
				int cur=q.poll();
				
				HashSet<Integer>hs=edges.get(cur);
				
				for(Integer h:hs){
					
					if(residu[cur][h]>0&&(!visited[h])){
						
						pre[h]=cur;
						curflow[h]=Math.min(curflow[cur], capa[cur][h]-flow[cur][h]);
						visited[h]=true;
						if(h==n+m+1){
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
			if(curflow[n+m+1]==0){
				break;
			}
			int addflow=curflow[n+m+1];
			int pos=n+m+1;
			while(pos!=0){
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
		for(int i=1;i<=n+m;i++){
			if(flow[i][n+m+1]>0){
				output+=flow[i][n+m+1];
			}
/*			if(capa[i][n]>0){
				tocap+=capa[i][n];
			}
			if(capa[1][i]>0){
				toin+=capa[1][i];
			}*/
			
		}
		//System.out.println(toin);
		//System.out.println(tocap);
		//System.out.println(output);
		
		System.out.println(totalflow);
		out.println(totalflow);
		out.close();
		
		
		
	}

}
