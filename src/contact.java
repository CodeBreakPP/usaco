/*
ID: xiny.d1
LANG: JAVA
TASK: contact
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class contact {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("contact.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		String sequence="";
		String nextline=f.readLine();
		while(nextline!=null){
			sequence=sequence.concat(nextline);
			nextline=f.readLine();
		}
		
		int length=sequence.length();
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		
		for(int i=A;i<=B;i++){
			
			for(int j=0;j+i<=length;j++){
				
				String sub=sequence.substring(j,j+i);
				
				if(hm.containsKey(sub)){
					
					hm.put(sub,hm.get(sub)+1);
					
				}else{
					hm.put(sub, 1);
				}
				
			}
			
			
		}
		
		HashMap<Integer,ArrayList<String>> outputhm=new HashMap<Integer,ArrayList<String>>();
		Queue<Integer> priorityQueue =  new PriorityQueue<Integer>();  

		
		Iterator iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
	       String key = (String) entry.getKey();
	       Integer val = (Integer) entry.getValue();
	       
	       if(outputhm.containsKey(val)){
	    	   outputhm.get(val).add(key);
	       }else{
	    	   ArrayList<String>al=new ArrayList<String>();
	    	   al.add(key);
	    	   outputhm.put(val, al);   
	    	   priorityQueue.add(-val);
	       }
	       
	    }
		
		for(int i=0;i<N;i++){
			if(priorityQueue.isEmpty())break;
			
			int val=-priorityQueue.poll();
			System.out.println(val);
			out.println(val);
			ArrayList<String>al=outputhm.get(val);
			Collections.sort(al, new Comparator<String>() {  
	            public int compare(String o1, String o2) {  

	            	if(o1.length()!=o2.length()){
	            		return o1.length()-o2.length();
	            	}else{
	            		return o1.compareTo(o2);
	            	}
	            	
	            }  
	        });  
			
			int size=al.size();
			int volume=al.get(0).length();
			
			out.print(al.get(0));
			
			for(int j=1;j<size;j++){
				String a=al.get(j);
				
				volume+=1;
				volume+=a.length();
				
				if(volume>=80){
					out.println();
					out.print(a);
					volume=a.length();
					
				}else{
					out.print(" "+a);
				}
				
				
				
			}
			
			out.println();
			
			//System.out.println(al.get(size-1));
			//out.println(al.get(size-1));
		}
		
		
		out.close();
		


}
}
