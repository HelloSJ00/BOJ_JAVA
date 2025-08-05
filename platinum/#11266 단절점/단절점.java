import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V;
    static int E;
    static List<List<Integer>> g = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int time;
    static int[] disc; // DFS 탐색 시작 시간 (discovery time)
    static int[] low; // 도달 가능한 가장 낮은 discovery time
    static boolean[] isArticulationPoint; // 단절점 여부
    
    public static void main(String[] args) throws Exception{
        st =  new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        disc = new int[V + 1];
        low = new int[V + 1];
        isArticulationPoint = new boolean[V + 1];

        for(int i = 0 ; i <= V ; i ++){
            g.add(new ArrayList<>());
        }

        for(int i = 0 ; i < E ; i ++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }

        // 모든 정점을 순회하며 단절점 찾기
        // 연결되지 않은 그래프일 수 있으므로 모든 정점에서 시작
        for (int i = 1; i <= V; i++) {
            if (disc[i] == 0) { // 아직 방문하지 않은 정점이라면
                dfs(i, 0, true); // 0은 부모가 없음을 의미, isRoot는 true
            }
        }


        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (isArticulationPoint[i]) {
                result.add(i);
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (int ap : result) {
            sb.append(ap).append(" ");
        }

        System.out.println(sb.toString());
    }

static void dfs(int cur, int parent, boolean isRoot) {
        disc[cur] = low[cur] = ++time;
        int childCount = 0;

        for (int next : g.get(cur)) {
            if (next == parent) {
                continue; // 부모 노드는 무시
            }

            if (disc[next] != 0) { // 이미 방문한 정점 (역방향 간선)
                low[cur] = Math.min(low[cur], disc[next]);
            } else { // 아직 방문하지 않은 정점 (트리 간선)
                childCount++;
                dfs(next, cur, false);

                // 자식 노드의 탐색이 끝난 후 low 값 갱신
                low[cur] = Math.min(low[cur], low[next]);

                // 단절점 판별
                if (isRoot && childCount > 1) { // 1. 루트 노드 조건
                    isArticulationPoint[cur] = true;
                } else if (!isRoot && low[next] >= disc[cur]) { // 2. 일반 노드 조건
                    isArticulationPoint[cur] = true;
                }
            }
        }
    }
}