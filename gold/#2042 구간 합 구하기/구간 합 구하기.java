import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int K;
    
    static long[] arr ;
    static long[] originArr;
    static long ans = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   
        
        originArr = new long[N];
        for(int i = 0 ; i < N ; i ++){
            originArr[i] = Long.parseLong(br.readLine());
        }
        arr = new long[4*N];
        
        build(0,N-1,1);
        
        for(int i = 0 ; i < M+K ; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("1")){
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(1,N,1,b,c);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                ans = 0;
                getSum(1,N,1,b,c);
                sb.append(ans+"\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    public static void build(int s,int e,int node){
        if(s == e){
            arr[node] = originArr[s];
            return;
        }
        
        int mid = (s+e)/2;
        build(s,mid,node*2);
        build(mid+1,e,node*2+1);
        
        arr[node] = arr[node*2]+arr[node*2+1];
    }
    
    public static void update(int s,int e,int node,int b,long c){
        if(s > b || e < b) return;
        
        if(s==e){
            arr[node] = c;
            return;
        }
        
        int mid = (s+e)/2;
        update(s,mid,node*2,b,c);
        update(mid+1,e,node*2+1,b,c);
        
        arr[node] = arr[node*2] + arr[node*2+1];
    }
    
    public static void getSum(int s, int e ,int node ,int b,int c){
        if(s > c || e < b) return;
        if(s>=b && e <= c){
            ans += arr[node];
            return;
        }
        
        int mid = (s+e)/2;
        getSum(s,mid,node*2,b,c);
        getSum(mid+1,e,node*2+1,b,c);
    }
}