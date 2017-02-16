
/*
ID: xiny.d1
LANG: JAVA
TASK: ttwo
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class ttwo {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		
		String nextline="";
		int[] initC=new int[2];
		int[] initF=new int[2];
		int dirC=0;
		int dirF=0;
		int[][] dir={{0,-1},{1,0},{0,1},{-1,0},};
		
		HashSet<String> obstacles=new HashSet<String>();
		int j=0;
		while((nextline=f.readLine()) != null){
			
			for(int i=0;i<nextline.length();i++){
				
				if(nextline.charAt(i)=='*'){
					obstacles.add(i+" "+j);
				}else if(nextline.charAt(i)=='F'){
					initF[0]=i;
					initF[1]=j;
				}else if(nextline.charAt(i)=='C'){
					initC[0]=i;
					initC[1]=j;
				}
			}
			j+=1;
		}
		
		int time=0;
		
		HashSet<String>hs=new HashSet<String>();
		
		while(true){
			
			time+=1;
			
			if (initC[0]+dir[dirC][0]>=0&&initC[0]+dir[dirC][0]<10&&initC[1]+dir[dirC][1]>=0&&initC[1]+dir[dirC][1]<10){
				
				if(!obstacles.contains((initC[0]+dir[dirC][0])+" "+(initC[1]+dir[dirC][1]))){
					
					initC[0]+=dir[dirC][0];
					initC[1]+=dir[dirC][1];
					
				}else{
					dirC=(dirC+1)%4;
				}
				
				
			}else{
				dirC=(dirC+1)%4;
			}
			
			if (initF[0]+dir[dirF][0]>=0&&initF[0]+dir[dirF][0]<10&&initF[1]+dir[dirF][1]>=0&&initF[1]+dir[dirF][1]<10){
				
				if(!obstacles.contains((initF[0]+dir[dirF][0])+" "+(initF[1]+dir[dirF][1]))){
					
					initF[0]+=dir[dirF][0];
					initF[1]+=dir[dirF][1];
					
				}else{
					dirF=(dirF+1)%4;
				}
				
				
			}else{
				dirF=(dirF+1)%4;
			}
			
			
			
			if(initF[0]==initC[0]&&initF[1]==initC[1]){break;}
			
			if(hs.contains(dirC+" "+initC[0]+" "+initC[1]+" "+dirF+" "+initF[0]+" "+initF[1])){
				time=0;
				break;
				
			}else{
			
				hs.add(dirC+" "+initC[0]+" "+initC[1]+" "+dirF+" "+initF[0]+" "+initF[1]);
			}
			//System.out.println(time+" "+initC[0]+" "+initC[1]+" "+initF[0]+" "+initF[1]);
			
		}
		
		System.out.println(time);
		out.println(time);
		out.close();
		
		
		
		
		
	}
}
