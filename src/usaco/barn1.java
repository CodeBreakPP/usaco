package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: barn1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class barn1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int i1 = Integer.parseInt(st.nextToken());    // first integer
	    int i2 = Integer.parseInt(st.nextToken());
	    int i3=Integer.parseInt(st.nextToken());
	    
	    ArrayList<Integer> List=new ArrayList<Integer>();
	    ArrayList<Integer> gap=new ArrayList<Integer>();
	    
	    for(int i=0;i<i3;i++){
	    	List.add(Integer.parseInt(f.readLine()));
	    }
	    
        Collections.sort(List,new Comparator<Integer>(){  
            @Override  
            public int compare(Integer b1, Integer b2) {  
                return b1-b2;
            }       
        });
        
	    for(int i=1;i<i3;i++){
	    	if(i>0){
	    		gap.add(List.get(i)-List.get(i-1));
	    	}
	    }
	    
	    Integer output=0;
	    if(i1>=i3){
	    	output=i3;
	    	out.println(i3);
	    }else{
	    	
	    	Integer Total=List.get(i3-1)-List.get(0)+1;
	    	System.out.println(Total);
	        Collections.sort(gap,new Comparator<Integer>(){  
	            @Override  
	            public int compare(Integer b1, Integer b2) {  
	                return b2-b1;
	            }       
	        });
	    	
	        for(int i=0;i<i1-1;i++){
	        	System.out.println(gap.get(i));
	        	Total-=gap.get(i);
	        	
	        }
	    	out.println(Total+i1-1);
	    	output=Total+i1-1;
	    	
	    }
	    System.out.println(output);
	    out.close();
	    		
	}
}
