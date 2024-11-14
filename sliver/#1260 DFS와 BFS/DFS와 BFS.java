import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) { // 0번 인덱스는 사용하지 않고 1번부터 N번까지 사용
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i< M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// System.out.println(graph);
    // 각 정점에 연결된 인접 리스트를 정렬
    for (ArrayList<Integer> adjList : graph) {
			Collections.sort(adjList); // 오름차순 정렬
		}
		// System.out.println(graph);
		ArrayList<Integer> resultDfs = dfs(N,graph,V);
		for (int num : resultDfs){
			sb.append(num).append(" ");
		}
		sb.append("\n");
		ArrayList<Integer> resultBfs = bfs(N,graph,V);
		for (int num : resultBfs){
			sb.append(num).append(" ");
		} 
		System.out.println(sb);
	}

	static ArrayList<Integer> bfs(int N,ArrayList<ArrayList<Integer>> graph,int V){
		int[] visit = new int[N+1];
		ArrayList<Integer> result = new ArrayList<>(); // 방문 순서를 기록할 변수
		Queue<Integer> queue = new LinkedList<>(); // 올바른 Queue 생성 방식

		queue.add(V);
		while(!queue.isEmpty()){
			int node = queue.poll();
			if(visit[node]==0)result.add(node);
			visit[node] = 1;
			for (int adjacent : graph.get(node)){
				if (visit[adjacent] == 0){
					queue.add(adjacent);
				}
			}
		}
		return result;
	} 

	static ArrayList<Integer> dfs(int N,ArrayList<ArrayList<Integer>> graph,int V){
		int[] visit = new int[N+1];
		ArrayList<Integer> result = new ArrayList<>(); // 방문 순서를 기록할 변수
		Stack<Integer> stack = new Stack<>();

		stack.push(V);
		while(!stack.isEmpty()){
			int node = stack.pop();
			if(visit[node]==0) result.add(node);
			visit[node] = 1;
			for (int i = graph.get(node).size() - 1; i >= 0; i--) {
				int adjacent = graph.get(node).get(i);
				if (visit[adjacent] == 0){
					stack.push(adjacent);
				}
			}
		}
		return result;
	}
}