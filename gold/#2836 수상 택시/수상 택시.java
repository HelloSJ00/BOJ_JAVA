import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.<long[]>comparingLong(a->-a[0]).thenComparingLong(a->a[1]));

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a>b){
				pq.offer(new long[]{a,b});
			}
		}
		long answer = M;
		long ss = -1;
		long ee = -1;
		while(!pq.isEmpty()){
			long[] cur = pq.poll();
			// System.out.println(Arrays.toString(cur));
			if(ss == -1){
				ss = cur[0];
				ee = cur[1];
			} else {
				if(ss < cur[1] || cur[0] < ee){
					answer += (ss-ee)*2;
					// System.out.println(answer);
					ss = cur[0];
					ee = cur[1];
				} else {
					ss = Math.max(ss,cur[0]);
					ee = Math.min(ee,cur[1]);
					// System.out.println(ss +" "+ee);
				}
			}
		}
		answer += (ss-ee)*2;


		System.out.println(answer);
	}
}