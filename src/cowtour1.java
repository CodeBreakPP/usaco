import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cowtour1 {
	public static void main(String[] args) throws IOException {
		Date date = new Date();
		BufferedReader f=new BufferedReader(new FileReader("cowtour.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
		int lines=Integer.parseInt(f.readLine());
		StringTokenizer st;
		HashMap<Integer,int[]> pos=new HashMap<Integer,int[]>();
		
		for(int i=0;i<lines;i++){
			st = new StringTokenizer(f.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			pos.put(i, new int[]{x,y});
		}
		
		//HashMap<Integer,HashSet<Integer>>edge=new HashMap<Integer,HashSet<Integer>>();
		
		double[][] distance=new double[lines][lines];
		
		for(int i=0;i<lines;i++){
			Arrays.fill(distance[i], 99999999999999.99);
			distance[i][i]=0.0;
		}
		
		for(int i=0;i<lines;i++){
			String line=f.readLine();
			//HashSet<Integer> hs=new HashSet<Integer>();
			for(int j=i+1;j<lines;j++){
				if(line.charAt(j)=='1'){
					distance[i][j]=caldist(pos.get(i),pos.get(j));
					distance[j][i]=distance[i][j];
				}
			}
		}
		

		Date date2 = new Date();
		System.out.println((date2.getTime()-date.getTime())/1000.0);
		
		double output=999999999.9;
		
		
		
		for(int ii=0;ii<lines;ii++){
			for(int jj=ii+1;jj<lines;jj++){
				
				if(distance[ii][jj]<99999999.999)continue;
				
				double[][] distance2=distance.clone();
				
				distance2[ii][jj]=caldist(pos.get(ii),pos.get(jj));
				distance2[jj][ii]=distance2[ii][jj];
				
				for(int k=0;k<lines;k++){
					for(int i=0;i<lines;i++){
						for(int j=i+1;j<lines;j++){
							distance2[i][j]=Math.min(distance2[i][j], distance2[i][k]+distance2[k][j]);
							distance2[j][i]=distance2[i][j];
						}
					}
				}
				
				double longe=0.0;
				
				for(int i=0;i<lines;i++){
					for(int j=i+1;j<lines;j++){
						if(distance2[i][jj]<99999999.9999&&distance2[ii][j]<99999999.9999&&distance2[i][j]<99999999.9999){
							longe=Math.max(longe, distance2[i][j]);
						}
					}
				}
				
				output=Math.min(output, longe);
				
				//System.out.println(ii+" "+jj+" "+longe);
				
			}
		}
		
		date2 = new Date();
		System.out.println((date2.getTime()-date.getTime())/1000.0);
			
		System.out.println(String.format("%.6f", output));
		
		out.println(String.format("%.6f", output));
		
		out.close();
	}
	
	public static double caldist(int[]pos1,int[]pos2){
		
		double squares=0;
		squares+=Math.pow(pos1[0]-pos2[0], 2);
		squares+=Math.pow(pos1[1]-pos2[1], 2);
		
		return Math.pow(squares, 0.5);
	}
}
