/*
ID: xiny.d1
LANG: JAVA
TASK: frameup
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class frameup {
	
static String output;
static HashSet<String>visited;
static HashMap<String,ArrayList<String>>edgefrom;
	
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("frameup.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("frameup.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int H=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		String[]board=new String[H];
		HashMap<String,HashSet<Integer>>pos=new HashMap<String,HashSet<Integer>>();
		
		for(int i=0;i<H;i++){
			board[i]=f.readLine();
		}
		
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				String key=""+board[i].charAt(j);
				if(pos.containsKey(key)){
					pos.get(key).add(i*W+j);
				}else{
					HashSet<Integer>hs=new HashSet<Integer>();
					hs.add(i*W+j);
					pos.put(key,hs);
				}
			}
		}
		pos.remove(".");
		Iterator iter=pos.keySet().iterator();
		HashMap<String,HashSet<String>>edge=new HashMap<String,HashSet<String>>();
		while(iter.hasNext()){
			String key=(String)iter.next();
			HashSet<Integer> hs=pos.get(key);
			int top=H;
			int bottom=0;
			int right=0;
			int left=W;
			for(Integer h:hs){
				right=Math.max(right, h%W);left=Math.min(left, h%W);top=Math.min(top, h/W);bottom=Math.max(bottom, h/W);
			}
			HashSet<String>node=new HashSet<String>();
			for(int i=left;i<=right;i++){
				String cur=board[top].charAt(i)+"";
				if(!key.equals(cur)){
					node.add(cur);
				}
			}
			for(int i=left;i<=right;i++){
				String cur=board[bottom].charAt(i)+"";
				if(!key.equals(cur)){
					node.add(cur);
				}
			}
			
			for(int i=top;i<=bottom;i++){
				String cur=board[i].charAt(left)+"";
				if(!key.equals(cur)){
					node.add(cur);
				}
			}
			for(int i=top;i<=bottom;i++){
				String cur=board[i].charAt(right)+"";
				if(!key.equals(cur)){
					node.add(cur);
				}
			}
			edge.put(key, node);
		}
		
		Iterator iter2=edge.keySet().iterator();
		
		ArrayList<String>nodes=new ArrayList<String>();
		edgefrom=new HashMap<String,ArrayList<String>>();
		
		while(iter2.hasNext()){
			
			String key=(String)iter2.next();
			
			HashSet<String>node=edge.get(key);
			
			if(node.isEmpty()){
				nodes.add(key);
			}
			
			for(String n:node){				
				if(edgefrom.containsKey(n)){
					edgefrom.get(n).add(key);
				}else{
					ArrayList<String>al= new ArrayList<String>();
					al.add(key);
					edgefrom.put(n, al);
				}
			}
		}
		
		Collections.sort(nodes);
		
		output="";
		visited=new HashSet<String>();
		
		//topological sort
		for(String no:nodes){
			visit(no);
		}
		System.out.println("sorted:");
		System.out.print(output);			
		int len=output.length();
		
		HashSet<String>output4=new HashSet<String>();
		Queue<String>q=new LinkedList<String>();
		q.add(output);
		while(!q.isEmpty()){
			String curq=q.poll();
			if(output4.contains(curq)){
				continue;
			}
			output4.add(curq);
			HashSet<String>part=new HashSet<String>();
			ArrayList<String>output2=new ArrayList<String>();
			output2.add("");
			part.add(curq.charAt(0)+"");
			for(int i=0;i<len-1;i++){
				String las=curq.charAt(i)+"";
				String nex=curq.charAt(i+1)+"";
				if(!edge.get(las).contains(nex)){
					
					String news=curq.substring(0,i)+nex+las+curq.substring(i+2);
					q.add(news);
					
				}
			}
			

		}
		
		System.out.println(output4.size());
		String[]output5=new String[output4.size()];
		output4.toArray(output5);
		Arrays.sort(output5);
		System.out.println(output5.length);
		for(String out5:output5){
			System.out.println(out5);
			out.println(out5);
		}
		
		//out.println();
		
		out.close();
}

public static void allpos(String las,HashSet<String> hs,HashSet<String>output){
	
	int len=hs.size();
	
	if(len>1){
	
		String[] curs=new String[hs.size()];
		hs.toArray(curs);
		
		for(int i=0;i<curs.length;i++){
			String cur=curs[i];
			hs.remove(cur);
			allpos(las+cur,hs,output);
			hs.add(cur);
		}
	
	}else{
		
		for(String h:hs){
			
			output.add(las+h);
			
		}
	}
}

public static void visit(String cur){
	if(!visited.contains(cur)){
		visited.add(cur);
		if(edgefrom.containsKey(cur)){
			ArrayList<String>al=edgefrom.get(cur);
			for(int j=al.size()-1;j>=0;j--){
				visit(al.get(j));
			}
		}
		output=output+cur;
	}
}



}
