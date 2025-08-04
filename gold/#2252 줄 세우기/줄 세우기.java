import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= N ; i++){
            list.add(new ArrayList<>());
        }

        arr = new int[N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            arr[b]++;
        }
        // System.out.println(Arrays.toString(arr));
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= N ; i++){
            if(arr[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            sb.append(cur).append(" ");

            for(int next : list.get(cur)){
                arr[next]--;
                if(arr[next] == 0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }  
}