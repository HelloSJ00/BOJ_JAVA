import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<List<Integer>> g1 = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[][] parent;
    static int[] depth;
    static int LOGN;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        LOGN = (int) Math.ceil(Math.log(N) / Math.log(2));
        for(int i = 0 ; i <= N ; i ++){
            g1.add(new ArrayList<>());
        }

        parent = new int[LOGN+1][N+1];
        depth = new int[N+1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g1.get(a).add(b);
            g1.get(b).add(a); // 양방향으로 연결
        }

        // DFS를 통해 depth와 parent[0] 초기화
        // 1번 노드를 루트, 부모는 0, 깊이는 0으로 시작
        dfs(1, 0, 0);
        // 조상 저장
        for(int i = 1 ; i <= LOGN ; i++){
            for(int j = 1 ; j <= N ; j++){
                    parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        // for(int i = 0 ; i <= LOGN ; i++){
        //     System.out.println(Arrays.toString(parent[i]));
        // }
        
        M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            findLCA(a,b);
        }

        System.out.println(sb.toString());

    }
    static void dfs(int u, int p, int d) {
        depth[u] = d;
        parent[0][u] = p;

        for (int v : g1.get(u)) {
            if (v != p) { // 부모 노드는 다시 방문하지 않도록
                dfs(v, u, d + 1);
            }
        }
    } 

// 3. 두 노드의 LCA 찾기
    public static void findLCA(int u, int v) {
        // 깊이 맞추기
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // 깊이 차이만큼 2^k 점프로 u를 v와 같은 깊이로 올림
        for (int k = LOGN; k >= 0; k--) {
            if (depth[u] - (1 << k) >= depth[v]) {
                u = parent[k][u];
            }
        }

        if(u==v){
            sb.append(u).append("\n");
            return;
        }

              // 공통 조상 직전까지 동시에 점프
        for (int k = LOGN; k >= 0; k--) {
            // 부모가 서로 다르면 안전하게 점프
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        sb.append(parent[0][u]).append("\n");
    }
}