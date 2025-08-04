import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        Arrays.fill(nums,-1);
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(nums[a] == -1){
                nums[a] = a;
            }

            if(nums[b] == -1){
                nums[b] = b;
            }

            if(cmd == 1){
                find(a,b);
            } else {
                union(a,b);
            }
        }
        // System.out.println(Arrays.toString(nums));
    }

    public static void union(int a,int b){
        int A = findParent(a);
        int B = findParent(b);

        if(A!=B){
            if(A>B) {
                nums[B] = A;
            }
            else {
                nums[A] = B;
            }
        }
    }

    public static int findParent(int a){
        if(nums[a] != a) return findParent(nums[a]);
        else return a;
    }

    public static void find(int a,int b){
        if(findParent(a) == findParent(b)){

            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


}