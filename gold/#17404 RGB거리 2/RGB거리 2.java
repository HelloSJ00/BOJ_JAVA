import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] val = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                val[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N + 1][3];
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) dp[1][i] = val[1][i];
                else dp[1][i] = INF; // 다른 색으로 시작 불가하게 막음
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + val[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + val[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + val[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue; // 시작과 끝이 같으면 안 됨
                answer = Math.min(answer, dp[N][lastColor]);
            }
        }

        System.out.println(answer);
    }
}
