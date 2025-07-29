import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long X;
    static long Y;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        
        int cur_z = percent(X,Y);
        
        if(cur_z >= 99 || X==Y){
            System.out.print(-1);
        } else {
            int s = 0;
            int e = Integer.MAX_VALUE;
            
            int mid=0;
            while(s<e){
                mid = (s+e)/2;
                
                if(percent(X+mid,Y+mid) > cur_z){
                    e = mid;
                } else{
                    s = mid + 1;
                }
            }
            
            System.out.print(e);
        }
        
    }
    
    public static int percent(long x,long y){
        return (int)(y*100/x);
    }
}