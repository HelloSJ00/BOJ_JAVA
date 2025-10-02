import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int day = 0;
		int pt = 0;

		while(K != 0){
			// System.out.println(pt);
			if(pt == N - A){
				K+=B;
				pt = 0;
			} else{
				pt+=A;
			}

			K--;
			day++;
		}

		System.out.println(day);
	}
}