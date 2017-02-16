/*
ID: xiny.d1
LANG: JAVA
TASK: msquare
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class msquare {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("msquare.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
		String end=f.readLine();
		end=end.replace(" ", "");
		//System.out.println(end);
		String start="12345678";
		
		//String pp=start.charAt(3)+start.substring(0,3)+start.substring(5,8)+start.charAt(4);
		//System.out.println(pp);
		
		//String pq=""+start.charAt(0)+start.charAt(6)+start.charAt(1)+start.charAt(3)+start.charAt(4)+start.charAt(2)+start.charAt(5)+start.charAt(7);
		//System.out.println(pq);
		
		HashSet<String> states=new HashSet<String>();
		HashMap<String,String> path=new HashMap<String,String>();
		Queue<String> q=new LinkedList<String>();
		q.add(start);
		path.put(start, "");
		String output="";
		//String test="a";
		//System.out.println(test);
		
		if(start.equals(end)){
			output="";
			
		}else{
		
		
		while(true){
			
			String cur=q.poll();
			String pat=path.get(cur);
			//A
			String pa=new StringBuffer(cur).reverse().toString();
			if(pa.equals(end)){
				output=pat.concat("A");
				break;
			}else{
				if(!states.contains(pa)){
					q.add(pa);
					states.add(pa);
					path.put(pa, pat.concat("A"));
				}
			}
			
			//B
			String pb=cur.charAt(3)+cur.substring(0,3)+cur.substring(5,8)+cur.charAt(4);
			
			if(pb.equals(end)){
				output=pat.concat("B");
				break;
			}else{
				if(!states.contains(pb)){
					states.add(pb);
					q.add(pb);
					path.put(pb, pat.concat("B"));
				}
				
			}
			
			//C
			String pc=""+cur.charAt(0)+cur.charAt(6)+cur.charAt(1)+cur.charAt(3)+cur.charAt(4)+cur.charAt(2)+cur.charAt(5)+cur.charAt(7);
			if(pc.equals(end)){
				output=pat.concat("C");
				break;
			}else{
				
				if(!states.contains(pc)){
					states.add(pc);
					q.add(pc);
					path.put(pc, pat.concat("C"));
				}
			}
		}
		}
		
		
		System.out.println(output);
		System.out.println(output.length());
		out.println(output.length());
		out.println(output);
		out.close();
}



}
