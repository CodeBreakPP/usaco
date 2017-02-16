/*
ID: xiny.d1
LANG: JAVA
TASK: milk3
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;  

public class milk3 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader f=new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int A = Integer.parseInt(st.nextToken());    // first integer
	    int B = Integer.parseInt(st.nextToken());
	    int C=Integer.parseInt(st.nextToken());
	
	    Queue<int[]> queue = new LinkedList<int[]>();
	    int[] first={0,0,C};
	    queue.add(first);
	    
	    ArrayList<Integer> al=new ArrayList<Integer>();
	    HashSet<String> books = new HashSet(); 
	    HashSet<Integer> output = new HashSet<Integer>(); 
	    books.add("0 0 "+C);
	    System.out.println(queue.size());
	    
	    String second="0 0 "+C;
	    //System.out.print(books.contains(second));
	    
	    
	    while(!queue.isEmpty()){
	    	
	    	first=queue.poll();
	    	System.out.println(first[0]);
	    	if(first[0]==0){
	    		output.add(first[2]);
	    	}
	    	
	    	if(first[0]>0){
	    		//pour from 1 to 3
	    		
	    		int c=Math.min(C,first[0]+first[2]);
	    		int dif=c-first[2];
	    		int a=first[0]-dif;
	    		
	    		int[]sec={a,first[1],c};
	    		String secs=a+" "+first[1]+" "+c;
	    		
	    		if(!books.contains(secs)){
	    			queue.add(sec);
	    			books.add(secs);
	    			//System.out.println(".1");
	    		}
	    		
	    		//pour from 1 to 2
	    		
	    		int b=Math.min(B,first[0]+first[1]);
	    		dif=b-first[1];
	    		a=first[0]-dif;
	    		int[] sec2={a,b,first[2]};
	    		secs=a+" "+b+" "+first[2];
	    		if(!books.contains(secs)){
	    			queue.add(sec2);
	    			books.add(secs);
	    			//System.out.println(".1");
	    		}
	    		
	    	}
	    	
	    	if(first[1]>0){
	    		//pour from 2 to 3
	    		int c=Math.min(C,first[1]+first[2]);
	    		int dif=c-first[2];
	    		int b=first[1]-dif;
	    		String secs=first[0]+" "+b+" "+c;
	    		int[] sec={first[0],b,c};
	    		if(!books.contains(secs)){
	    			queue.add(sec);
	    			books.add(secs);
	    			//System.out.println(".2");
	    		}
	    		
	    		
	    		//pour from 2 to 1
	    		int a=Math.min(A,first[0]+first[1]);
	    		dif=a-first[0];
	    		b=first[1]-dif;
	    		int[] sec2={a,b,first[2]};
	    		secs=a+" "+b+" "+first[2];
	    		if(!books.contains(secs)){
	    			queue.add(sec2);
	    			books.add(secs);
	    			//System.out.println(".2");
	    		}
	    	}
	    	
	    	if(first[2]>0){
	    		//pour from 3 to 1
	    		int a=Math.min(A,first[0]+first[2]);
	    		int dif=a-first[0];
	    		int c=first[2]-dif;
	    		int[] sec={a,first[1],c};
	    		String secs=a+" "+first[1]+" "+c;
	    		if(!books.contains(secs)){
	    			queue.add(sec);
	    			books.add(secs);
	    			//System.out.println(".3");
	    		}
	    		
	    		
	    		//pour from 3 to 2
	    		int b=Math.min(B,first[1]+first[2]);
	    		dif=b-first[1];
	    		c=first[2]-dif;
	    		int[] sec2={first[0],b,c};
	    		secs=first[0]+" "+b+" "+c;
	    		if(!books.contains(secs)){
	    			queue.add(sec2);
	    			books.add(secs);
	    			//System.out.println(".3");
	    		}
	    		
	    	}
	    }
	    
	    System.out.println();

	   	    
	    Integer[] ops=new Integer[output.size()];
	    
	    
	    int i=0;
	    
	    for(Integer ob:output){
	    	ops[i]=ob;
	    	i++;	    	
	    }
	    
	    Arrays.sort(ops);
	    i=0;
	    for(Integer ob:ops){
	    	
	    	out.print(ob);
	    	i++;
	    	if(i<output.size()){
	    		out.print(" ");
	    	}else{
	    		out.println();
	    	}
	    	
	    }
	    out.close();
	    
	}
	}