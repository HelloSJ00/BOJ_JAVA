import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static Map<Integer,Integer> tl = new HashMap<>();
    static int[] arrivedTime;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arrivedTime = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tlSize = 0;

        for(int i = 0 ; i < K ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            // System.out.println(tlSize);

            if(!tl.containsKey(tmp)){
                if(tlSize == N){
                    tl.remove(getTail());
                    tlSize--;
                }
                tl.put(tmp,0);
                arrivedTime[tmp] = i;
                tlSize++;
            } else if(tl.containsKey(tmp)){
                tl.put(tmp,tl.get(tmp)+1);
            }
            
        }

        List<Integer> l = new ArrayList<>();
        for(int t : tl.keySet()){
            l.add(t);
        }

        Collections.sort(l);
        for(int i : l){
            System.out.print(i+" ");
        }
    }
    
    public static int getTail(){
        int ans = 0 ;
        int vote = Integer.MAX_VALUE;

        for(int k : tl.keySet()){
            if(tl.get(k) < vote){
                ans = k;
                vote = tl.get(k);
            } else if(tl.get(k) == vote){
                if(arrivedTime[ans] > arrivedTime[k]){
                    ans = k;
                }
            }
        }
        // System.out.println("tail : " + ans);
        return ans;
    }
}