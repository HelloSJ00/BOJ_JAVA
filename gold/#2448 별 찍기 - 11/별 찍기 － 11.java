import java.io.*;
import java.util.*;

public class Main {
    static char[][] star;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        star = new char[N][2 * N];  // 가로 길이 = 2N
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        addStar(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            sb.append(star[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void addStar(int y, int x, int n) {
        if (n == 3) { // base case
            star[y][x] = '*';
            star[y + 1][x - 1] = '*';
            star[y + 1][x + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                star[y + 2][x + i] = '*';
            }
            return;
        }

        int half = n / 2;
        // 위쪽 삼각형
        addStar(y, x, half);
        // 왼쪽 아래 삼각형
        addStar(y + half, x - half, half);
        // 오른쪽 아래 삼각형
        addStar(y + half, x + half, half);
    }
}