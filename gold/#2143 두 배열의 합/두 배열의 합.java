import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long T;
    static int N;
    static long[] arr1;
    static int M;
    static long[] arr2;
    static StringTokenizer st;
    static long ans = 0;
    
    public static void main(String[] args) throws Exception{
        T = Long.parseLong(br.readLine());
        
        N = Integer.parseInt(br.readLine());
        arr1 = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr1[i] = Integer.parseInt(st.nextToken())+arr1[i-1];
        }
        
        M = Integer.parseInt(br.readLine());
        arr2 = new long[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M ; i++){
            arr2[i] = Integer.parseInt(st.nextToken())+arr2[i-1];
        }
        
        List<Long> sub1 = new ArrayList<>();
        List<Long> sub2 = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i++){
            for(int j = i+1 ; j <= N ; j++){
                sub1.add(arr1[j]-arr1[i]);
            }
        }
        
        for(int i = 0 ; i < M ; i++){
            for(int j = i+1 ; j <= M ; j++){
                sub2.add(arr2[j]-arr2[i]);
            }
        }
        
        Collections.sort(sub1);
        Collections.sort(sub2);
        // System.out.println(sub1);
        // System.out.println(sub2);
        int p1 = 0;
        int p2 = sub2.size()-1;

        while(p1 < sub1.size() && p2 > -1){
            long sum = sub1.get(p1) + sub2.get(p2);
            if(sum == T){
                // System.out.println("p1 :" + p1 + "\np2 : "+p2);
                int p1Num = 1;
                int p2Num = 1;

                while(p1+p1Num < sub1.size() && sub1.get(p1).equals(sub1.get(p1+p1Num))){
                    p1Num++;
                }

                // System.out.println(sub2.get(p2)==sub2.get(p2-p2Num));
                // System.out.println("p2-p2Num: "+(p2-p2Num));
                while((p2-p2Num) >= 0 && (sub2.get(p2).equals(sub2.get(p2-p2Num)))){
                    p2Num++;
                    // System.out.println("쨔스");
                }

                ans+= (long) p1Num*p2Num;

                p1 += p1Num;
                p2 -= p2Num;

                
            } else if(sum < T){
                p1++;
            } else {
                p2--;
            }
        }
        
        System.out.print(ans);
    }
}