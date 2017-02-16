/*
ID: xiny.d1
LANG: JAVA
TASK: heritage
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class heritage {
public static void main(String[] args) throws IOException {
		
		BufferedReader f=new BufferedReader(new FileReader("heritage.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("heritage.out")));
		
		String inorder=f.readLine();
		String preorder=f.readLine();
		
		System.out.println(pos(inorder,preorder));
		out.println(pos(inorder,preorder));
		out.close();
		
}

public static String pos(String ino,String preo){
	
	int len=ino.length();
	
	
	if(len<=1){
		
		return ino;
		
	}else{
		
			char root=preo.charAt(0);
			int index=ino.indexOf(root);
			
			String pre=pos(ino.substring(0,index),preo.substring(1,1+index));
			
			String pos=pos(ino.substring(index+1),preo.substring(1+index));
			
			return pre+pos+root;
	}
	
	
}



}
