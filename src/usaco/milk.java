package usaco;

/*
ID: xiny.d1
LANG: JAVA
TASK: milk
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
//package usaco;

public class milk {
	public static void main(String[] args) throws IOException {
	
	BufferedReader f=new BufferedReader(new FileReader("milk.in"));
	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
	StringTokenizer st = new StringTokenizer(f.readLine());
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());
    ArrayList<Integer[]> output=new ArrayList();
    Integer number=0;
    
    for(int i=0;i<i2;i++){
    	
    	StringTokenizer st1 = new StringTokenizer(f.readLine());
        int i3 = Integer.parseInt(st1.nextToken());    // first integer
        int i4 = Integer.parseInt(st1.nextToken());
    	Integer[] item={i3,i4};
    	output.add(item);
    	
    }
    
    Collections.sort(output,new Comparator<Integer[]>(){  
        @Override  
        public int compare(Integer[] b1, Integer[] b2) {  
            return b1[0]-b2[0];
        }       
    });
    //System.out.println(output);  
    Integer left=i1;
    Integer cost=0;
    
    for(int j=0;j<output.size();j++){
    	System.out.println(output.get(j)[0]+" "+output.get(j)[1]);
    	if(left>output.get(j)[1]){
    		left-=output.get(j)[1];
    		cost+=output.get(j)[0]*output.get(j)[1];
    	}else{
    		cost+=output.get(j)[0]*left;
    		break;
    	}	
    }
    
    out.println(cost);
    
    out.close();
    
    
	}
}
