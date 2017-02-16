package usaco;

/*
ID: xiny.d1
LANG: JAVA
TASK: transform
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class transform {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("transform.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		ArrayList List = new ArrayList(); 
		ArrayList target=new ArrayList();
		for(int i=0;i<N;i++){
			String rows=(f.readLine());
			List.add(rows);
		}
		for(int i=0;i<N;i++){
			String rows=(f.readLine());
			target.add(rows);
		}
		Integer output=0;
		if(compare90(List,target)){
			output=1;
		}else if(compare180(List,target)){
			output=2;
		}else if(compare270(List,target)){
			output=3;
		}else if(reflection(List,target)){
			output=4;
		}else if(combind(List,target)){
			output=5;
		}else if(equal(List,target)){
			output=6;
		}else{
			output=7;
		}
		System.out.println(output);
		out.println(output);
		out.close();
		
	}
	
	public static Boolean compare90(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		for(int i=0;i<N;i++){
			String ai=(String) a.get(i);
			for(int j=0;j<N;j++){
				String bj=(String) b.get(j);
				
				if(ai.charAt(j)!=bj.charAt(N-1-i)){
					
					output=false;
					break;
				}
			}
			if(output==false)break;
		}
		return output;
	}
	
	public static Boolean compare180(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		for(int i=0;i<N;i++){
			String ai=(String) a.get(i);
			String bj=(String) b.get(N-1-i);
			for(int j=0;j<N;j++){				
				if(ai.charAt(j)!=bj.charAt(N-1-j)){
					output=false;
					break;
				}
			}
			if(output==false)break;
		}
		return output;
	}
	
	public static Boolean compare270(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		for(int i=0;i<N;i++){
			String ai=(String) b.get(i);
			for(int j=0;j<N;j++){
				String bj=(String) a.get(j);
				
				if(ai.charAt(j)!=bj.charAt(N-1-i)){
					
					output=false;
					break;
				}
			}
			if(output==false)break;
		}
		return output;
	}
	
	public static Boolean equal(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		for(int i=0;i<N;i++){
			String ai=(String) a.get(i);
			String bj=(String) b.get(i);
			
			if(ai!=bj){
				output=false;
				break;
			}
		}
		return output;
	}

	public static Boolean reflection(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		for(int i=0;i<N;i++){
			String ai=(String) a.get(i);
			String bj=(String) b.get(i);
			for(int j=0;j<N;j++){
				if(ai.charAt(j)!=bj.charAt(N-1-j)){
					output=false;
					break;
				}
			}
			if(output==false)break;
		}
		return output;
	}
	
	
	public static Boolean combind(ArrayList a, ArrayList b){
		Integer N=a.size();
		Boolean output=true;
		ArrayList c=new ArrayList();
		for(int i=0;i<N;i++){
			String ai=(String) a.get(i);
			String ci="";
			
			for(int j=0;j<N;j++){
				ci=ci+ai.charAt(N-j-1);
			}
			c.add(ci);
		}
		
		if(compare90(c,b)){
			return true;
		}else if(compare180(c,b)){
			return true;
		}else if(compare270(c,b)){
			return true;
		}
		return false;
	}
}
