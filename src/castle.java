/*
ID: xiny.d1
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class castle {
	public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("castle.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int width=Integer.parseInt(st.nextToken()); 
		int height=Integer.parseInt(st.nextToken()); 
		
		int[][][] castle=new int[height][width][4];
		Boolean[][] visited=new Boolean[height][width];
		
		for(int i=0;i<height;i++){
			st = new StringTokenizer(f.readLine());
			for(int j=0;j<width;j++){
				visited[i][j]=false;
				int walls=Integer.parseInt(st.nextToken());
				if(walls>=8){
					castle[i][j][3]=1;
					walls-=8;
				}
				if(walls>=4){
					castle[i][j][2]=1;
					walls-=4;
				}
				if(walls>=2){
					castle[i][j][1]=1;
					walls-=2;
				}
				if(walls>=1){
					castle[i][j][0]=1;
					walls-=1;
				}
			}
		}
		
		int rooms=0;
		int maxarea=0;
		int[][] castleroom=new int[height][width];
		HashMap<Integer,Integer> room = new HashMap(); 
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if(!visited[i][j]){
					//System.out.println(i+" "+j);
					Stack<int[]> bfs=new Stack();
					bfs.push(new int[]{i,j});
					rooms+=1;
					int area=1;
					visited[i][j]=true;
					while(!bfs.isEmpty()){
						int[]position=(int[]) bfs.pop();
						
						int k=position[0];
						int l=position[1];
						
						if(l+1<width&&castle[k][l][2]==0&&!visited[k][l+1]){
							bfs.push(new int[]{k,l+1});
							room.put(k*width+l+1, i*width+j);
							visited[k][l+1]=true;
							area+=1;
						}
						if(k-1>=0&&castle[k][l][1]==0&&!visited[k-1][l]){
							bfs.push(new int[]{k-1,l});
							room.put((k-1)*width+l, i*width+j);
							visited[k-1][l]=true;
							area+=1;
						}
						
						if(l-1>=0&&castle[k][l][0]==0&&!visited[k][l-1]){
							bfs.push(new int[]{k,l-1});
							room.put(k*width+l-1, i*width+j);
							visited[k][l-1]=true;
							area+=1;
						}
						if(k+1<height&&castle[k][l][3]==0&&!visited[k+1][l]){
							bfs.push(new int[]{k+1,l});
							room.put((k+1)*width+l, i*width+j);
							visited[k+1][l]=true;
							area+=1;
						}	
					}
					
					if(area>maxarea){maxarea=area;}
					castleroom[i][j]=area;
					room.put(i*width+j, i*width+j);
					
				}else{
					int pos=room.get(i*width+j);
					int pos1=pos%width;
					int pos0=(pos-pos1)/width;
					castleroom[i][j]=castleroom[pos0][pos1];
				}
			}
		}
		
		int mergearea=0;
		String wall="";
		
		for(int j=0;j<width;j++){
			for(int i=height-1;i>=0;i--){
				if(i-1>=0&&castle[i][j][1]==1&&room.get(i*width+j)!=room.get((i-1)*width+j)){
					if(castleroom[i][j]+castleroom[i-1][j]>mergearea){
						mergearea=castleroom[i][j]+castleroom[i-1][j];
						wall=(i+1)+" "+(j+1)+" N";
					}
				}
				
				
				if(i+1<height&&castle[i][j][3]==1&&room.get(i*width+j)!=room.get((i+1)*width+j)){
					if(castleroom[i][j]+castleroom[i+1][j]>mergearea){
						mergearea=castleroom[i][j]+castleroom[i+1][j];
						wall=(i+2)+" "+(j+1)+" N";
					}
				}
				
				if(j+1<width&&castle[i][j][2]==1&&room.get(i*width+j)!=room.get((i)*width+j+1)){
					if(castleroom[i][j]+castleroom[i][j+1]>mergearea){
						mergearea=castleroom[i][j]+castleroom[i][j+1];
						wall=(i+1)+" "+(j+1)+" E";
					}
				}
				

				
				
				if(j-1>=0&&castle[i][j][0]==1&&room.get(i*width+j)!=room.get((i)*width+j-1)){
					if(castleroom[i][j]+castleroom[i][j-1]>mergearea){
						mergearea=castleroom[i][j]+castleroom[i][j-1];
						wall=(i+1)+" "+(j)+" E";
					}
				}
				

				
				
			}
		}

		//System.out.println(rooms);
		//System.out.println(maxarea);
		//System.out.println(mergearea);
		//System.out.println(wall);
		out.println(rooms);
		out.println(maxarea);
		out.println(mergearea);
		out.println(wall);
		out.close();
	}
}
