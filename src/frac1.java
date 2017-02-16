/*
ID: xiny.d1
LANG: JAVA
TASK: frac1
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

public class frac1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		int N=Integer.parseInt(f.readLine());
		
		ArrayList<float[]> al=new ArrayList<float[]>();
		
		for(int i=1;i<=N;i++){
			
			for(int j=1;j<i;j++){
				
				if(gcd(j,i)==1){
					
					al.add(new float[]{j,i,(float)j/(float)i});
				}
				
			}
		}
		
		Collections.sort(al, new Comparator<float[]>(){  
            @Override  
            public int compare(float[] b1, float[] b2) {  
            	
            	if(b1[2]>b2[2]){
            		
            		return 1;
            	}else if(b1[2]<b2[2]){
            		return -1;
            	}else{
            		return 0;
            	}
            }       
        });
		

		
		out.println("0/1");
		
		for(int k=0;k<al.size();k++){
			
			float[] item=al.get(k);
			
			out.println((int)item[0]+"/"+(int)item[1]);
		}
		
		
		
		out.println("1/1");
		out.close();
		
	}
	
	public static int gcd(int x,int y){
		
		
		int i=Math.max(x, y);
		int j=Math.min(x, y);
		
		int r=i%j;
		
		while(r>0){
			i=j;
			j=r;
			r=i%j;
		}
		
		return j;
	}
	
	
}