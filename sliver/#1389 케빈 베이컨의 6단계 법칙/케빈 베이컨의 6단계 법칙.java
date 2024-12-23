import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numOfUser = Integer.parseInt(st.nextToken());
		int numOfEdge = Integer.parseInt(st.nextToken());

		List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < numOfUser+1 ; i++){
			adjList.add(new ArrayList<>());
		} 

		for(int i = 0; i < numOfEdge ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		int[] result = new int[numOfUser+1];
		int answer = 0;
		int answerNum = Integer.MAX_VALUE;
		for (int i = 1;i<numOfUser+1;i++){
			result[i] = dijkstra_kevin_bacon(i, numOfUser, adjList);
		}

		for (int i = 1;i<numOfUser+1;i++){
			// System.out.println(result[i]);
			if (result[i] < answerNum){
				answer = i;
				answerNum = result[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		System.out.print(sb);
	}

	static int dijkstra_kevin_bacon(int startUser,int numOfUser,List<List<Integer>> adjList){
		int[] distance = new int[numOfUser+1];
		// 무한 값으로 배열 채우기
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[startUser] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.add(new int[]{0,startUser});

		while (!pq.isEmpty()){
			int[] cur = pq.poll();
			int currentDistance = cur[0];
			int currentVertex = cur[1];

			if (currentDistance > distance[currentVertex]) continue;

			for(int neigbor : adjList.get(currentVertex)){
				int newDistance = currentDistance + 1;
				if(newDistance < distance[neigbor]){
					distance[neigbor] = newDistance;
					// System.out.println("add");
					pq.add(new int[]{newDistance,neigbor});
				}
			}
		}
		int kevin_bacon = 0;
		for(int d : distance ){
			if (d != Integer.MAX_VALUE){
				kevin_bacon += d;
			}
		}
		return kevin_bacon;
	}

}