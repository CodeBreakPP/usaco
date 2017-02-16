/*
ID: xiny.d1
LANG: JAVA
TASK: milk2
*/
package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class milk2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		ArrayList List = new ArrayList(); 
		
		for(int i=0;i<N;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			Integer begin=Integer.parseInt(st.nextToken());
			Integer end=Integer.parseInt(st.nextToken());
			Integer[] pair={begin,end};
			List.add(pair);
		}
		
        Collections.sort(List,new Comparator<Integer[]>(){  
            @Override  
            public int compare(Integer[] b1, Integer[] b2) {  
                if(b1[0]!=b2[0]){
            	return b1[0]-b2[0];
                }else{
                	return b1[1]-b2[1];
                }
            }
        });  
		
		for(int i=0;i<N;i++){
			Integer[] a=(Integer[]) List.get(i);
			System.out.println(a[0]+" "+a[1]);
		}
		Integer begin=0;
		Integer end=0;
		Integer rest=0;
		Integer busy=0;
		
		for(int i=0;i<N;i++){
			Integer[] a=(Integer[]) List.get(i);
			if(i==0){
				
				begin=a[0];
				end=a[1];
				if(end-begin>busy){
					busy=end-begin;
				}
				
				continue;
			}
			
			if(a[0]>end){
				if(end-begin>busy){
					busy=end-begin;
				}
				
				if(a[0]-end>rest){
					rest=a[0]-end;
				}
				begin=a[0];
				end=a[1];
				if(end-begin>busy){
					busy=end-begin;
				}
			}else{
				if(a[1]>end){
					end=a[1];
				}
				if(end-begin>busy){
					busy=end-begin;
				}
				
			}
		}
		out.print(busy);
		out.print(" ");
		out.println(rest);
		out.close();
		
	}
}
