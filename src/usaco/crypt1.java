package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: crypt1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crypt1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());    // first integer
	    st = new StringTokenizer(f.readLine());
	    Integer[] list=new Integer[n];
	    ArrayList<Integer> alist=new ArrayList<Integer>();
	    for(int i=0;i<n;i++){
	    	
	    	list[i]=Integer.parseInt(st.nextToken());
	    	alist.add(list[i]);
	    }
	    Integer output=0;
	    for(int i1=0;i1<n;i1++){
		    for(int i2=0;i2<n;i2++){
			    for(int i3=0;i3<n;i3++){
				    for(int i4=0;i4<n;i4++){
					    for(int i5=0;i5<n;i5++){
					    	
					    	Integer a=list[i1];
					    	Integer b=list[i2];
					    	Integer c=list[i3];
					    	Integer d=list[i4];
					    	Integer e=list[i5];
					    	
					    	Integer abc=a*100+b*10+c;
					    	Integer de=d*10+e;
					    	
					    	Integer p1=abc*e;
					    	Integer p2=abc*d;
					    	Integer p3=abc*de;
					    	
					    	if((p1<1000&&p1>=100)&&(p2<1000&&p2>=100)&&(p3<10000&&p3>=1000)){
					    		
					    		if(alist.contains(p1/100)&&alist.contains(p1%100/10)&&alist.contains(p1%10)){
						    		if(alist.contains(p2/100)&&alist.contains(p2%100/10)&&alist.contains(p2%10)){
							    		if(alist.contains(p3/1000)&&alist.contains(p3%1000/100)&&alist.contains(p3%100/10)&&alist.contains(p3%10)){

							    			output+=1;
							    			
							    		}

						    			
						    		}

					    		}
					    	}
					    }	
				    }
			    }
		    }
	    }
	    
	    
	    out.println(output);
	    out.close();
	    
	}

}
