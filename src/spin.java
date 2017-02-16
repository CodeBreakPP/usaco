/*
ID: xiny.d1
LANG: JAVA
TASK: spin
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class spin {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("spin.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
		StringTokenizer st = null;
		int[] speed=new int[5];
		ArrayList<int[]> al=new ArrayList<int[]>();
		
		
		for(int i=0;i<5;i++){
			
			st = new StringTokenizer(f.readLine());
			
			speed[i]=Integer.parseInt(st.nextToken());
			
			int n=Integer.parseInt(st.nextToken());
			
			int[] ns=new int[n*2];
			
			for(int j=0;j<n;j++){
				
				ns[2*j]=Integer.parseInt(st.nextToken());
				ns[2*j+1]=(ns[2*j]+Integer.parseInt(st.nextToken()))%360;
				
			}
			al.add(ns);

			
		}
		
/*		for(int i=0;i<5;i++){
			int[]as=al.get(i);
			int len=as.length/2;
			for(int j=0;j<len;j++){
				System.out.println(as[j*2]+" "+as[j*2+1]);
			}
		}*/
		
		int[] ni=new int[360];
		
		HashSet<String>hs=new HashSet<String>();
		Boolean loop=false;
		
		
		Arrays.fill(ni, 10, 20, 1);
		
		System.out.println(ni[10]);
		System.out.println(ni[20]);
		
		
		int time=0;
		while(true){
			
			int[] table=new int[360];
			
/*			System.out.println(time+":");
			for(int i=0;i<5;i++){
				int[]as=al.get(i);
				int len=as.length/2;
				for(int j=0;j<len;j++){
					System.out.println(as[j*2]+" "+as[j*2+1]);
				}
			}
			*/
			
			String state="";
			
			for(int i=0;i<5;i++){
				
				int[]as=al.get(i);
				
				int len=as.length/2;
				
				state+=i+":"+as[0]+" ";
				
				for(int j=0;j<len;j++){
					
					if(as[j*2]<as[j*2+1]){
						
						for(int k=as[j*2];k<=as[j*2+1];k++){
							
							table[k]+=1;
							
						}
						

					}else{
						//Arrays.fill(table, as[j*2+1], as[j*2]+1, 1);
						//Arrays.fill(table, as[j*2], 360, 1);
						//Arrays.fill(table, 0,as[j*2+1]+1,  1);
						for(int k=0;k<=as[j*2+1];k++){
							table[k]+=1;
							
						}
						
						for(int k=as[j*2];k<=359;k++){
							table[k]+=1;
							
						}
						
						
					}
					
					as[j*2]=(as[j*2]+speed[i])%360;
					as[j*2+1]=(as[j*2+1]+speed[i])%360;
				}
				
			}
			
			if(hs.contains(state)){
				loop=true;
				break;
			}
			
			hs.add(state);
			
			Boolean exit=false;
			for(int i=0;i<360;i++){
				if(table[i]==5){
					exit=true;
					break;
				}
			}
			if(exit)break;
			
			time++;
		}
		
		if(loop){
			out.println("none");
			
		}else{
		System.out.println(time);
		out.println(time);
		}
		out.close();


}
}
