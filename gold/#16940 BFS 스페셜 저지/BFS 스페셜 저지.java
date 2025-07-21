import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> g = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static int[] findArr;
    static boolean[] visit;
    static int N;
    static int pointer = 1;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
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
        
        findArr = new int[N+1];
        visit = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++ ){
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(isBfs()) System.out.print("1");
        else System.out.print("0");
        
    } 
    
    public static boolean isBfs(){
        q.add(1);
        visit[1] = true;
        Set<Integer> s;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            s = new HashSet<>();
            
            int child = 0;
            for(int i : g.get(cur)){
                if(!visit[i]) {
                    child ++;
                    s.add(i);
                }
            }
            
            
            for(int i = pointer + 1 ; i <= pointer + child ; i++){
                if(!s.contains(findArr[i]) || visit[findArr[i]]) return false;
                q.add(findArr[i]);
                visit[findArr[i]] = true;
            }
            
            pointer += child;
        }
        return true;   
    }
}