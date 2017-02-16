import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: xiny.d1
LANG: JAVA
TASK: sort3
*/
public class sort3 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int N=Integer.parseInt(f.readLine());
		int[] nums=new int[N];
		int[][] squares=new int[3][3];
		int ones=0;
		int twos=0;
		int threes=0;
		
		
		for(int i=0;i<N;i++){
			nums[i]=Integer.parseInt(f.readLine());
			if(nums[i]==1){
				ones+=1;
			}else if(nums[i]==2){
				twos+=1;
			}else if(nums[i]==3){
				threes+=1;
			}
		}
		
		for(int i=0;i<N;i++){
			if(i<ones){
				squares[0][nums[i]-1]+=1;
			}else if(i<ones+twos){
				
				squares[1][nums[i]-1]+=1;
			}else{
				squares[2][nums[i]-1]+=1;
			}
		}
		int steps=0;
		
		int onetwo=Math.min(squares[0][1], squares[1][0]);
		squares[0][1]-=onetwo;squares[1][0]-=onetwo;
		squares[0][0]+=onetwo;squares[1][1]+=onetwo;
		steps+=onetwo;
		
		int onethree=Math.min(squares[0][2], squares[2][0]);
		squares[0][2]-=onethree;squares[2][0]-=onethree;
		squares[0][0]+=onethree;squares[2][2]+=onethree;
		steps+=onethree;
		
		int twothree=Math.min(squares[1][2], squares[2][1]);
		squares[1][2]-=twothree;squares[2][1]-=twothree;
		squares[1][1]+=twothree;squares[2][2]+=twothree;
		steps+=twothree;
		
		int loop1=Math.min(Math.min(squares[0][1], squares[1][2]),squares[2][0]);
		
		int loop2=Math.min(Math.min(squares[0][2], squares[1][0]),squares[2][1]);
		
		steps+=2*loop1;
		steps+=2*loop2;
		
		System.out.println(steps);
		out.println(steps);
		out.close();
		
	}
}
