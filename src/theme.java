/*
ID: xiny.d1
LANG: JAVA
TASK: theme
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class theme {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("theme.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("theme.out")));
		
		int N=Integer.parseInt(f.readLine());
		int[]ns=new int[N];
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		for(int i=0;i<N;i++){
			if(st.hasMoreTokens()){
				ns[i]=Integer.parseInt(st.nextToken());
			}else{
				st=new StringTokenizer(f.readLine());
				ns[i]=Integer.parseInt(st.nextToken());	
			}
		}
		f.close();
		int[]dif=new int[N-1];
		for(int i=0;i<N-1;i++){
			dif[i]=ns[i+1]-ns[i];
			System.out.println(dif[i]);
		}
		
		int output=1;
		for(int i=1;i<N-1;i++){
			int longest=1;
			int cur=1;
			for(int j=0;j+i<N-1;j++){
				
				if(dif[j]==dif[j+i]){
					cur+=1;
					
				}else{
					cur=1;
				}
				longest=Math.max(cur, longest);
				
				if(cur>=i){
					break;
				}
			}
			output=Math.max(output, longest);
		}
		
		
		if(output<5){
			out.println(0);
		}else{
			System.out.println(":"+output);
			out.println(output);
		}
		out.close();
		
		
}
}
