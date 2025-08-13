import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        long sum = 1;
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] arr = new long[100_001];

        arr[1] = A%C;
        for(int i = 2 ; i <= 100_000 ; i++){
            arr[i] = (arr[i-1]*A)%C;
        }

        while(B != 0){
            if(B > 100_000){
                sum *= (long)arr[100_000];
                sum = sum%C;
                B -= 100_000;
            } else {
                sum *= (long)arr[(int)B];
                sum = sum%C;
                B=0;
            }
        }

        System.out.print(sum);
    }
}