/*
ID: xiny.d1
LANG: JAVA
TASK: zerosum
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class zerosum {
	
	static ArrayList<String>outputs;
	
public static void main(String[] args) throws IOException {
	
		outputs=new ArrayList<String>();
		
		BufferedReader f=new BufferedReader(new FileReader("zerosum.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		
		
		recur("1",0,1,1,2,N);
		Collections.sort(outputs);
		
		for(String ouput:outputs){
			System.out.println(ouput);
			out.println(ouput);
		}
		out.close();
}

public static void recur(String output,int op,int result,int last,int next,int fina){
	if(next==fina){
		if(result-next==0){
			outputs.add(output+"-"+next);
		}
		if(result+next==0){
			outputs.add(output+"+"+next);
		}
		int result2=0;
		
		if(op==1){
			result2=result-last+(last*10+next);
			
		}else if(op==2){
			result2=result+last-(last*10+next);
			
		}else if(op==0){
			
			result2=last*10+next;
		}
		if(result2==0){
		outputs.add(output+" "+next);
		}
		
	}else{
		
		
		recur(output+"+"+next,1,result+next,next,next+1,fina);
		recur(output+"-"+next,2,result-next,next,next+1,fina);
		
		int result2=0;
		if(op==1){
			result2=result-last+(last*10+next);
			
		}else if(op==2){
			result2=result+last-(last*10+next);
			
		}else if(op==0){
			
			result2=last*10+next;
		}
		
		recur(output+" "+next,op,result2,last*10+next,next+1,fina);
	}
	
	
}



}
