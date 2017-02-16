/*
ID: xiny.d1
LANG: JAVA
TASK: runround
*/
import java.util.Collection;
import java.util.HashSet;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class runround {
public static void main(String[] args) throws IOException {
	
		
		
		BufferedReader f=new BufferedReader(new FileReader("runround.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		Integer N=Integer.parseInt(f.readLine());
		
		while(true){
			N++;
			if(isrunround(Integer.toString(N)))break;
		}
		
		
		System.out.println(N);
		out.println(N);
		out.close();
}

public static Boolean isrunround(String num){
	Collection cc = new HashSet();  
	for(int i=0;i<num.length();i++){
		char c=num.charAt(i);
		if(cc.contains(c)||c=='0')return false;
		cc.add(c);
	}
	
	
	
	Boolean decide=false;
	int len=num.length();
	int index=0;
	int i=1;
	
	while(i<=len){
		index=(index+(int)(num.charAt(index)-48))%len;		
		//System.out.println(index);
		char nextc=num.charAt(index);
		
		if(nextc==num.charAt(0)&&i==len){
			decide=true;
			break;
		}else if(nextc==num.charAt(0)){
			break;
		}
		i+=1;
	}
	
	return decide;
}



}
