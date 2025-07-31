import java.io.*;
import java.util.*;

class Tree{
    Node root = null;
}

class Node{
    int value;
    Node l;
    Node r;

    Node(int v){
        this.value = v;
    }
}
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> dq = new ArrayDeque<>();
    static Tree tree = new Tree();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args ) throws Exception{
    
        while(true){
            try{
                dq.offer(Integer.parseInt(br.readLine()));
            } catch (Exception e){
                break;
            } 
        }


        while(!dq.isEmpty()){
            if(tree.root == null){
                tree.root = new Node(dq.poll());
                continue;
            }

            put(tree.root,dq.poll());
        }

        postOrder(tree.root);

        System.out.println(sb.toString());
    }

    public static void put(Node n,int v){
        if(n.value > v){
            if(n.l != null){
                put(n.l,v);
            } else {
                n.l = new Node(v);
                // System.out.println(n.l.value);
            }
        } else {
            if(n.r != null){
                put(n.r,v);
            } else {
                n.r = new Node(v);
                // System.out.println(n.r.value);
            }
        }
    }

    public static void postOrder(Node n){
        if(n == null) return;

        postOrder(n.l);

        postOrder(n.r);

        sb.append(n.value+"\n");
    }
}