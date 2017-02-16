/*
ID: xiny.d1
LANG: JAVA
TASK: milk6
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class milk6 {
	public static void main(String[] args) throws IOException {
		
	BufferedReader f=new BufferedReader(new FileReader("milk6.in"));
	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk6.out")));
	StringTokenizer st=new StringTokenizer(f.readLine());
	
	HashMap<Integer,HashSet<Integer>>edges=new HashMap<Integer,HashSet<Integer>>();
	
	int n=Integer.parseInt(st.nextToken());
	int m=Integer.parseInt(st.nextToken());
	int[][] capa=new int[n+1][n+1];
	for(int i=0;i<n;i++){
		Arrays.fill(capa[i+1], 0);
		edges.put(i+1, new HashSet<Integer>());
	}
	
	int[][] flow=new int[n+1][n+1];
	int[][] residu=new int[n+1][n+1];
	
	HashMap<String,ArrayList<Integer>>edgenum=new HashMap<String,ArrayList<Integer>>();
	
	for(int i=0;i<m;i++){
		st=new StringTokenizer(f.readLine());
		int from=Integer.parseInt(st.nextToken());
		int to=Integer.parseInt(st.nextToken());
		int cap=Integer.parseInt(st.nextToken());
		
		if(capa[from][to]==0){
		
			capa[from][to]=cap;
			residu[from][to]=cap;
			edges.get(from).add(to);
			edges.get(to).add(from);
			ArrayList<Integer> al=new ArrayList<Integer>();
			al.add(i+1);
			edgenum.put(from+" "+to, al);
		}else{
			capa[from][to]+=cap;
			residu[from][to]+=cap;
			edgenum.get(from+" "+to).add(i+1);
		}
		
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
			
			for(Integer h:hs){
				
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
	
	System.out.print(totalflow);
	out.print(totalflow);
	//out.close();
	
	if(totalflow==0){
		out.println(" 0");
		
	}else{
	
	
	ArrayList<Integer>outal=new ArrayList<Integer>();
	
	HashSet<Integer> part1=new HashSet<Integer>();
	HashSet<Integer> part2=new HashSet<Integer>();

	part1.add(1);
	
	for(int i=2;i<=n;i++){
		part2.add(i);
	}
	
	while(true){
		Boolean[] visited=new Boolean[n+1];
		Arrays.fill(visited, false);
		
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(Integer p1:part1){
			q.add(p1);
			visited[p1]=false;
		}
		
		while(!q.isEmpty()){
			int cur=q.poll();
			HashSet<Integer>hs=edges.get(cur);
			
			for(Integer h:hs){
				if(residu[cur][h]>0&&visited[h]==false){
					q.add(h);
					part1.add(h);
					part2.remove(h);
					visited[h]=true;
				}
			}
		}
		
		ArrayList<Integer>tmpal=new ArrayList<Integer>();
		HashSet<Integer>nexadd=new HashSet<Integer>();
		
		for(Integer p1:part1){
			for(Integer p2:part2){
				if(capa[p1][p2]>0){
					ArrayList<Integer> al=edgenum.get(p1+" "+p2);
					tmpal.addAll(al);
					nexadd.add(p2);
				}
			}
		}
		
		//System.out.println("length:"+nexadd.size());
		
		if(nexadd.isEmpty()){
			break;
		}
		
		Collections.sort(tmpal);
		
		if(outal.isEmpty()==false){
			if(outal.size()>tmpal.size()){
				outal=tmpal;
			}else if(outal.size()==tmpal.size()){
				if(outal.get(0)>tmpal.get(0)){
					outal=tmpal;
				}
			}
		}else{
			outal=tmpal;
		}
		

		
		for(Integer add:nexadd){
			part1.add(add);
			part2.remove(add);
		}
		
		if(part1.size()==n){
			break;
		}
	}
	

	System.out.println(" "+outal.size());
	out.println(" "+outal.size());
	Collections.sort(outal);
	
	for(int i=0;i<outal.size();i++){
		System.out.println(outal.get(i));
		out.println(outal.get(i));
	}
	System.out.println();
	//out.println();
	}
	out.close();
	
}
}
