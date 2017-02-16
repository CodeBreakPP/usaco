/*
ID: xiny.d1
LANG: JAVA
TASK: preface
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class preface {
	public static void main(String[] args) throws IOException {
	
		
		
		BufferedReader f=new BufferedReader(new FileReader("preface.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		
		Integer N=Integer.parseInt(f.readLine());
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		int[] unit=new int[]{1000,100,10,1};
		
		for(int i=1;i<=N;i++){
			ArrayList<Integer> al=new ArrayList<Integer>();
			int remain=0;
			for(int u:unit){
				
				int ns=i/u;
				//System.out.println(ns+" "+u);
				if(ns==0)continue;
				if(ns==9){
					
					al.add(-u);
					al.add(10*u);
				}else if(ns==4){
					al.add(-u);
					al.add(5*u);
				}else if(ns==5){
					al.add(5*u);
				}else{
					if(ns>5){
						al.add(5*u);
						for(int j=0;j<ns-5;j++){
							al.add(u);
						}
					}else{
						for(int j=0;j<ns;j++){
							al.add(u);
						}
					}	
				}
				remain=i%u;
				break;
			}
			
			if(remain==0){
				map.put(i,al);
			}else{
				ArrayList<Integer> newal=map.get(remain);
				al.addAll(newal);
				map.put(i, al);
			}
		}
		
		
		int[] cha=new int[]{1,5,10,50,100,500,1000};
		int[] nums=new int[]{0,0,0,0,0,0,0};
		String[] strs=new String[]{"I","V","X","L","C","D","M"};
		
		for(int i=1;i<=N;i++){
			//System.out.println(i+":");
			ArrayList<Integer> al=map.get(i);
			for(Integer a:al){
				System.out.print(a);
				for(int c=0;c<7;c++){
					if(Math.abs(a)==cha[c]){
						nums[c]+=1;
					}
				}
			}
			System.out.println();
		}
		
		
		for(int i=0;i<7;i++){
			if(nums[i]>0){
				out.println(strs[i]+" "+nums[i]);
			}
		}

		out.close();
	}
}
