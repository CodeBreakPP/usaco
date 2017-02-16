/*
ID: xiny.d1
LANG: JAVA
TASK: rockers
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rockers {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("rockers.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int N=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[]ns=new int[N];
		st=new StringTokenizer(f.readLine());
		
		for(int i=0;i<N;++i){
			ns[i]=Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort(ns);
		
		int n=0;
		//int remain=T;
		
		int[][] posible=new int[M][N];
		int[][] remains=new int[M][N];
		
		for(int i=0;i<M;i++){
			Arrays.fill(remains[i], T);
		}
		
		
		for(int i=0;i<M;i++){
			
			for(int j=i;j<N;j++){
				
				if(ns[j]>T){
					continue;
				}
				
				
				if(i==0){
					if(j==0){
						posible[i][j]=1;
						remains[i][j]=T-ns[j];
						//System.out.println(posible[i][j]+" "+remains[i][j]);
					}else{
						
						int p=1;
						int rs=T-ns[j];
						for(int k=0;k<j;k++){
							if(posible[i][k]>0&&remains[i][k]>=ns[j]){
								if(posible[i][k]+1>p){
									p=posible[i][k]+1;
									rs=remains[i][k]-ns[j];
								}else if(posible[i][k]+1==p){
									
									if(rs>remains[i][k]-ns[j]){
										rs=remains[i][k]-ns[j];
									}	
								}
							}
						}
						
						posible[i][j]=p;
						remains[i][j]=rs;
					}
					continue;
				}
				
				
				if(posible[i-1][j-1]>0){
					
					int rs=T-ns[j];
					int p=posible[i-1][j-1]+1;
					
					for(int k=0;k<j;k++){
						if(posible[i][k]>0&&remains[i][k]>=ns[j]){
							if(posible[i][k]+1>p){
								p=posible[i][k]+1;
								rs=remains[i][k]-ns[j];
							}else if(posible[i][k]+1==p){
								
								if(rs<remains[i][k]-ns[j]){
									rs=remains[i][k]-ns[j];
								}	
							}
						}
					}
					
					posible[i][j]=p;
					remains[i][j]=rs;
					
					
				}else{
					
					int rs=T-ns[j];
					int p=1;
					for(int k=0;k<j;k++){
						if(posible[i][k]>0&&remains[i][k]>=ns[j]){
							if(posible[i][k]+1>p){
								p=posible[i][k]+1;
								rs=remains[i][k]-ns[j];
							}else if(posible[i][k]+1==p){
								
								if(rs<remains[i][k]-ns[j]){
									rs=remains[i][k]-ns[j];
								}	
							}
						}
					}
					
					posible[i][j]=p;
					remains[i][j]=rs;
					
				}
				
			}
			
		}
		
		int output=0;
		
		
/*		for(int i=0;i<M;i++){
			
			for(int j=0;j<N;j++){
				System.out.print(" "+posible[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
		for(int i=0;i<M;i++){
			
			for(int j=0;j<N;j++){
				System.out.print(" "+remains[i][j]);
			}
			System.out.println();
			
		}*/
		
		
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(posible[i][j]>0){
					output=Math.max(output, posible[i][j]);
				}
			}
		}
		
		
		System.out.println(output);
		out.println(output);

		out.close();

}
}
