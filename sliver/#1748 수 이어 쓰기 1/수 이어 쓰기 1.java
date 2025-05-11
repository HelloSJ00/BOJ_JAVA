import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 1 ; i <= N ; i++){
            if(i<10) answer += 1;
            else if(i < 100) answer+=2;
            else if(i < 100_0) answer += 3;
            else if(i < 100_00) answer += 4;
            else if(i < 100_000) answer += 5;
            else if(i < 100_000_0) answer += 6;
            else if(i < 100_000_00) answer += 7;
            else if(i < 100_000_000) answer += 8;
            else answer += 9;
        }
        System.out.print(answer);
    }
}