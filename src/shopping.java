/*
ID: xiny.d1
LANG: JAVA
TASK: shopping
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;


public class shopping {
	
static int[]state;
static int[] maxqul;
static int[] price;
static int s;
static int b;
static HashMap<Integer,Integer>code2id;
static HashMap<Integer,Integer>dp;
static HashMap<Integer,Integer>sp2price;
static HashMap<Integer,HashMap<Integer,Integer>>spoffer;

public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("shopping.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		s=Integer.parseInt(f.readLine());
		spoffer=new HashMap<Integer,HashMap<Integer,Integer>>();
		sp2price=new HashMap<Integer,Integer>();
		
		for(int i=0;i<s;i++){
			
			StringTokenizer st=new StringTokenizer(f.readLine());
			int k=Integer.parseInt(st.nextToken());
			
			HashMap<Integer,Integer>tmp=new HashMap<Integer,Integer>();
			
			for(int j=0;j<k;j++){
				
				int id=Integer.parseInt(st.nextToken());
				int qul=Integer.parseInt(st.nextToken());
				tmp.put(id, qul);
			}
			spoffer.put(i, tmp);
			sp2price.put(i, Integer.parseInt(st.nextToken()));
		}
		
		code2id=new HashMap<Integer,Integer>();
		
		b=Integer.parseInt(f.readLine());
		
		maxqul=new int[b];
		price=new int[b];
		
		for(int i=0;i<b;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			int code=Integer.parseInt(st.nextToken());
			code2id.put(code, i);
			maxqul[i]=Integer.parseInt(st.nextToken());
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<b;i++){
			
			System.out.println(price[i]);
			
		}
		
		dp=new HashMap<Integer,Integer>();
		dp.put(0, 0);
		state=new int[b];
		
		//System.out.println(price[1]);
		recur(0,0,0);
		
/*		Iterator<Integer> iter=dp.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			Integer val = dp.get(key);
			System.out.println(key+":"+val);
		}*/
		
		int output=0;
		for(int i=0;i<b;i++){
			output+=Math.pow(10, i)*maxqul[i];
		}
		System.out.println(output);
		System.out.println(dp.get(output));
		out.println(dp.get(output));
		out.close();
		

}

public static void recur(int curid,int lsstate,int lstprice){
	if(b==0){
		return;
	}
	
	if(curid==b-1){
		for(int j=0;j<=maxqul[curid];j++){
			state[curid]=j;
			int stateint=lsstate+(int)Math.pow(10, curid)*j;
			
			int fin=lstprice+price[curid]*j;
			
			for(int k=0;k<s;k++){
				
				HashMap<Integer,Integer>tmp=spoffer.get(k);
				
				Iterator<Integer> iter=tmp.keySet().iterator();
				
				int newstateint=stateint;
				
				while(iter.hasNext()){
					
					Integer key = iter.next();
					Integer val = tmp.get(key);
					int id=code2id.get(key);
					
					if(val>state[id]){
						newstateint=-1;
						break;
					}
					
					newstateint-=(Math.pow(10, id)*val);
				}
				
				if(newstateint<0){
					continue;
				}
/*				if(stateint==1100){
					
					System.out.println(k+"\\"+1100+"\\"+newstateint);
				}*/
				//System.out.println(newstateint);
				int lastp=dp.get(newstateint)+sp2price.get(k);
				//System.out.println(fin);
				//System.out.println(lastp);
				
				fin=Math.min(lastp, fin);
				
				
			}
			
/*			if(stateint==1100){
				
				System.out.println(1100+"\\"+fin);
			}
			*/
			dp.put(stateint, fin);
			//System.out.println(stateint+":"+dp.get(stateint));
		}
		//System.out.println(state+":"+dp.get(state));
		state[curid]=0;
		
	}else{
	
	
		for(int j=0;j<=maxqul[curid];j++){
			state[curid]=j;
			//stateint=;
			recur(curid+1,lsstate+(int)Math.pow(10, curid)*j,lstprice+price[curid]*j);
		}
		state[curid]=0;
	
	}



}
}
