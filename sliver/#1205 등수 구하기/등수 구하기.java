import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[][] map ;
	static int N;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int point = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] rank = new int[P+1];
		Arrays.fill(rank,-1);
		rank[0] = Integer.MAX_VALUE;

		if(N > 0){
				st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N ;i++){
				rank[i] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = P ; i >= 0 ; i--){
			if(rank[i] == -1 || rank[i] <= point) continue;
			else if(rank[i] > point ){
				if(rank[P] == point || i == P) System.out.println(-1);
				else System.out.println(i+1);
				return;
			}
		}
	}
}