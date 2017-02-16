/*
ID: xiny.d1
LANG: JAVA
TASK: subset
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class subset {
public static void main(String[] args) throws IOException {
	
		
		
		BufferedReader f=new BufferedReader(new FileReader("subset.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		
		
		int sum=0;
		for(int i=1;i<=N;i++){sum+=i;}
		if(sum%2==0){
		
		int half=sum/2;
		//for(int i=1;i<=half;i++){System.out.print(i+" ");}
		//System.out.println();
		int[] sums=new int[half+1];
		sums[1]=1;
		
		for(int i=2;i<=N;i++){
			int[] sum2=new int[half+1];
			for(int j=1;j<=half;j++){
				if(j+i<=half){
					sum2[j+i]=sums[j];
				}
			}
			//sum2[i]=1;
			
			for(int j=1;j<=half;j++){
				sums[j]=sums[j]+sum2[j];
				//System.out.print(sums[j]+" ");
			}
			//System.out.println();
		}
		
		
		out.println(sums[half]);
		out.close();}else{
			out.println(0);
			out.close();
		}
}



}
