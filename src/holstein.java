/*
ID: xiny.d1
LANG: JAVA
TASK: holstein
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class holstein {
	public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		int N=Integer.parseInt(f.readLine());
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[] vitamins=new int[N];
		
		for(int i=0;i<N;i++){
			vitamins[i]=Integer.parseInt(st.nextToken());
		}
		
		int G=Integer.parseInt(f.readLine());
		int[][]scoops=new int[G][N];
		
		Queue<int[]> bfs=new LinkedList<int[]>();
		Queue<int[]> feedsort=new LinkedList<int[]>();
		int feednum=0;
		Boolean finish=false;
		int outputs=0;
		for(int i=0;i<G;i++){
			st = new StringTokenizer(f.readLine());
			Boolean judge=true;
			for(int j=0;j<N;j++){
				scoops[i][j]=Integer.parseInt(st.nextToken());
				if(scoops[i][j]<vitamins[j]){
					judge=false;
				}
			}
			if(judge&&!finish){
				finish=true;
				outputs=i;
			}else{
				bfs.offer(scoops[i]);
				feedsort.offer(new int[]{i});
			}	
		}
		if(finish){
			out.print(1);
			out.print(" "+(outputs+1));
			
		}else{
			
		int feedn=1;
		int[]output=new int[G];
		
		while(!bfs.isEmpty()){
			Boolean jumpout=false;
			int[]cur=(int[]) bfs.poll();
			int[]feeds=(int[]) feedsort.poll();
			
			int start=feeds[feeds.length-1];
			
			for(int i=start+1;i<G;i++){

				
				int[]nex=new int[N];
				Boolean judge=true;
				for(int j=0;j<N;j++){
					nex[j]=cur[j]+scoops[i][j];
					if(nex[j]<vitamins[j]){judge=false;}
				}
				
				
				int[] feedtype=new int[feeds.length+1];
				for(int k=0;k<feeds.length;k++)feedtype[k]=feeds[k];
				feedtype[feeds.length]=i;
				if(judge){
					output=feedtype;
					feedn=feeds.length+1;
					jumpout=true;
					break;
				}else{
					bfs.offer(nex);
					feedsort.offer(feedtype);
				}
			}
			if(jumpout)break;
		}
		
		System.out.println(feedn);
		for(int i=0;i<output.length;i++){
		System.out.print(output[i]+" ");
		}
		out.print(feedn);
		for(int i=0;i<output.length;i++){
		out.print(" "+(output[i]+1));
		}
		
		}
		out.println();
		out.close();
		
	}
}