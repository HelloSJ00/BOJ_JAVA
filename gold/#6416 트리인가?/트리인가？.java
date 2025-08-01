import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int seq = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        Map<Integer,List<Integer>> tree = new HashMap<>();
        Map<Integer,Integer> parentNum = new HashMap<>();
        Map<Integer,Boolean> visit = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // System.out.println("a :" + a + "\nb : " + b );
                if(a == -1) {
                    System.out.println(sb.toString());
                    return;
                }

                if(a == 0){
                    int root = 0 ;

                    for(int i : set){
                        if(!parentNum.containsKey(i)) {
                            root = i;
                            break;
                        }
                    }
                    // System.out.println("root = " + root);
                    isTree(tree,root,visit,parentNum);
                    tree.clear();
                    visit.clear();
                    parentNum.clear();
                    continue;
                }

                if(tree.containsKey(a)){
                    tree.get(a).add(b);
                } else {
                    tree.put(a,new ArrayList<>());
                    tree.get(a).add(b);
                }

                parentNum.put(b,parentNum.getOrDefault(b,0)+1);
                set.add(a);
                set.add(b);
                
                visit.put(a,visit.getOrDefault(a,false));
                visit.put(b,visit.getOrDefault(b,false));
            }
        }
    }


    public static void isTree(Map<Integer,List<Integer>> tree,int root,Map<Integer,Boolean> visit,Map<Integer,Integer> parentNum){

        // System.out.println(tree);
        // System.out.println(root);
        // System.out.println(visit);
        
        for(int i : parentNum.keySet()){
            if(parentNum.get(i) > 1){
                // System.out.println(i+" parentNum : "+ parentNum.get(i));
                sb.append("Case "+ seq +" is not a tree.\n");
                seq++;
                return;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();

        q.offer(root);
        // System.out.println("root= "+root);
        visit.put(root,true);

        while(!q.isEmpty()){
            int cur = q.poll();
            if(tree.get(cur) == null) continue;
            for(int next : tree.get(cur)){
                if(visit.get(next)){
                    sb.append("Case "+ seq +" is not a tree.\n");
                    seq++;
                    return;
                } else {
                    visit.put(next,true);
                    q.add(next);
                }
            }
        }

        for(int node : visit.keySet()){
            if(!visit.get(node)){
                // System.out.println(node);
                sb.append("Case "+ seq +" is not a tree.\n");
                seq++;
                return;
            }
        }

        sb.append("Case "+ seq +" is a tree.\n");
        seq++;

    }
}