import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] A;
    static long[] B;
    static long[] C;
    static long[] D;
    static StringTokenizer st;
    
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];

        long ans = 0;
        
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken()); 
            C[i] = Long.parseLong(st.nextToken()); 
            D[i] = Long.parseLong(st.nextToken()); 
        }
        

        long[] AB = new long[N*N];
        int idx = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                AB[idx++] = A[i]+B[j];
            }
        }
        

        long[] CD = new long[N*N];
        idx = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                CD[idx++] = C[i]+D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        // System.out.println(Arrays.toString(AB));
        // System.out.println(Arrays.toString(CD));
        int p1 = 0;
        int p2 = CD.length-1;
        
        while(p1 < N*N && p2 >= 0){
            long sum = AB[p1] + CD[p2];
            // System.out.println("sum" + sum +"\np1 :" + p1 + "\np2 : "+p2);

            if(sum == 0){
                int p1Num = 1;
                int p2Num = 1;
                
                while(p1+p1Num < N*N && AB[p1]==AB[p1+p1Num]){
                    p1Num++;
                }
                
                while(p2-p2Num >= 0 && CD[p2]==CD[p2-p2Num]){
                    p2Num++;
                }
                

                ans+= (long) p1Num*p2Num;
                // System.out.println("ans++ : " + ans);
                p1 += p1Num;
                p2 -= p2Num;
            } else if(sum > 0){
                p2 --;
            } else {
                p1 ++;
            }
        }
        System.out.print(ans);
    }
}