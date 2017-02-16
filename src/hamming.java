import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
ID: xiny.d1
LANG: JAVA
TASK: hamming
*/
public class hamming {
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		BufferedReader f=new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		int num=(int) Math.pow(2, B);
		//System.out.println(num);
		int[][] distances=new int[num][num];
		
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
			distances[i][j]=hammingDistance(i,j);
			}
		}
		//System.out.println(distances[0][7]);
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(int i=0;i<num;i++){
			al.clear();
			al.add(i);
			int j=i+1;
			while(al.size()<N&&j<num){
				
				Boolean add=true;
				for(Integer a : al){
					if(distances[a][j]<D){
						add=false;
						break;
					}	
				}
				
				if(add)al.add(j);
				j+=1;
			}
			
			if(al.size()==N){
				break;
			}
		}
		
		
		for(int k=0;k<al.size();k++){
			if((k+1)%10==0){
				out.println(al.get(k));
			}else{
				if(k==al.size()-1){
					out.println(al.get(k));
				}else{
					out.print(al.get(k)+" ");
				}
			}
			
		}
		out.close();
	}
	
	public static int hammingDistance(int x,int y){
		int dis=0;
		
		while(x>0||y>0){
			dis+=((x%2)^(y%2));
			x=x/2;
			y=y/2;
		}
		
		return dis;
	}
	
	
	
}
