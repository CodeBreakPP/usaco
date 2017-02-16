/*
ID: xiny.d1
LANG: JAVA
TASK: comehome
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class comehome {
	public static void main(String[] args) throws IOException {

	BufferedReader f=new BufferedReader(new FileReader("comehome.in"));
	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
	int lines=Integer.parseInt(f.readLine());
	HashSet<String> cows=new HashSet<String>();
	HashSet<String> places=new HashSet<String>();
	HashSet<String> unvisited=new HashSet<String>();
	HashMap<String,Boolean>visited=new HashMap<String,Boolean>();
	HashMap<String,Integer>edges=new HashMap<String,Integer>();
	HashMap<String,Integer>distance=new HashMap<String,Integer>();
	StringTokenizer st;
	
	for(int i=0;i<lines;i++){
		
		st = new StringTokenizer(f.readLine());
		String from=st.nextToken();
		String to=st.nextToken();
		int dis=Integer.parseInt(st.nextToken());
				
		distance.put(from, -1);
		distance.put(to, -1);
		
		if(from.charAt(0)>=65&&from.charAt(0)<=90){
			cows.add(from);
		}
		if(to.charAt(0)>=65&&to.charAt(0)<=90){
			cows.add(to);
		}
		
		places.add(from);
		places.add(to);
		unvisited.add(from);
		unvisited.add(to);
		visited.put(from, false);
		visited.put(to,false);
		
		if(edges.containsKey(from+" "+to)){
			int oridis=edges.get(from+" "+to);
			if(oridis>dis){
			
				edges.put(from+" "+to, dis);
				edges.put(to+" "+from, dis);
			}
		}else{
			edges.put(from+" "+to, dis);
			edges.put(to+" "+from, dis);
		}
		
		
	}
	
	Iterator iter = edges.entrySet().iterator();
	   while (iter.hasNext()) {
		Map.Entry entry = (Map.Entry) iter.next();
    Object key = entry.getKey();
    Object val = entry.getValue();
    System.out.println(key+" "+val);
 }
	
	
	distance.put("Z",0);
	unvisited.remove("Z");
	visited.put("Z", true);
	
	 String lst="Z";
	 
	 while(!unvisited.isEmpty()){
		 		 
		 String next="";
		 int distan=-1;
		 
		 for(String place:unvisited){
			 //System.out.println(lst+" "+place);
			 if(visited.get(place))continue;
			 
			 if(edges.containsKey(lst+" "+place)){
				 int edg=edges.get(lst+" "+place);
				 
				 if(distance.get(place)==-1||edg+distance.get(lst)<distance.get(place)){
					 distance.put(place,edg+distance.get(lst) );
				 }
				 
			 }
			 
			 if((distan==-1||distance.get(place)<distan)&&distance.get(place)>-1){
				 next=place;
				 distan=distance.get(place);
			 }
		 }
			
		 unvisited.remove(next);
		 visited.put(next,true);
		 lst=next;
	 }
	 
	 String output="";
	 int minidis=-1;
	 
		for(String cow:cows){
			
			if(cow.equals("Z")==false){
				if(distance.get(cow)<minidis||minidis==-1){
					minidis=distance.get(cow);
					output=cow;
				}
				
				
			}
			
			//System.out.println(cow+" "+distance.get(cow));
		}
		out.println(output+" "+minidis);
		out.close();
	}
	
	

	
}
