import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


/*
ID: xiny.d1
LANG: JAVA
TASK: maze1
*/
public class maze1 {
public static void main(String[] args) throws IOException {
	
		BufferedReader f=new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		
		String[] maze=new String[2*h+1];
		
		for(int i=0;i<2*h+1;i++){
			maze[i]=f.readLine();
		}
		
		int[] gate=new int[2];
		int ngate=0;
		int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		
		HashMap<Integer,HashSet<Integer>> edge=new HashMap<Integer,HashSet<Integer>>();
		
		for(int i=0;i<h;i++){
			//System.out.println(maze[i*2+1]);
			for(int j=0;j<w;j++){
				
				edge.put(i*w+j, new HashSet<Integer>());
				
				for(int k=0;k<4;k++){
					
					//System.out.println(i+" "+j+" "+(j*2+1+dir[k][1]));
					
					if(maze[i*2+1+dir[k][0]].charAt(j*2+1+dir[k][1])==' '){
					
						if(i+dir[k][0]==-1||i+dir[k][0]==h||j+dir[k][1]==-1||j+dir[k][1]==w){

							gate[ngate++]=(i)*w+j;							
						}else{
							HashSet<Integer> hs=edge.get(i*w+j);
							hs.add((i+dir[k][0])*w+j+dir[k][1]);
							edge.put(i*w+j,hs);
						}
					}
				}
			}
		}
		
/*		 Iterator iter = edge.entrySet().iterator();
		   
		   while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
		       Object key = entry.getKey();
		       HashSet val = (HashSet) entry.getValue();
		       
		       System.out.println(key+":");
		       for(Object v:val){
		    	   System.out.println(v);
		       }
		   }*/
		
		//System.out.println(gate[0]);
		//System.out.println(gate[1]);

		int output=0;
		int[][] dist=new int[2][h*w];
		
		for(int i=0;i<2;i++){
			
			Boolean[] visited=new Boolean[h*w];
			
			int longdist=1;
			
			Queue<Integer> bfs = new LinkedList<Integer>();  
			int start=gate[i];
			visited[start]=true;
			dist[i][start]=1;
			bfs.add(start);
			while(!bfs.isEmpty()){
				
				int cur=bfs.poll();
				HashSet<Integer> edges=edge.get(cur);
				
				for(Integer ed:edges){
					//System.out.println(visited[ed]);
					if((visited[ed]==null)){
						
						bfs.add(ed);
						visited[ed]=true;
						dist[i][ed]=dist[i][cur]+1;
					}
					
				}
			}
		}
		
		for(int i=0;i<h*w;i++){
			
			output=Math.max(output, Math.min(dist[0][i], dist[1][i]));
			
		}
		
		System.out.println(output);
		out.println(output);
		out.close();
		
		
		
}
}
