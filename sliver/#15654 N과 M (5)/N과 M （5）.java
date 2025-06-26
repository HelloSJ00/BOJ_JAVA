import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited; // static으로 선언하여 모든 재귀 호출이 동일한 visited 배열 공유

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N]; // main 메서드에서 한 번만 visited 배열 초기화

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 결과를 사전순으로 정렬하기 위해 원본 배열 정렬

        // 각 숫자를 시작점으로 순열 탐색 시작 (백트래킹 적용)
        for (int i = 0; i < N; i++) {
            visited[i] = true; // 현재 숫자를 방문 처리
            recur(0, String.valueOf(arr[i])); // depth는 0부터 시작, 첫 번째 숫자를 문자열로 전달
            visited[i] = false; // 재귀 호출 완료 후 방문 상태 해제 (백트래킹)
        }

        System.out.print(sb.toString());
    }

    // depth: 현재까지 선택한 숫자의 개수 (0부터 M-1까지)
    // s: 현재까지 만들어진 순열 문자열
    public static void recur(int depth, String s) {
        // M개의 숫자를 모두 선택했으면 결과 출력
        if (depth == M - 1) { // depth가 M-1이면 총 M개의 숫자를 선택한 것임 (0부터 시작하므로)
            sb.append(s);
            sb.append("\n");
            return; // 재귀 종료
        }

        // 모든 숫자 중에서 다음 숫자 선택
        for (int i = 0; i < N; i++) {
            // 현재 숫자를 이전에 방문하지 않았다면
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                recur(depth + 1, s + " " + arr[i]); // 다음 숫자를 추가하고 재귀 호출
                visited[i] = false; // 재귀 호출 완료 후 방문 상태 해제 (백트래킹)
            }
        }
    }
}