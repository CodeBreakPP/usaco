/*
ID: xiny.d1
LANG: JAVA
TASK: shuttle
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class shuttle {
public static void main(String[] args) throws IOException{
		
		BufferedReader f=new BufferedReader(new FileReader("shuttle.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("shuttle.out")));
		int N=Integer.parseInt(f.readLine());

		Queue<Long> q=new LinkedList<Long>();
		//Queue<Integer> bases=new LinkedList<Integer>();
		Queue<Integer> steps=new LinkedList<Integer>();
		HashSet<Long>visited=new HashSet<Long>();
		HashMap<Long,Long>pre=new HashMap<Long,Long>();
		HashMap<Long,Integer>prestep=new HashMap<Long,Integer>();
		
		long start=0;
		long end=0;
		//int base=1;
		for(int i=0;i<N;i++){
			start+=2;
			start*=3;
			end+=1;
			end*=3;
			//base*=3;
		}
		for(int i=0;i<N;i++){
			start*=3;
			start+=1;
			end*=3;
			end+=2;
		}
		
		//System.out.println(start);
		//System.out.println(end);
		
		q.add(start);
		//bases.add(base);
		visited.add(start);
		steps.add(N+1);
		
		
		while(!q.isEmpty()){
			
			long cur=q.poll();
			int step=steps.poll();
			long bas=(long)Math.pow(3, 2*N+1-step);
			//System.out.println(cur);
			//System.out.println(bas+" "+step);
			long pre1=0;
			if(step-1>=1){
				pre1=cur%(bas*9)/(bas*3);
				if(pre1==1){
					pre1=0;
				}
			}
			//System.out.println(pre1);
			
			long pre2=0;
			if(step-2>=1){
				pre2=cur%(bas*27)/(bas*9);
				if(pre2==1){
					pre2=0;
				}
				
			}
			//System.out.println(pre2);
			long pos1=0;
			if(step+1<=2*N+1){
				pos1=cur%(bas)/(bas/3);
				if(pos1==2){
					pos1=0;
				}
			}
			else if(step+1==2*N+1){
				pos1=cur%3;
			}
			//System.out.println(pos1);
			
			long pos2=0;
			if(step+2<=2*N+1){

				pos2=cur%(bas/3)/(bas/9);
				if(pos2==2){
					pos2=0;
				}
				
			}
/*			else if(step+2==2*N+1){
				
				pos2=cur%3;
			}*/
			//System.out.println(pos2);
			
			if(pre1>0){
				long tmp=cur-pre1*(bas*2);
				
				if(tmp==end){
					pre.put(tmp, cur);
					prestep.put(tmp, step-1);
					break;
				} else
				if(!visited.contains(tmp)){
					pre.put(tmp, cur);
					q.add(tmp);
					steps.add(step-1);
					prestep.put(tmp, step-1);
					visited.add(tmp);
				}
			}
			if(pre2>0){
				if(pre2!=pre1){
					Long tmp=cur-pre2*(bas*8);
					if(tmp==end){
						prestep.put(tmp, step-2);
						pre.put(tmp, cur);
						System.out.println("end");
						break;
					} else
					if(!visited.contains(tmp)){
						steps.add(step-2);
						prestep.put(tmp, step-2);
						pre.put(tmp, cur);
						q.add(tmp);
						visited.add(tmp);
					}
				}
			}
			if(pos1>0){
				Long tmp=cur+pos1*((bas/3)*2);
				if(tmp==end){
					prestep.put(tmp, step+1);
					pre.put(tmp, cur);
					System.out.println("end");
					break;
				} else
				if(!visited.contains(tmp)){
					steps.add(step+1);
					prestep.put(tmp, step+1);
					pre.put(tmp, cur);
					q.add(tmp);
					visited.add(tmp);
				}
			}
			if(pos2>0){
				
				if(pos1!=pos2){
					Long tmp=cur+pos2*((bas/9)*8);
					if(tmp==end){
						prestep.put(tmp, step+2);
						pre.put(tmp, cur);
						break;
					}else
					if(!visited.contains(tmp)){
						steps.add(step+2);
						prestep.put(tmp, step+2);
						pre.put(tmp, cur);
						q.add(tmp);
						//bases.add(bas/9);
						visited.add(tmp);
					}
				}
			}
		}
		
		//System.out.println(q.isEmpty());
		
		int numstep=0;
		Long lastpos=end;
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		while(lastpos!=start){
			//System.out.println(lastpos);
			al.add(prestep.get(lastpos));
			lastpos=pre.get(lastpos);
			numstep+=1;
		}
		out.print(al.get(numstep-1));
		int count=1;
		for(int i=numstep-2;i>=0;i--){
			if(count%20==0){
				out.println();
				out.print(al.get(i));
			}else{
				
				//System.out.println(al.get(i)+" ");
				out.print(" "+al.get(i));
			}
			count++;
			

		}
		out.println();
		out.close();
		System.out.println(numstep);
		

}
}
