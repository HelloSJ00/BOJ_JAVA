import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> edges= new ArrayList<>();
    static int N;
    static int M;
    static int[] parent;
    static int root =0;
    static int total = 0;

    static StringBuilder sb = new StringBuilder();

    // 크루스칼 알고리즘 (유니온 파인드)
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1 ; i <= N ; i ++){
            parent[i] = i;
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new int[]{a,b,c,});
        }
        Collections.sort(edges,Comparator.<int[]>comparingInt(a->a[2]));

        for(int[] cur : edges){
            int parent_a = findParent(cur[0]);
            int parent_b = findParent(cur[1]);
            if(parent_a != parent_b){
                union(parent_a,parent_b);
                total += cur[2];
            }
        }

        System.out.println(total);
    }

    static int findParent(int a){
        if(parent[a] != a) return findParent(parent[a]);
        else return a;
    }

    static void union(int A,int B){
        if(A>B){
            parent[A] = B;
        } else {
            parent[B] = A;
        }
    }

    // 프림 알고리즘 
}