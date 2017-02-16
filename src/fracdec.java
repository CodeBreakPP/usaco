/*
ID: xiny.d1
LANG: JAVA
TASK: fracdec
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class fracdec {
	public static void main(String[] args) throws IOException {
		Date date = new Date();
		BufferedReader f=new BufferedReader(new FileReader("fracdec.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num=Integer.parseInt(st.nextToken());
		int den=Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> decis=new ArrayList<Integer>();
		String integral=""+(num/den);
		int remain=num%den*10;
		int posdeci=0;
		String output="";
		int lastpos=0;
		int nextpos=0;
		HashMap<String,Integer>pos=new HashMap<String,Integer>();
		
		while(true){
			
			int next=remain/den;
			remain=(remain%den)*10;
			if(remain==0){
				decis.add(next);
				//output=output.concat(next+"");
				break;
			}
			
			
			
			
			
			if(pos.containsKey(next+" "+remain)){
				
				lastpos=pos.get(next+" "+remain);
				nextpos=posdeci;
				
				break;
			
			}else{
				decis.add(next);
				//output=output.concat(next+"");
				pos.put(next+" "+remain, ++posdeci);
				
			}
		}
		Date date2 = new Date();
		System.out.println((date2.getTime()-date.getTime())/1000.0);
		
		
		int end=0;
		
		String integrals=integral+"";
		int len=integrals.length();
		
		while(end<=len){
			if(end+76<=len){out.println(integrals.substring(end, end+76));end+=76;}
			else {out.print(integrals.substring(end)+".");end=len+1;}
		}
		
		
		int lendeci=decis.size();
		
		int k=0;
		while(k<lendeci){
			
			if((end+k)%76==0){
				out.println();
			}
			
			if(k==lastpos-1&&lastpos<nextpos){
				out.print("(");
				end++;
			}
			
			out.print(decis.get(k));
			k++;
		}
		
		if(lastpos<nextpos){
			if((end+k)%76==0){
				out.println();
			}
			out.println(")");
		}else{
			out.println();
		}
		
		
		out.close();
		
		Date date3 = new Date();
		System.out.println((date3.getTime()-date2.getTime())/1000.0);
	
	}
}
