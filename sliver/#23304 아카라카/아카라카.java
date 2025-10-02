import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		String s = br.readLine();
		if(isPen(s)){
			System.out.println("AKARAKA");
		} else {
			System.out.println("IPSELENTI");
		}
	}

	static boolean isPen(String s){
		int length = s.length();
		if(length == 1) return true;

		for(int i = 0 ; i < length/2 ; i++){
			if(s.charAt(i) != s.charAt(length-i-1)) return false;
		}

		return isPen(s.substring(0,length/2));
	}
}