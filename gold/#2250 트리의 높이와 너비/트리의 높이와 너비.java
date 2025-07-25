import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    // L child num, R child num, L tree 노드 개수, R tree 노드 개수, 레벨, 인덱스 , 부모
    static int[][] arr = new int[10001][7];
    static int maxLevel = 1;
    static int[][] ans;
    
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int self = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            arr[self] = new int[]{left,right,0,0,0,0,-1};
        }
        int root = findRoot();

        setTree(root,1);
        setIndex(root,0);
        
        ans = new int[maxLevel+1][2];
        for(int i = 1; i <= maxLevel; i++){
            ans[i] = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        
        getAns(root);
        int ansLevel = 0;
        int ansWidth = 0;
        
        for(int i = 1 ; i <= maxLevel;i++){
            if(ansWidth < ans[i][1] - ans[i][0] + 1){
                ansWidth = ans[i][1] - ans[i][0] + 1;
                ansLevel = i;
            }
        }

        // for(int i = 1 ; i <= maxLevel;i++){
        //     System.out.println(i+"레벨 : "+Arrays.toString(ans[i]));
        // }
        // System.out.println("d");

        // for(int i =1 ; i <= N ; i++){
        //     System.out.println(i+"노드: "+Arrays.toString(arr[i]));
        // }
        System.out.println(ansLevel+" "+ansWidth);
    }
    
    public static int findRoot(){
        for(int i = 1 ; i <= N ; i++){
            int left = arr[i][0];
            int right = arr[i][1];

            if(left != -1){
                arr[left][6] = i;
            }

            if(right != -1){
                arr[right][6] = i;
            }
        }

        for(int i = 1 ; i <= N ; i++){
            if(arr[i][6] == -1){
                return i;
            }
        }
        return 1;
    }
    public static int setTree(int cur,int curLevel){
        maxLevel = Math.max(curLevel,maxLevel);
        arr[cur][4] = curLevel;
        int child = 0;
        if(arr[cur][0] != -1){
            arr[cur][2] = setTree(arr[cur][0],curLevel+1);
            child += arr[cur][2];
        }
        
        if(arr[cur][1] != -1){
            arr[cur][3] = setTree(arr[cur][1],curLevel+1);
            child += arr[cur][3];
        }
        return child + 1;
    }
    
    public static void setIndex(int cur,int parentIdx){
        int left = arr[cur][0];
        int right = arr[cur][1];
        
        if(left != -1){
            arr[left][5] = parentIdx - arr[left][3] -1;
            
            setIndex(left,arr[left][5]);
        }
        
        if(right != -1){
            arr[right][5] = parentIdx + arr[right][2] + 1;
            setIndex(right,arr[right][5]);
        }        
    }
    
    public static void getAns(int cur){
        int level = arr[cur][4];
        // System.out.println("현재 " + level + "단계 조정중");
        ans[level][0] = Math.min(ans[level][0],arr[cur][5]);
        ans[level][1] = Math.max(ans[level][1],arr[cur][5]);
        
        int left = arr[cur][0];
        int right = arr[cur][1];
        
        if(left != -1){
            getAns(left);
        }
        
        if(right != -1){
            getAns(right);
        }
    }
}