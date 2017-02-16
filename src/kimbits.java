/*
ID: xiny.d1
LANG: JAVA
TASK: kimbits
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class kimbits {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("kimbits.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		long N=Integer.parseInt(st.nextToken());
		long L=Integer.parseInt(st.nextToken())+1;
		long I=Long.parseLong(st.nextToken());
		
		long[] total=new long[(int) (N+1)];
		long[] lar=new long[(int) (N+1)];
		long digit=N;
		long remain=I;
		long output=0;
		
		while(true){
		
			for(int i=0;i<=digit;i++){
				if(i==0){
					total[0]=1;
					if(remain<=1){
						remain-=1;
						break;
					}
				}else{
					total[i]=(long)Math.pow(2, i);
					lar[i]=0;
					for(int j=(int) L;j<=i;j++){
						lar[i]+=com(i,j);
					}					
					if(total[i]-lar[i]>=remain){
						L-=1;
						output+=total[i-1];
						digit=i;
						remain-=(total[i-1]-lar[i-1]);
						break;
					}
				}
			}
			
			//System.out.println(remain);
			
			if(remain<=0)break;
			
		}
		
		
		
/*		for(int i=0;i<=N;i++){
			
			if(i==0){
				if(1>=I){
					break;
				}
			}
			
			total[i]=(int)Math.pow(2, i);
			
			for(int j=L;j<=i;j++){
				lar[i]+=com(i,j);
			}
			
			if(total[i]-lar[i]>=I){
				digit=i;
				remain=total[i-1]-lar[i-1];
				break;
			}
			
		}
		
		System.out.println(remain);
		System.out.println(digit);
		
		int more=I-remain;
		int second=0;
		int remain2=0;
		
		
		for(int i=0;i<digit;i++){
			int j=(int)Math.pow(2, i);
			if(j-lar[i]>=more){
				second=i;
				break;
			}
			remain2=j-lar[i];
		}
		
		System.out.println(second);
		
		System.out.println(remain2);
		
		int start=(int)Math.pow(2, digit-1)+(int)Math.pow(2, second-1);
		int end=(int)Math.pow(2, digit-1)+(int)Math.pow(2, second);
		
		System.out.println(start);
		System.out.println(end);
		
		int from=remain+remain2;
		
		System.out.println(from);
		
		int output=start;
		
		for(int i=start;i<=end;i++){
			
			if(nof1(Integer.toBinaryString(i))<=L){
				from++;
				if(from==I){
					output=i;
					break;
				}
			}			
		}*/
		
		//System.out.println(output);
		//out.println(output);
		System.out.println(change(output,N));
		out.println(change(output,N));
		out.close();
		
		
}

public static int nof1(String s){
	int len=s.length();
	int output=0;
	for(int i=0;i<len;i++){
		if(s.charAt(i)=='1'){
			output+=1;
		}
	}
	return output;
	
}

public static String change(long N,long digits){
	
	String output=Long.toBinaryString(N);
	int len=output.length();
	if(digits==len){
		return output;
	}else{
		
		for(int i=0;i<digits-len;i++){
			output="0"+output;
			
		}
		
		
		return output;
		
	}
	
	
	
}

public static int com(int N,int R){
	if(N==0)return 0;

	if(N<R){
		return 0;
	}else if(N==R){
		return 1;
	}else{
		
		BigInteger output=new BigInteger("1");
		
		R=Math.min(R, N-R);
		
		for(int i=0;i<R;i++){
			output=output.multiply(new BigInteger(""+(N-i)));
		}
		for(int i=1;i<=R;i++){
			output=output.divide(new BigInteger(""+i));
		}
		
		return output.intValue();
		
	}


}
	


}
