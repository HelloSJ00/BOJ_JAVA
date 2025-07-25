import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] tree;
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        tree = new String[N][3];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++ ){
                tree[i][j] = st.nextToken();
            }
            // System.out.println(Arrays.toString(tree[i]));
        }
        
        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");
        System.out.print(sb.toString());
    }
    
    public static void preorder(String s){
        int tmp = 0;
        
        for(int i = 0 ; i < N ; i++){
            if(tree[i][0].equals(s)){
                // System.out.print("발견");
                tmp = i;
                break;
            }
        }
        
        sb.append(s);
        
        if(!tree[tmp][1].equals(".")){
            preorder(tree[tmp][1]);
        } 
        
        if(!tree[tmp][2].equals(".")){
            preorder(tree[tmp][2]);
        }
           
    }
    
    public static void inorder(String s){
        int tmp = 0;
        
        for(int i = 0 ; i < N ; i++){
            if(tree[i][0].equals(s)){
                tmp = i;
                break;
            }
        }

        if(!tree[tmp][1].equals(".")){
            inorder(tree[tmp][1]);
        } 
        
        sb.append(s);
        
        if(!tree[tmp][2].equals(".")){
            inorder(tree[tmp][2]);
        }
    }
    
    public static void postorder(String s){
        int tmp = 0;
        
        for(int i = 0 ; i < N ; i++){
            if(tree[i][0].equals(s)){
                tmp = i;
                break;
            }
        }
        
        
        if(!tree[tmp][1].equals(".")){
            postorder(tree[tmp][1]);
        } 
        
        if(!tree[tmp][2].equals(".")){
            postorder(tree[tmp][2]);
        }
        
        sb.append(s);
    }
}