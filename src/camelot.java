/*
ID: xiny.d1
LANG: JAVA
TASK: camelot
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class camelot {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("camelot.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int col=Integer.parseInt(st.nextToken());
		int row=Integer.parseInt(st.nextToken());
		
		HashMap<Integer,HashSet<Integer>>edge=new HashMap<Integer,HashSet<Integer>>();
		
		st=new StringTokenizer(f.readLine());
		int x=st.nextToken().charAt(0)-'A';
		int y=Integer.parseInt(st.nextToken())-1;
		
		int[][] dir=new int[][]{{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
		
		int[][] dir2=new int[][]{{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				edge.put(i*col+j, new HashSet<Integer>());
			}
		}
		
		int king=x*row+y;
		
/*		for(int i=0;i<8;i++){
			int xx=dir[i][0];
			int yy=dir[i][1];
			
			if(x+xx>=0&&x+xx<row&&y+yy>=0&&y+yy<col){
				
				edge.get(king).add((x+xx)*row+y+yy);
			}
		}*/
		
		
		String nextline=f.readLine();
		
		ArrayList<Integer> rounds=new ArrayList<Integer>();
		HashSet<String> edges=new HashSet<String>();
		
		while(nextline!=null){
			 st=new StringTokenizer(nextline);
			
			 while(st.hasMoreTokens()){
				 int s=st.nextToken().charAt(0)-'A';
				 int c=Integer.parseInt(st.nextToken())-1;
				 rounds.add(s*col+c);
			 }
			 nextline=f.readLine();
		}
		

		
		

		
		long[] kingd=new long[col*row];
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				
				int cur=i*col+j;
				kingd[cur]=Math.max(Math.abs(i-x), Math.abs(j-y));
				
				for(int k=0;k<8;k++){
					int xx=dir2[k][0];
					int yy=dir2[k][1];
					
					if(i+xx>=0&&i+xx<row&&j+yy>=0&&j+yy<col){
						edge.get(cur).add((i+xx)*col+j+yy);
					}
				}
			}
		}
		
		int nearr=Integer.MAX_VALUE;
		for(Integer ro:rounds){
			//System.out.println(ro);
			nearr=(int) Math.min(kingd[ro], nearr);
		}
		
		
		long[][] dists=new long[rounds.size()][col*row];
		Boolean[][] crossking=new Boolean[rounds.size()][col*row];
		
		int i=0;
		for(Integer ro:rounds){
			
			Arrays.fill(dists[i], 100000);
			Arrays.fill(crossking[i], false);
			dists[i][ro]=0;
			crossking[i][king]=true;
			//visited.add(cowi);
			
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(ro);
			
			while(!q.isEmpty()){
				int cur=q.poll();
				HashSet<Integer>es=edge.get(cur);
				for(Integer e:es){
					
					int tmp=1;
					
					if(dists[i][e]>dists[i][cur]+tmp){
						dists[i][e]=dists[i][cur]+tmp;
						q.add(e);
						
						if(e==king||crossking[i][cur]){
							crossking[i][e]=true;
						}else{
							crossking[i][e]=false;
						}
						
						//visited.add(e);
					}
					
				}
			}
			i++;
			
		}
		System.out.println(rounds.size());
		long mini=Long.MAX_VALUE;
		
		for(int k=0;k<row*col;k++){
			
			int sum=0;
			int nr=0;
			Boolean cross=false;
			for(Integer ro:rounds){
				
/*				if(dists[nr][k]>=100000){
					
					System.out.println(ro+" "+k+" "+dists[nr][k]);
					
				}*/
				if(crossking[nr][k]){
					cross=true;
				}
				sum+=dists[nr][k];
				nr++;
			}
			if(!cross){
				sum+=Math.min(nearr, kingd[k]);
			}
			
			mini=Math.min(mini, sum);

		}
		
		System.out.println(mini);
		out.println(mini);
/*		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				
				int cur=i*row+j;
				System.out.println(i+" "+j+":");
				HashSet<Integer>hs=edge.get(cur);
				for(Integer h:hs){
					System.out.println(h);
				}
				
				int diag=Math.max(Math.abs(i-x), Math.abs(j-y));
				dis[i*row+j]=diag;
				
				System.out.print(diag+" ");
			}
			//System.out.println();
		}*/
		
		out.close();

}

}
