import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] tree = new long[4*1_000_000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;  

        String A;
        int C;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();

            if(A.equals("1")){
                long B = Long.parseLong(st.nextToken());
                findB(0,1_000_000,1,B);

            } else {
                int B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                update(0,1_000_000,B,C,1);
            }
        }

        System.out.print(sb.toString());
    }

    public static void update(int s, int e,int k, int numOfk,int node){
        if(k < s || e < k ) return;

        if(s==e){
            tree[node]+= numOfk;
            return;
        }

        int mid = (s+e)/2;
        update(s,mid,k,numOfk,node*2);
        update(mid+1,e,k,numOfk,node*2+1);

        tree[node] = tree[node*2]+tree[node*2+1];
    }
    
    public static void findB(int s, int e,int node, long B){
        if(s==e){
            sb.append(s+"\n");
            tree[node]--;
            // System.out.println("");
            return;
        }

        int mid = (s+e)/2;
        if(B <= tree[node*2]){
            findB(s,mid,node*2,B);
        } else {
            findB(mid+1,e,node*2+1,B-tree[node*2]);
        }

        tree[node] = tree[node*2]+tree[node*2+1];
    }
}