import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->-a[1])
																									.thenComparingInt(a->-a[0]));
		for(int i = 0 ;i < N ; i ++){
			st = new StringTokenizer(br.readLine());

			int[] tmp = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			pq.offer(tmp);
		}

		int[] prev = pq.poll();
		int answer = prev[1]-prev[0];
		while(!pq.isEmpty()){
			int[] cur = pq.poll();

			if(prev[0] > cur[1]){
				answer += cur[1] - cur[0];
			} else if(cur[0] > prev[0]){
				continue;
			} else {
				answer += cur[1] - cur[0] - (cur[1]-prev[0]);
			}

			prev = cur;
		}

		System.out.println(answer);
	}
}
