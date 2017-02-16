package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: skidesign
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class skidesign {
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int N = Integer.parseInt(st.nextToken()); 
	    Integer[] elevs=new Integer[N];
	    Integer maxEles=1;
	    Integer minEles=100;
	    
	    for(int i=0;i<N;i++){
	    	st = new StringTokenizer(f.readLine());
	    	elevs[i]=Integer.parseInt(st.nextToken());
	    	if(elevs[i]>maxEles){
	    		maxEles=elevs[i];
	    		
	    	}
	    	if(elevs[i]<minEles){
	    		
	    		minEles=elevs[i];
	    	}
	    	
	    }
	    
	    Integer output=-1;
	    
	    for(int j=minEles;j<=maxEles;j++){
	    	Integer cost=0;
	    	
	    	for(int k=0;k<N;k++){
	    		if(elevs[k]<j-17){
	    			
	    			cost+=(j-elevs[k]-17)*(j-elevs[k]-17);
	    		}else if(elevs[k]>j){
	    			
	    			cost+=(elevs[k]-j)*(elevs[k]-j);
	    		}
	    		
	    	}
	    	if(output==-1||output>cost){
	    		output=cost;
	    	}
	    	
	    }
	    out.println(output);
	    out.close();
	    
	    
	}
}
