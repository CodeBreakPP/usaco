/*
ID: xiny.d1
LANG: JAVA
TASK: prefix
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

public class prefix {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Date date = new Date();
		BufferedReader f=new BufferedReader(new FileReader("prefix.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		
		HashSet<String> hm=new  HashSet<String>();
		HashSet<String> posfix=new  HashSet<String>();
		
		String nextst=f.readLine();
		int llong=0;
		while(!nextst.equals(".")){
			StringTokenizer st = new StringTokenizer(nextst);
			while(st.hasMoreTokens()){
				String nt=st.nextToken();
				hm.add(nt);
			}
			nextst=f.readLine();
		}
		
		
		for(String h:hm){
			if(h.length()>llong)llong=h.length();
			for(int i=1;i<h.length();i++){
				posfix.add(h.substring(h.length()-i, h.length()));
			}
		}
		
		Date date2 = new Date();
		System.out.println((date2.getTime()-date.getTime())/1000.0);
		
		String s="";
		
		String nexts=f.readLine();
		
		while(nexts!=null){
			s=s.concat(nexts);
			nexts=f.readLine();
		}
		//System.out.println(s);
		
		

		Boolean[] dp=new Boolean[s.length()];
		int lon=0;		
		
		int continuefalse=0;

		
		for(int i=0;i<s.length();i++){
			dp[i]=false;
			String item="";
			
			for(int j=0;j<llong&&(i-j>=0);j++){
				//item=s.substring(i-j,i+1);
				item=s.charAt(i-j)+item;
				
				if(i-j==0&&hm.contains(item)){
					dp[i]=true;
					break;
				}else if(hm.contains(item)&&(dp[i-j-1])){
					dp[i]=true;
					break;
				}
				if(!posfix.contains(item))break;
				
			}
			
			if(dp[i]){lon=i+1;continuefalse=0;}
			else{continuefalse++;}
			if(continuefalse>llong)break;

			
		}
		out.println(lon);
		System.out.println(lon);
		out.close();
		Date date3 = new Date();
		System.out.println((date3.getTime()-date2.getTime())/1000.0);
	}
}
