package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: combo
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class combo {
	public static void main(String[] args) throws IOException {

	// TODO Auto-generated method stub
	BufferedReader f=new BufferedReader(new FileReader("combo.in"));
	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
	StringTokenizer st = new StringTokenizer(f.readLine());
    int N = Integer.parseInt(st.nextToken()); 
    // first integer
	st = new StringTokenizer(f.readLine());

    Integer f1=Integer.parseInt(st.nextToken());
    Integer f2=Integer.parseInt(st.nextToken());
    Integer f3=Integer.parseInt(st.nextToken());
    
	st = new StringTokenizer(f.readLine());

    Integer m1=Integer.parseInt(st.nextToken());
    Integer m2=Integer.parseInt(st.nextToken());
    Integer m3=Integer.parseInt(st.nextToken());
    
    Integer total=N*N*N*2;
    if(N>=5){
    	total=250;
    }
    
    
    if(N<=3){
    	total=N*N*N;
    }else{
    	Integer dif1=0;
    	
    	if(Math.abs(f1-m1)<=4){
    		
    		dif1=5-Math.abs(m1-f1);
    		
    	}else if(Math.abs(f1+N-m1)<=4){
    		
    		dif1=5-Math.abs(f1+N-m1);
    		
    	}else if(Math.abs(f1-N-m1)<=4){
    		
    		dif1=5-Math.abs(f1-N-m1);
    	}
    	
    	Integer dif2=0;
    	
    	if(Math.abs(f2-m2)<=4){
    		
    		dif2=5-Math.abs(m2-f2);
    		
    	}else if(Math.abs(f2+N-m2)<=4){
    		
    		dif2=5-Math.abs(f2+N-m2);
    		
    	}else if(Math.abs(f2-N-m2)<=4){
    		
    		dif2=5-Math.abs(f2-N-m2);
    	}
    	
    	Integer dif3=0;
    	
    	if(Math.abs(f3-m3)<=4){
    		
    		dif3=5-Math.abs(m3-f3);
    		
    	}else if(Math.abs(f3+N-m3)<=4){
    		
    		dif3=5-Math.abs(f3+N-m3);
    		
    	}else if(Math.abs(f3-N-m3)<=4){
    		
    		dif3=5-Math.abs(f3-N-m3);
    	}
    	
    	total=total-dif1*dif2*dif3;
    	
    	
    	
    }
    out.println(total);
    out.close();
    
	}
}
