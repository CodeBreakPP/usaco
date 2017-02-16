/*
ID: xiny.d1
LANG: JAVA
TASK: concom
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class concom {
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("concom.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		int N=Integer.parseInt(f.readLine());
		
		HashSet<Integer> vertex=new HashSet<Integer>();
		HashMap<Integer,HashSet> edge=new HashMap<Integer,HashSet>();
		HashMap<String,Integer> control=new HashMap<String,Integer>();
		
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int con=Integer.parseInt(st.nextToken());
			vertex.add(from);
			vertex.add(to);
			
			if(edge.containsKey(from)){
				
				HashSet<Integer> hs=edge.get(from);
				hs.add(to);
				edge.put(from,hs);
				
			}else{
				HashSet<Integer> hs=new HashSet<Integer>();
				hs.add(to);
				edge.put(from, hs);
			}
			control.put(from+" "+to, con);
		}
		
		
		
/*	       Iterator iter = control.entrySet().iterator();
		   while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
	       Object key = entry.getKey();
	       Object val = entry.getValue();
	       System.out.println(key+" "+val);
	    }*/
		
		   
/*		   iter = edge.entrySet().iterator();
		   
		   while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
		       Object key = entry.getKey();
		       HashSet val = (HashSet) entry.getValue();
		       
		       System.out.println(key+":");
		       for(Object v:val){
		    	   System.out.println(v);
		       }
		       
		    }*/
		
		
		   
		   for(Integer v:vertex){
			   
			   HashSet<Integer> controls=new HashSet<Integer>();
			   controls.add(v);
			   
			   Queue<Integer> bfs = new LinkedList<Integer>();  
			   bfs.add(v);
			   
			   HashSet<Integer>visited=new HashSet<Integer>();
			   
			   while(!bfs.isEmpty()){
				   
				   int vf=bfs.poll();
				   
				   if(visited.contains(vf))continue;
				   
				   visited.add(vf);
				   
				   HashSet<Integer> hs=edge.get(vf);
				   
				   if(hs==null){
					   continue;
				   }
				   
				   for(Integer h:hs){
					   int total=0;
					   for(Integer co:controls){						   
						   if(control.containsKey(co+" "+h)){
						   total+=control.get(co+" "+h);
						   //System.out.println(co+" "+h);
						   }
					
					   }
					   if(total>=50){
						   bfs.add(h);
						   controls.add(h);
					   }
					   
				   }
			   }
			   
			   //System.out.println(v+":");
			   
			   Integer [] outputs=new Integer[controls.size()];
			   
			   //ArrayList<Integer>outputs=new ArrayList<Integer>();
			   
			   controls.toArray(outputs);
			   
			   Arrays.sort(outputs);
			   
			   for(Integer con:outputs){
				   if(v==con)continue;
				   //System.out.println(v+" "+con);
				   out.println(v+" "+con);
			   }
			   
		   }
		   
		   
		
		out.close();
	}
}
