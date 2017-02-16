/*
ID: xiny.d1
LANG: JAVA
TASK: fence6
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
import java.util.StringTokenizer;

public class fence6 {
	
	static HashMap<Integer,ArrayList<HashSet<Integer>>> connect;
	static HashMap<String,Integer>ends;
	static HashMap<Integer,Integer>lengths;
	static int output;
	
	public static void main(String[] args) throws IOException {

		BufferedReader f=new BufferedReader(new FileReader("fence6.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fence6.out")));
		int lines=Integer.parseInt(f.readLine());
		StringTokenizer st;
		
		//ArrayList<ArrayList<HashSet<Integer>>> connect=new ArrayList<ArrayList<HashSet<Integer>>>();
		connect=new HashMap<Integer,ArrayList<HashSet<Integer>>>();
		ends=new HashMap<String,Integer>();
		
		int[] alln=new int[lines];
		lengths=new HashMap<Integer,Integer>();
		
		for(int i=0;i<lines;i++){
			st = new StringTokenizer(f.readLine());
			
			int n=Integer.parseInt(st.nextToken());
			alln[i]=n;
			int len=Integer.parseInt(st.nextToken());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			lengths.put(n, len);
			
			st = new StringTokenizer(f.readLine());
			
			ArrayList<HashSet<Integer>>al=new ArrayList<HashSet<Integer>>();
			HashSet<Integer> hs1=new HashSet<Integer>();
			
			for(int j=0;j<n1;j++){
				int end=Integer.parseInt(st.nextToken());
				hs1.add(end);
				ends.put(n+" "+end, 0);
			}
			
			
			st = new StringTokenizer(f.readLine());
			HashSet<Integer> hs2=new HashSet<Integer>();
			
			for(int j=0;j<n2;j++){
				int end=Integer.parseInt(st.nextToken());
				hs2.add(end);
				ends.put(n+" "+end, 1);
			}
			al.add(hs1);
			al.add(hs2);
			connect.put(n, al);
		}
	
		output=Integer.MAX_VALUE;
		
		for(int i=0;i<lines;i++){
			for(int j=i+1;j<lines;j++){
				
				
				
				
				int s1=alln[i];
				int s2=alln[j];
				if(ends.containsKey(s2+" "+s1)==false)continue;
				HashSet<Integer> hs=new HashSet<Integer>();
				hs.add(s1);
				hs.add(s2);
				int pre=lengths.get(s1)+lengths.get(s2);
				
				
				int end=ends.get(s2+" "+s1);
				recur(s1,pre,s2,2,end,hs);
				
			}	
		}
		
		
		
		System.out.println(output);
		out.println(output);
		out.close();
		
	
	}
	
	public static void recur(int start, int pre,int cur,int sides,int end,HashSet<Integer> preside){
		
		
		
		HashSet<Integer>hs123 =connect.get(cur).get(1-end);
		
		if(sides>2){
			if(hs123.contains(start)){
				
				output=Math.min(output, pre);
				
			}else{
				
				for(Integer h123:hs123){
					
					if(preside.contains(h123)){
						continue;
					}
					
					preside.add(h123);
					int endn=ends.get(h123+" "+cur);
					recur(start,pre+lengths.get(h123),h123,sides+1,endn,preside);
					preside.remove(h123);
				}
				
			}
			
			
		}else{
		
			for(Integer h123:hs123){
				
				if(preside.contains(h123)){
					continue;
				}
				
				preside.add(h123);
				int endn=ends.get(h123+" "+cur);
				recur(start,pre+lengths.get(h123),h123,sides+1,endn,preside);
				preside.remove(h123);
			}
		
		
		}
		
	}
	
	
	
	
}
