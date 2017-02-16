/*
ID: xiny.d1
LANG: JAVA
TASK: range
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class range {
	static HashMap<Integer,Integer>hm;
	static HashMap<Integer,Integer>sides;
	
	static int[][] square;
	static int N;
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("range.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
		N=Integer.parseInt(f.readLine());
		
		square=new int[N][N];
		hm=new HashMap<Integer,Integer>();
		sides=new HashMap<Integer,Integer>();
		//hm=new HashMap<Integer,HashSet<Integer>>();
		
		for(int i=0;i<N;i++){
			
			String line=f.readLine();
			
			for(int j=0;j<N;j++){
				square[i][j]=(line.charAt(j))-'0';
			}
			
			hm.put(i+1, 0);
		}
		
		
		
		
		for(int i=0;i<N;i++){
		
			for(int j=0;j<N;j++){
				
				if(square[i][j]==1){
					recur3(i,j);
				}
				
/*				if(square[i][j]==1){
					
					if(i+1==N&&j+1==N){
						recur2(i,j,1);
					}else if(i+1<N&&j+1<N){
						
						if(square[i+1][j+1]==0&&square[i+1][j]==0&&square[i][j+1]==0){
							
							recur2(i,j,1);
							
						}
						
					}else if(i+1==N){
						if(square[i][j+1]==0){
							
							recur2(i,j,1);
						}
						
						
						
					}else if(j+1==N){
						
						if(square[i+1][j]==0){
							
							recur2(i,j,1);
						}
						
						
					}
					
					
									if(square[i-1][j-1]==1&&square[i][j-1]==1&&square[i-1][j]==1){
						
						hm.get(2).add(i*N+j);
						recur(i,j,3);
					}
				}*/
			}
		}
		
/*		for(int i=0;i<N;i++){
			
			for(int j=0;j<N;j++){
				
				System.out.println(i+" "+j+":"+sides.get(i*N+j));
				
			}
		}*/
		
		
/*		Iterator<Integer> iter=hm.keySet().iterator();
		while(iter.hasNext()){
			
			Integer key = iter.next();
			Integer val=hm.get(key);
			System.out.println(key+":"+val);
		}*/
		
		
		for(int i=2;i<=N;i++){
			
			if(hm.get(i)>0){
				//System.out.println(i+" "+hm.get(i));
				out.println(i+" "+hm.get(i));
			}
			
		}
		
		
/*		Iterator<Integer> iter=hm.keySet().iterator();
		
		Set<Integer> hs=hm.keySet();
		Integer[]output=new Integer[N];
		hs.toArray(output);
		Arrays.sort(output);
		
		for(Integer h:hs){
			Integer key = iter.next();
			HashSet<Integer> val = hm.get(key);
			
			if(val.size()>0){
				
				//System.out.println(key+" "+val.size());
				out.println(key+" "+val.size());
			}
			
			
		}*/
		
		out.close();
		
}

public static void recur3(int x,int y){
	
	if(x-1<0||y-1<0){
		sides.put(x*N+y, 1);
		return;
	}
	
	if(sides.containsKey(x*N+y-1)==false||sides.containsKey((x-1)*N+y)==false||sides.containsKey((x-1)*N+y-1)==false){
		sides.put(x*N+y, 1);
		return;
	}

	int side1=sides.get((x-1)*N+y);
	int side2=sides.get((x)*N+y-1);
	int side3=sides.get((x-1)*N+y-1);
	
	int side=Math.min(Math.min(side1, side2),side3)+1;
	
	for(int i=side;i>=2;i--){
		int tmp=hm.get(i)+1;
		hm.put(i, tmp);
	}
	
	sides.put(x*N+y, side);
	
	//System.out.println(x+" "+y+" "+2+" "+hm.get(2));
	
	//tmp=hm.get(2)+1;
	//hm.put(side, tmp);
	
}


public static void recur2(int x,int y,int side){
	
	if(x-side>=0&&y-side>=0){
		
		Boolean issquare=true;
		
		for(int i=0;i<=side;i++){
			
			if(square[x-side][y-i]==0){
				issquare=false;
				break;
			}
			
		}
		
		if(issquare){
		
			for(int i=0;i<=side;i++){
				if(square[x-i][y-side]==0){
					issquare=false;
					break;
				}
				
			}
		}
		
		if(issquare){
			recur2(x,y,side+1);
			
		}else{
			
			for(int i=2;i<=side;i++){
				
				int tmp=hm.get(i)+((side-i+1)*(side-i+1));
				hm.put(i, tmp);
			}
			
			
		}
		
		
		
	}else{
		
		if(side>1){
			for(int i=2;i<=side;i++){
				
				int tmp=hm.get(i)+((side-i+1)*(side-i+1));
				hm.put(i, tmp);
			}
			
		}
		
	}
	
	
	
}

/*public static void recur(int x,int y,int side){
	
	if(!hm.containsKey(side-1)){
		return;
	}
	
	if(hm.get(side-1).contains((x-1)*N+y)&&hm.get(side-1).contains((x-1)*N+y-1)&&hm.get(side-1).contains((x)*N+y-1)){
		
		hm.get(side).add(x*N+y);
		
		recur(x,y,side+1);	
	}
	
}*/



}
