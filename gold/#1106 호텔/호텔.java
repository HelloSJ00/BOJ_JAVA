import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int c;
    static int N;
    static int[][][] dp;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N+1][1100][2];

        list.add(new int[]{0,0});
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new int[]{a,b});
        }

        for(int i = 1 ; i <= N ; i++){
            int[] tmp = list.get(i);
            int curCost = tmp[0];
            int curPeople = tmp[1];
            for(int j = 1 ; j < 1100 ; j++){
                if(j < curPeople) dp[i][j] = new int[]{dp[i-1][j][0],dp[i-1][j][1]};
                else {
                    int[] test1 = Arrays.copyOf(dp[i][j-curPeople],2);
                    int[] test2 = Arrays.copyOf(dp[i-1][j],2);

                    test1[0]+=curCost;
                    test1[1] += curPeople;

                    if(test1[1] > test2[1]){
                        dp[i][j] = test1;
                    } else if( test1[1] == test2[1]){
                        if(test1[0] > test2[0]){
                            dp[i][j] = test2;
                        } else {
                            dp[i][j] = test1;
                        }
                    } else {
                        dp[i][j] = test2;
                    }
                }
            }
        }

        // for(int i = 1 ; i <= N ; i++){
        //     for(int j = 1 ; j <= c ; j++){
        //         System.out.print(Arrays.toString(dp[i][j]));
        //     }
        //     System.out.println();
        // }

        int ans = Integer.MAX_VALUE;
        for(int i = c ; i < 1100 ; i++){
            if(dp[N][i][1] >= c){
                ans = Math.min(dp[N][i][0],ans);
            }

        }
        System.out.println(ans);
        
    }
}