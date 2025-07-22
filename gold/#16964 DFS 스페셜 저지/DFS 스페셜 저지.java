import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] findArr;
    static boolean[] visit;
    static Stack<Integer> s = new Stack<>();
    static int pointer = 1;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        findArr = new int[N+1];
        visit = new boolean[N+1];
        visit[1] = true;
        for(int i = 0 ; i <= N ; i++){
            g.add(new ArrayList<>());
        }
        
        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(isDfs(1)) System.out.print("1");
        else System.out.print("0");
    }
    
    public static boolean isDfs(int cur){
        pointer++;
        
        Set<Integer> set = new HashSet<>();
        int child = 0;
        for(int n : g.get(cur)){
            if(!visit[n]){
               child ++;
               set.add(n);
               visit[n] = true;
            } 
        }
        
        for(int i = 0 ; i < child ; i++){
            if(!set.contains(findArr[pointer])) return false;
            else{
                if(!isDfs(findArr[pointer])) return false; 
            }
        }
     
        return true;
    }
}