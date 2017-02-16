/*
ID: xiny.d1
LANG: JAVA
TASK: game1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
public class game1 {
	public static void main(String[] args) throws IOException{

	BufferedReader f=new BufferedReader(new FileReader("game1.in"));
	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
	int N=Integer.parseInt(f.readLine());
	int[]ns=new int[N];
	
	StringTokenizer st = new StringTokenizer(f.readLine());
	HashMap<String,int[]>hm=new HashMap<String,int[]>();
	
	
	for(int i=0;i<N;i++){
		
		if(st.hasMoreTokens()){
			ns[i]=Integer.parseInt(st.nextToken());
		}else{
			st = new StringTokenizer(f.readLine());
			ns[i]=Integer.parseInt(st.nextToken());
			
		}
	}
	
	int cur;
	
	if(N%2==0){
		cur=1;
	}else{
		cur=0;
	}
	String wholes="";
	
	for(int i=0;i<N;i++){
		
		int[] n2=new int[2];
		n2[cur]=ns[i];
		hm.put(ns[i]+"",n2);
		
		if(i==0){
			wholes+=ns[i];
		}else{
			wholes=wholes+" "+ns[i];
		}
	}
	
	for(int i=0;i<N;i++){
		cur=1-cur;
		
		//System.out.println(i+":");
		/*
		for(String h:hm.keySet()){
			
			System.out.println(h);
		}*/
		
		
		for(int j=0;j+i<N;j++){
			
			String curs="";
			curs=""+ns[j];
			for(int k=j+1;k<=j+i;k++){
				curs=curs+" "+ns[k];
			}
			
			
			//System.out.println(curs);
			
			int[] vs=hm.get(curs);
			if(j-1>=0){
				
				String curpre=ns[j-1]+" "+curs;
				
				int[] newv=new int[2];
				newv[0]=vs[0];
				newv[1]=vs[1];
				newv[cur]+=ns[j-1];
				
				if(hm.containsKey(curpre)){
					
					int[] compe=hm.get(curpre);
					if(compe[cur]<newv[cur]){
						hm.put(curpre,newv);
					}
					
				}else{
					
					hm.put(curpre,newv);
					
				}
				
				
				
			}
			
			if(j+i<N-1){
				
				String curpos=curs+" "+ns[j+i+1];
				
				
				int[] newv=new int[2];
				newv[0]=vs[0];
				newv[1]=vs[1];
				newv[cur]+=ns[j+i+1];
				
				if(hm.containsKey(curpos)){
					
					int[] compe=hm.get(curpos);
					if(compe[cur]<newv[cur]){
						hm.put(curpos,newv);
					}
					
				}else{
					
					hm.put(curpos,newv);
					
				}
				
				
			}
			
			
		}
		
	}
	int[] output=hm.get(wholes);
	System.out.println(output[0]+" "+output[1]);
	out.println(output[0]+" "+output[1]);
	out.close();
	
	}
	
}
