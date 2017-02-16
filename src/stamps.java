/*
ID: xiny.d1
LANG: JAVA
TASK: stamps
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class stamps {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("stamps.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int K=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int[] values=new int[N];
		
		st = new StringTokenizer(f.readLine());
		
		for(int i=0;i<N;i++){
			if(st.hasMoreTokens()){
				values[i]=Integer.parseInt(st.nextToken());
			}else{
				st = new StringTokenizer(f.readLine());
				values[i]=Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(values);
		
		
		
/*		ArrayList<int[]> al=new ArrayList<int[]>();
		
		int[] v0=new int[N];
		Arrays.fill(v0, K);
		al.add(v0);*/
		int i=0;
		int[] nextvs=new int[values[N-1]*K+1];
		Arrays.fill(nextvs, -1);
		nextvs[0]=K;
		int output=1;
		
		while(i<N){
			
			
			
			int maxv=values[i]*K;
			
			
			
			if(i==0){
			
				for(int v=1;v<=maxv;v++){
				
					if(v-values[i]>=0){
						
						nextvs[v]=Math.max(nextvs[v], nextvs[v-values[i]]-1);
						
					}
					
					if(i==N-1){
						if(nextvs[v]<0){
							break;
						}
						output=v;
					}
					
				}
			}else{
				
				for(int v=1;v<=maxv;v++){
					
					if(v-values[i]>=0){
					
						nextvs[v]=Math.max(nextvs[v], nextvs[v-values[i]]-1);
						
					}
					
					
					
					if(i==N-1){
						if(nextvs[v]<0){
							break;
						}
						output=v;
					}
				}
				
				
			}

			
			i++;
						
		}
		
/*		while(true){
			
			int[] nextv=new int[N];
			Arrays.fill(nextv, -1);
			
			Boolean allzero=true;
			
			if(v-values[0]>=0){
				nextv[0]=Math.max(-1, al.get(v-values[0])[0]-1);
			}else{
				nextv[0]=-1;
			}
			if(nextv[0]>=0){
				allzero=false;
			}
			
			for(int i=1;i<N;i++){
				if(v-values[i]>=0){
					nextv[i]=Math.max(nextv[i-1],al.get(v-values[i])[i]-1);
				}else{
					nextv[i]=nextv[i-1];
				}
				if(nextv[i]>=0){
					allzero=false;
				}
			}
			
			
			if(allzero){
				break;
			}
			
			al.add(nextv);
			
			v++;
			
		}*/
		
		System.out.println(output);
		out.println(output);
		out.close();
}
		
}

