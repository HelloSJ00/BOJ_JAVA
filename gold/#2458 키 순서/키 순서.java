import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<List<Integer>> g1 = new ArrayList<>();
    // 반대
    static List<List<Integer>> g2 = new ArrayList<>();
    static int[] parent;
    static int[] child;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <= N ; i++){
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }


        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g1.get(a).add(b);
            g2.get(b).add(a);
        }

        parent = new int[N+1];
        child = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            visit = new boolean[N+1];
            visit[i] = true;
            parent[i] = getParent(i)-1;
            visit = new boolean[N+1];
            visit[i] = true;
            child[i] = getChild(i)-1;
        }

        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(child));

        int result = 0;
        for(int i = 1 ; i <= N ; i ++){
            if(parent[i]+child[i] == N-1){
                result++;
            }
        }

        System.out.print(result);
    }

    static int getParent(int x){
        int cnt = 1;
        for(int p : g1.get(x)){
            if(!visit[p]) {
                cnt+=getParent(p);
                visit[p] = true;
            }
        }
        return cnt;
    }

    static int getChild(int x){
        int cnt = 1;
        for(int c : g2.get(x)){
            if(!visit[c]) {
                cnt+=getChild(c);
                visit[c] = true;
            }
        }
        return cnt;
    }
}