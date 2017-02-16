package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: dualpal
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dualpal {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int i1 = Integer.parseInt(st.nextToken());    // first integer
	    int i2 = Integer.parseInt(st.nextToken())+1;
	    ArrayList<Integer> output=new ArrayList();
	    Integer number=0;
	    while(true){
	    	Integer times=0;
	    	
	    	for(int i=2;i<=10;i++){
	    		String pan=base(i2,i);
				Boolean ispan=true;
				for(int j=0;j<pan.length()/2;j++){
					if(pan.charAt(j)!=pan.charAt(pan.length()-j-1)){
						ispan=false;
						break;
					}	
				}
				if(ispan)times++;
				if(times>1)break;
	    	}
	    	
	    	if(times>1){number++;output.add(i2);}
	    	
	    	if(number==i1)break;
	    	
	    	i2++;
	    }
	    
	    for(int j=0;j<output.size();j++){
	    	out.println(output.get(j));
	    }

		out.close();
	}
	
	public static String base(int n,int b){
		
		String output="";
		
		while(true){
			Integer a=n%b;
			if(a<10){
				output=a+output;
				
			}else{
				if(a==10){
					output="A"+output;
				}
				if(a==11){
					output="B"+output;
				}
				if(a==12){
					output="C"+output;
				}
				if(a==13){
					output="D"+output;
				}
				if(a==14){
					output="E"+output;
				}
				if(a==15){
					output="F"+output;
				}
				if(a==16){
					output="G"+output;
				}
				if(a==17){
					output="H"+output;
				}
				if(a==18){
					output="I"+output;
				}
				if(a==19){
					output="J"+output;
				}
				
			}
			if(n<b)break;
			n=n/b;
		}
		
		return output;
		
	}
}
