import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static StringTokenizer st;
    static List<String[]> s = new ArrayList<>();
    static int result;
    static List<String> list;
    static Set<String> set = new HashSet<>();
    static Set<String> calSet = new HashSet<>();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i++){
            s.add(br.readLine().split(""));
        }
        
        set.add("a");
        set.add("n");
        set.add("t");
        set.add("i");
        set.add("c");
        K -= 5;
        
        if(K<0){
            System.out.print("0");
            return;
        }
        
        list = new ArrayList<>();
        Set<String> listSet = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            for(String t : s.get(i)){
                if(!set.contains(t) && !listSet.contains(t)){
                    list.add(t);
                    listSet.add(t);
                }
            }
        }

        K = Math.min(list.size(),K);
        
        recur(0,0);
        
        System.out.print(result);
    }
    
    public static void recur(int prev,int depth){
        if(depth == K){
            
            result = Math.max(result,cal());
            return;
        }
        
        for(int i = prev ; i < list.size() ; i++){
            calSet.add(list.get(i));
            recur(i+1,depth+1);
            calSet.remove(list.get(i));
        }
    }
    
    public static int cal(){
        int ans = 0;
        
        for(int i = 0 ; i < N ; i++){
            boolean pass = true;
            for(String t : s.get(i)){
                if(!set.contains(t) && !calSet.contains(t)){
                    pass = false;
                    break;
                }
            }
            
            if(pass) {
                ans++;
            } 
            
        }

        return ans;
    }
}