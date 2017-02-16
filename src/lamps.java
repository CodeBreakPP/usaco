/*
ID: xiny.d1
LANG: JAVA
TASK: lamps
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class lamps {
public static void main(String[] args) throws IOException {
	
		
		
		BufferedReader f=new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		Integer N=Integer.parseInt(f.readLine());
		Integer C=Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		ArrayList<Integer> zeros=new ArrayList<Integer>();
		ArrayList<Integer> ones=new ArrayList<Integer>();
		
		BigInteger bi=new BigInteger("0");
		BigInteger b1=new BigInteger("0");
		BigInteger b2=new BigInteger("0");
		BigInteger b3=new BigInteger("0");
		BigInteger b4=new BigInteger("0");
		
		BigInteger one=new BigInteger("2");
		
		for(int i=0;i<N+1;i++){
			BigInteger v1=one.pow(N-i);
			bi=bi.add(v1);
			b1=b1.add(v1);
			//System.out.println(v1);
			if(i%2==0){
				b2=b2.add(v1);
			}else{
				b3=b3.add(v1);
			}
			if(i%3==1){
				b4=b4.add(v1);
			}
		}
		
		int next=Integer.parseInt(st.nextToken());
		while(next!=-1){
			ones.add(next);
			next=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(f.readLine());
		next=Integer.parseInt(st.nextToken());
		while(next!=-1){
			zeros.add(next);
			next=Integer.parseInt(st.nextToken());
		}

		Collection<BigInteger> cc = new HashSet();
		//System.out.println(bi);
		cc.add(bi);
		
		for(int j=0;j<C;j++){
			Collection<BigInteger> nextc = new HashSet();
			for(BigInteger c:cc){
				nextc.add(c.xor(b1));
				nextc.add(c.xor(b2));
				nextc.add(c.xor(b3));
				nextc.add(c.xor(b4));
			}
			cc=nextc;
		}
		
		//BigInteger test=new BigInteger("0");
		//System.out.println(test.flipBit(0));
		
		int count=0;
		ArrayList<String> outputs=new ArrayList<String>();
		for(BigInteger s:cc){
			//System.out.println(s);
			
			Boolean decide=true;
			for(int i:ones){
				//System.out.println(i);
				//System.out.println(N-i);
				BigInteger s2=s.flipBit(N-i);
				if(s.compareTo(s2)!=1){
					decide=false;
					break;
				}
			}
			if(decide){
				for(int i:zeros){
					//System.out.println(i);
					BigInteger s2=s.flipBit(N-i);
					if(s.compareTo(s2)!=-1){
						decide=false;
						break;
					}
				}
			}
			if(decide){
				String output="";
				System.out.println(s);
				byte[] bts=s.toByteArray();
				for(Byte b:bts){
					System.out.println(byteToBit(b));
					output=output+byteToBit(b);
				}
				//System.out.println(output);
				
				if(output.length()<N){
					int len=output.length();
					for(int jj=0;jj<N-len;jj++){
						output="0"+output;
					}
					System.out.println(0+" "+output);
				}else{
					
					output=output.substring(output.length()-N);
					//output=(String) output.subSequence(output.length()-N,output.length());
					System.out.println(1+" "+output);
					System.out.println(output.length());
				}
				outputs.add(output);
				//outputs.add(new StringBuilder(output).reverse().toString());
				count+=1;
			}
		}
		
		System.out.println(outputs.size());
		
		if(count==0)out.println("IMPOSSIBLE");
		else{
			Collections.sort(outputs);
			
		}
		for(String output:outputs){
			out.println(output);
		}
		out.close();

}
public static String byteToBit(byte b) {  
    return ""  
            + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)  
            + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)  
            + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)  
            + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);  
}  
}
