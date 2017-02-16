/*
ID: xiny.d1
LANG: JAVA
TASK: fc
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class fc {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("fc.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fc.out")));
		
		int N=Integer.parseInt(f.readLine());
		double[]xs=new double[N];
		double[]ys=new double[N];
		
		for(int i=0;i<N;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			double X=Double.parseDouble(st.nextToken());
			double Y=Double.parseDouble(st.nextToken());
			xs[i]=X;
			ys[i]=Y;
		}
		f.close();
		
		double middleX=0;
		double middleY=0;
		
		for(int i=0;i<N;i++){
			middleX+=xs[i];
			middleY+=ys[i];
		}
		middleX/=N;
		middleY/=N;
		
		//System.out.println(middleX+" "+middleY);
		
		ArrayList<double[]> points=new ArrayList<double[]>();
		
		for(int i=0;i<N;i++){
			
			double arc=0;
			if(xs[i]==middleX){
				
				arc=Math.PI/2;
			}else{
			
				arc=Math.atan((ys[i]-middleY)/(xs[i]-middleX));
			}
			if(xs[i]<=middleX){arc+=Math.PI;}
			
			
			points.add(new double[]{i,arc});
		}
		
		Collections.sort(points, new Comparator<double[]>(){
			@Override
			public int compare(double[] o1, double[] o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1[1], o2[1]);
				
			}
			
		});
		
		
/*		for(double[] ps:points){
			System.out.println(ps[0]+" "+ps[1]);
		}*/
		
		ArrayList<Integer>hull=new ArrayList<Integer>();
		
		hull.add((int) points.get(0)[0]);
		hull.add((int) points.get(1)[0]);
		int hullpos=2;
		
		for(int i=2;i<N;i++){
			
			
			int curp=(int) points.get(i)[0];
			int last2=hull.get(hullpos-2);
			int last1=hull.get(hullpos-1);
			//System.out.println(curp+" "+last1+" "+last2);
			//System.out.println((xs[last2]-xs[last1])*(ys[last1]-ys[curp])+(ys[last2]-ys[last1])*(xs[last1]-xs[curp]));
			while(hullpos>1&&((xs[last2]-xs[last1])*(ys[last1]-ys[curp])-(ys[last2]-ys[last1])*(xs[last1]-xs[curp]))<0){
				hullpos-=1;
				//System.out.println(i+" "+hullpos);
				hull.remove(hullpos);
				if(hullpos<=1)break;
				last2=hull.get(hullpos-2);
				last1=hull.get(hullpos-1);
			}
			
			hull.add(curp);
			hullpos+=1;
			
		}
		
		
/*		for(int h:hull){
			
			System.out.println(h);
		}
		System.out.println(hullpos);*/


		Boolean flag;
		do{
			
			flag=false;
			
			int curp=(int) points.get(hullpos-1)[0];
			int start=hull.get(0);
			int last1=hull.get(hullpos-2);
			
			/*System.out.println(curp+" "+start+" "+last1);
			System.out.println(xs[start]-xs[curp]);//x1
			System.out.println(ys[start]-ys[curp]);//y1
			System.out.println(xs[curp]-xs[last1]);//x2
			System.out.println(ys[curp]-ys[last1]);//y2
*/			
			if(hullpos>3&&(-xs[start]-xs[curp])*(ys[curp]-ys[last1])+(ys[start]-ys[curp])*(xs[curp]-xs[last1])<0){
				hullpos-=1;
				hull.remove(hullpos);
				flag=true;
			}
			
			curp=(int) points.get(hullpos-1)[0];
			start=hull.get(0);
			int start1=hull.get(1);
			
			if(hullpos>3&&(xs[start]-xs[curp])*(ys[start1]-ys[start])-(ys[start]-ys[curp])*(xs[start1]-xs[start])<0){
				
				hull.remove(0);
				--hullpos;
				flag=true;
			}
			
			
			
			
		}while(flag);
		
/*		System.out.println();
		for(int h:hull){
			
			System.out.println(h);
		}*/
		
		double output=0;
		
		
		for(int i=0;i<hullpos;i++){
			
			int cur=hull.get(i);
			int nex=-1;
			if (i+1>=hullpos){
				nex=hull.get(0);
			}else{
				nex=hull.get(i+1);
			}
			output+=Math.sqrt((xs[cur]-xs[nex])*(xs[cur]-xs[nex])+(ys[cur]-ys[nex])*(ys[cur]-ys[nex]));
			
		}
		
		DecimalFormat    df= new DecimalFormat("######0.00");   
		
		System.out.println(df.format(output));
		out.println(df.format(output));
		
		out.close();
		
}
}
