package usaco;
/*
ID: xiny.d1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String,String> num2let=new HashMap<String,String>();
		
		num2let.put("A", "2");
		num2let.put("B", "2");
		num2let.put("C", "2");
		
		
		num2let.put("D", "3");
		num2let.put("E", "3");
		num2let.put("F", "3");
		
		num2let.put("G", "4");
		num2let.put("H", "4");
		num2let.put("I", "4");
		
		num2let.put("J", "5");
		num2let.put("K", "5");
		num2let.put("L", "5");
		
		num2let.put("M", "6");
		num2let.put("N", "6");
		num2let.put("O", "6");
		
		num2let.put("P", "7");
		num2let.put("R", "7");
		num2let.put("S", "7");
		
		num2let.put("T", "8");
		num2let.put("U", "8");
		num2let.put("V", "8");
		
		num2let.put("W", "9");
		num2let.put("X", "9");
		num2let.put("Y", "9");
		
		BufferedReader f=new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		
		BufferedReader dictionary=new BufferedReader(new FileReader("dict.txt"));
		ArrayList List=new ArrayList();
		String word="";
		
		while((word=dictionary.readLine()) != null){
			List.add(word);
		}
		
		String num=f.readLine();
		
		Integer length=num.length();
		
		ArrayList wordsfilter=new ArrayList();
		for(int i=0;i<List.size();i++){
			
			String dict=(String)List.get(i);
			if(dict.length()!=length)continue;
			
			Boolean accept=true;
			
			String trans="";
			
			for(int j=0;j<length;j++){
				String letter=""+dict.charAt(j);
				letter=num2let.get(letter);
				trans=trans+letter;
			}
			
			if(trans.equals(num)){
				wordsfilter.add(dict);
			}
			
			
		}
		
		for(int j=0;j<wordsfilter.size();j++){
			System.out.print(wordsfilter.get(j));
			out.println(wordsfilter.get(j));
			
		}
		if(wordsfilter.size()==0){
			out.println("NONE");
		}
		
		
		out.close();
		
	}

}
