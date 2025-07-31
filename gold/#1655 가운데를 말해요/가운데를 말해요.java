import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int offset = 1;
    static long[] tree;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        while(offset < 20001) offset *=2;
        
        tree = new long[2*offset+1];
        // System.out.println("offset: " + offset );
        
        for(int i = 1 ; i <= N ; i++){
            int tmp = Integer.parseInt(br.readLine());
            update(0,20001,tmp+10000,1);

            if(i%2 == 0){
                findMid(0,20001,i/2,1);
            } else {
                findMid(0,20001,i/2+1,1);
            }
            
        }

        System.out.print(sb.toString());
    }
    
    public static void update(int s, int e ,int p,int node){
        if(p < s || e < p) return;
        
        if(s==e) {
            // System.out.println("s: "+s + "\ne:" + e);
            // System.out.println("p: " +p);
            // System.out.println("추가 인덱스 : "+(node));
            // System.out.println("추가 값 : "+ (node - offset) );
            tree[node]++;
            return;
        }
        
        int mid = (int)((s+e)/2);
        update(s,mid,p,node*2);
        update(mid+1,e,p,node*2+1);
        
        tree[node] = tree[node*2] + tree[node*2+1];
    }
    
    public static void findMid(int s ,int e, long k, int node){
        if(s==e){
            // System.out.println(e-10000);
            // System.out.println("중간값: "+(node-offset-10000));
            sb.append((e-10000)+"\n");
            return;
        }
        
        int mid = (s+e)/2;
        if(tree[node*2] >= k){
            findMid(s,mid,k,node*2);
        } else {
            findMid(mid+1,e,k-tree[node*2],node*2+1);
        }
    }
}