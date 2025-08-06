import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static int[][][] parent;
    static int[] depth = new int[100_001];

    // 좌표압축
    static Set<Integer> set = new HashSet<>();
    static List<int[]> edges = new ArrayList<>();
    static List<List<int[]>> g = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <= 100_001 ; i ++){
            g.add(new ArrayList<>());
        }

        int LOGN = 1;
        while(N > Math.pow(2,LOGN)) LOGN++;

        // System.out.println(LOGN);
        int root = 0;
        parent = new int[LOGN+1][100_001][3];
        for(int i = 0 ; i < N - 1 ; i ++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(i == 0){
                root = A;
            }
            set.add(A);
            set.add(B);

            g.get(A).add(new int[]{B,C});
            g.get(B).add(new int[]{A,C});
        }

        makeTree(root);
        // System.out.println(Arrays.toString(depth));


        for(int i = 1 ; i < LOGN ; i++){
            for(int v : set){
                if(depth[v] - (1<<i) >= 0){
                    parent[i][v] = new int[]{
                    parent[i-1][parent[i-1][v][0]][0],
                    Math.max(parent[i-1][v][1],parent[i-1][parent[i-1][v][0]][1]),
                    Math.min(parent[i-1][v][2],parent[i-1][parent[i-1][v][0]][2])
                    };
                    // System.out.println(i+"열 "+ v+"행 " + Arrays.toString(parent[i][v]));
                }
                
            }
        }

        K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K ; i ++){
            // System.out.println("-  " + (i+1));
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;


            if(depth[E] < depth[D]){
                int tmp = D;
                D = E;
                E =tmp;
            } 

            int cE = E;
            int cD = D;

            // 높이 맞추기

            for (int k = LOGN; k >= 0; k--) {
            if (depth[cE] - (1 << k) >= depth[cD]) {
                max = Math.max(max, parent[k][cE][1]);
                min = Math.min(min, parent[k][cE][2]);
                cE = parent[k][cE][0];
            }
        }
            int jmp = 0;

            if(cE != cD){
                for(int j = LOGN ; j >= 0 ; j--){
                    if(parent[j][cE][0] != parent[j][cD][0]){
                        max = Math.max(max,Math.max(parent[j][cE][1],parent[j][cD][1]));
                        min = Math.min(min,Math.min(parent[j][cE][2],parent[j][cD][2]));

                        cE = parent[j][cE][0];
                        cD = parent[j][cD][0];
                    }
                }
                max = Math.max(max,Math.max(parent[0][cE][1],parent[0][cD][1]));
                min = Math.min(min,Math.min(parent[0][cE][2],parent[0][cD][2]));
            }





            sb.append(min + " " + max+"\n");
        }

        System.out.println(sb.toString());
    }

    static void makeTree(int root){
        boolean[] visit = new boolean[100_001];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(root);
        parent[0][root] = new int[]{0,Integer.MIN_VALUE,Integer.MAX_VALUE};
        depth[root] = 0;
        visit[root] = true;

        while(!q.isEmpty()){
            int cur = q.poll(); 
            // System.out.println("cur " + cur);

            for(int[] next : g.get(cur)){
                // System.out.println(Arrays.toString(next));
                if(!visit[next[0]]){
                    visit[next[0]] = true;
                    depth[next[0]] = depth[cur] + 1;
                    // 부모, 부모까지 최대였던 거리, 부모까지 최소였던 거리 
                    parent[0][next[0]] = new int[]{cur,next[1],next[1]};
                    q.offer(next[0]);
                }
            }
        }
    }
}