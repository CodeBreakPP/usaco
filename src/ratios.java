/*
ID: xiny.d1
LANG: JAVA
TASK: ratios
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ratios {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("ratios.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
		HashSet<String> hs=new HashSet<String>();
		
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(f.readLine());
			int a1=Integer.parseInt(st.nextToken());
			int b1=Integer.parseInt(st.nextToken());
			int c1=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(f.readLine());
			int a2=Integer.parseInt(st.nextToken());
			int b2=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(f.readLine());
			int a3=Integer.parseInt(st.nextToken());
			int b3=Integer.parseInt(st.nextToken());
			int c3=Integer.parseInt(st.nextToken());
			
			long x=0;
			long y=0;
			long z=0;
			long w=1;
			//Boolean nen=false;
			
			int newb2=(a1*b2-b1*a2);
			int newb3=(a1*b3-b1*a3);
			
			int newc2=(a1*c2-c1*a2);
			int newc3=(a1*c3-c1*a3);
			
			newc3=(newb2*newc3-newc2*newb3);
			
			if(newc3==0||newb2==0||a1==0){
				
				System.out.println("NONE");
				out.println("NONE");
			}else{
			
			System.out.println(newb2+" "+newc3);
			
			while(true){
				

				
				long w1=w*a;
				
				long w2=a1*b*w-a*b1*w;
				
				long w3=a1*c*w-a*c1*w;
				
/*				if(w==98){
					System.out.println(w2+" "+w3);
				}*/
				
				w3=(newb2*w3-w2*newc2);
				
/*				if(w==98){
					System.out.println(w2+" "+w3);
				}*/
				
				//int[] ps=posprocess(w1-a2*y-a3*z,a1,w2-newb3*z,newb2,w3,newc3);
				
				if(w3%newc3==0){
					z=w3/newc3;
					
					if((w2-newb3*z)%newb2==0){
						y=(w2-newb3*z)/newb2;
						if((w1-a2*y-a3*z)%a1==0){
							x=(w1-a2*y-a3*z)/a1;
							break;
					}
					}
					
				}
				w++;
				
				/*else{
					
					String state=(w3%newc3)+" "+((w2-newb3*z)%newb2)+" "+((w1-a2*y-a3*z)%a1);
					if(hs.contains(state)){
						nen=true;
						break;
					}else{
						hs.add(state);
					}
					
				}
				w++;
				break;*/
			}
			
			System.out.println(w);
			if(x<0||y<0||z<0||w==0){
				System.out.println("NONE");
				out.println("NONE");
			}else{
				long[]outputs=mgcd(new long[]{x,y,z,w});
				System.out.println(outputs[0]+" "+outputs[1]+" "+outputs[2]+" "+outputs[3]);
				out.println(outputs[0]+" "+outputs[1]+" "+outputs[2]+" "+outputs[3]);
				System.out.println();
				
			}
			}
			out.close();
}

/*public static int[] posprocess(int n1,int d1,int n2,int d2,int n3,int d3){
	
	
	System.out.println(n1+" "+d1+" "+n2+" "+d2+" "+n3+" "+d3);
	
	
	if(d1==0||d2==0||d3==0){
		return new int[]{-1,-1,-1,-1};
	}else{
	
		int multiple=d1*d2*d3;
		int[] outputs=mgcd(new int[]{n1*multiple,n2*multiple,n3*multiple,multiple});
		
		return outputs;
	}
}*/



public static long[] mgcd(long[] ary){
	int len=ary.length;
	long output=ary[0];
	for(int i=1;i<len;i++){
		output=gcd(output,ary[i]);
	}
	
	long[] outputs=new long[len];
	for(int i=0;i<len;i++){
		
		outputs[i]=ary[i]/output;
		
	}
	
	
	
	return outputs;
	
}

public static long gcd(long x,long y){
	
	if(x==0||y==0){
		return Math.max(x, y);
	}
	
	if(x<y){
		long swap=x;
		x=y;
		y=swap;
	}
	
	long r=x%y;
	
	while(r>0){
		
		x=y;
		y=r;
		r=x%y;

	}
	
	return y;
	
}



}
