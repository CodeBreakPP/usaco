/*
ID: xiny.d1
LANG: JAVA
TASK: humble
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class humble {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("humble.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int K=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		//System.out.println(K);
		Long[] uglys=new Long[N+1];
		Long[] hums=new Long[K];
		Long[] nextugly=new Long[K];
		int[] indexs=new int[K];

		st = new StringTokenizer(f.readLine());
		for(int i=0;i<K;i++){
			hums[i]=Long.parseLong(st.nextToken());
			indexs[i]=0;
		}
		uglys[0]=(long) 1;
		
		for(int k=0;k<K;k++){
			nextugly[k]=uglys[indexs[k]]*hums[k];
			//System.out.println(nextugly[k]);
		}
		
		
		for(int j=1;j<=N;j++){
			
			long tmp=nextugly[0];
			
			for(int k=0;k<K;k++){
				if(nextugly[k]<tmp){
					tmp=nextugly[k];
				}
			}
			uglys[j]=tmp;
			for(int k=0;k<K;k++){
				if(nextugly[k]==tmp){
					indexs[k]+=1;
					nextugly[k]=uglys[indexs[k]]*hums[k];
				}
			}
			

		}
		
		
		System.out.println(uglys[N]);
		out.println(uglys[N]);
		out.close();
		
		
		
		
}
}
