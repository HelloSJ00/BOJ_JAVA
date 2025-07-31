import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args ) throws Exception{
        int total = 0;
        String cur;
        while((cur = br.readLine()) != null){
            total++;
            map.put(cur,map.getOrDefault(cur,0)+1);
        }

        List<String[]> l = new ArrayList<>();

        for(String s : map.keySet()){
            double d = (double)map.get(s) / (double) total * 100;
            String[] tmp = new String[]{s,String.format("%.4f", d)};
            l.add(tmp);
        }

        Collections.sort(l,(a,b)->a[0].compareTo(b[0]));

        for(int i = 0 ; i < l.size();i++){
            sb.append(l.get(i)[0]+" "+l.get(i)[1]+"\n");
        }

        System.out.print(sb.toString());
    }
}