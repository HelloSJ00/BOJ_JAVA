import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] array = new int[100001];
		for (int i=0; i < array.length ;i++){
			array[i] = Integer.MAX_VALUE;
		}

		dijkstra(array,n);

		System.out.print(array[k]);
	}

	public static void dijkstra(int[] array,int start){
		array[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[]{start,0});

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int curVertex = cur[0];
			int curDistance = cur[1];

			if( 0 <= curVertex - 1 && curVertex -1 < array.length && array[curVertex-1] >= curDistance+1){
				array[curVertex-1] = curDistance+1;
				pq.add(new int[]{curVertex-1,curDistance+1});
			}
			if( 0 <= curVertex + 1 && curVertex +1 < array.length && array[curVertex+1] >= curDistance+1){
				array[curVertex+1] = curDistance+1;
				pq.add(new int[]{curVertex+1,curDistance+1});
			}
			if( 0 <= curVertex*2 && curVertex*2 < array.length && array[curVertex*2] >= curDistance+1){
				array[curVertex*2] = curDistance+1;
				pq.add(new int[]{curVertex*2,curDistance+1});
			}
		}
	}
}