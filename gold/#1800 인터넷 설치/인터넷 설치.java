import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, P, K;
    static List<List<int[]>> g = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) g.add(new ArrayList<>());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[]{b, c});
            g.get(b).add(new int[]{a, c});
        }

        int l = 0, r = 1_000_000, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (canReach(mid)) { // mid 이하의 간선으로만, 혹은 K개 초과는 무료
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean canReach(int limit) {
        int[] used = new int[N + 1]; // 각 노드까지 무료도로 사용 개수
        Arrays.fill(used, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 
        // [노드, 무료도로 사용횟수]

        pq.offer(new int[]{1, 0});
        used[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int freeUsed = cur[1];

            if (used[node] < freeUsed) continue;
            if (node == N) return true;

            for (int[] next : g.get(node)) {
                int nextNode = next[0];
                int w = next[1];
                int nextFree = freeUsed + (w > limit ? 1 : 0);

                if (nextFree < used[nextNode] && nextFree <= K) {
                    used[nextNode] = nextFree;
                    pq.offer(new int[]{nextNode, nextFree});
                }
            }
        }
        return false;
    }
}