import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int Q;
    static long[] tree = new long[4 * 100_000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            update(0, N - 1, 1, i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            int l = Math.min(x, y);
            int r = Math.max(x, y);

            long cur = getSum(0, N - 1, l, r, 1);
            sb.append(cur).append("\n");

            update(0, N - 1, 1, a, b);
        }

        System.out.print(sb.toString());
    }

    public static void update(int s, int e, int node, int k, int value) {
        if (k < s || e < k) return;

        if (s == e) {
            tree[node] = value;
            return;
        }

        int mid = (s + e) / 2;
        update(s, mid, node * 2, k, value);
        update(mid + 1, e, node * 2 + 1, k, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long getSum(int s, int e, int qs, int qe, int node) {
        if (qe < s || qs > e) return 0;

        if (qs <= s && e <= qe) return tree[node];

        int mid = (s + e) / 2;
        return getSum(s, mid, qs, qe, node * 2) + getSum(mid + 1, e, qs, qe, node * 2 + 1);
    }
}