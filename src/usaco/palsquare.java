package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: palsquare
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		Integer B=Integer.parseInt(f.readLine());
		
		for(int i=1;i<=300;i++){
			
			Integer sqr=i*i;
			String pa=base(i,B);
			String pan=base(sqr,B);
			
			Boolean ispan=true;
			for(int j=0;j<pan.length()/2;j++){
				if(pan.charAt(j)!=pan.charAt(pan.length()-j-1)){
					ispan=false;
					break;
				}
				
			}
			if(ispan){
				
				out.print(pa);
				out.print(" ");
				out.println(pan);
			}
			
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
