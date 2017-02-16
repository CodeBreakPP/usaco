/*
ID: xiny.d1
LANG: JAVA
TASK: ariprog
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ariprog{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
	    int N = Integer.parseInt(st.nextToken());    // first integer
	    st = new StringTokenizer(f.readLine());
	    int M = Integer.parseInt(st.nextToken());    // first integer
		
	    Set<Integer> si=new HashSet<Integer>();
	    
		for(int i=0;i<=M;i++){
			for(int j=i;j<=M;j++){
				si.add(i*i+j*j);	
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(si);
		Collections.sort(list);   
		
		Integer min=list.get(0);
		Integer max=list.get(list.size()-1);
		Integer biggap=(max-min)/(N-1);
		ArrayList<int[]> output=new ArrayList<int[]>();
		
		
		for(int i=0;i<list.size();i++){
			for(int j=i+1;j<list.size();j++){
				int gap=list.get(j)-list.get(i);
				if(gap>biggap)break;
				
				int nexi=list.get(j)+gap;
				Boolean judge=true;
				
				for(int k=2;k<N;k++){
					if(!si.contains(nexi)){
						judge=false;
						break;
					}
					nexi+=gap;
				}
				if(judge){
					int[] a={list.get(i),gap};
					output.add(a);
				}
			}		
		}
		
		Collections.sort(output, new Comparator<int[]>(){  
            @Override  
            public int compare(int[] b1, int[] b2) {  
                if(b1[1]!=b2[1]){
                	return b1[1]-b2[1];
                }else{
                	return b1[0]-b1[0];
                }
            }       
        });
		if(output.size()==0){
			out.println("NONE");
		}
		
		for(int k=0;k<output.size();k++){
			out.println(output.get(k)[0]+" "+output.get(k)[1]);
		}
		out.close();
	}
	
}