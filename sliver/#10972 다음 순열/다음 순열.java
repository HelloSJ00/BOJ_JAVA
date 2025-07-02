import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr; // 0번 인덱스는 사용하지 않고 1번부터 N번까지 사용
    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; // 1-based indexing

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findNext();
    }

    public static void findNext() {
        // 1. 뒤에서부터 탐색하여 arr[i-1] < arr[i]를 만족하는 가장 큰 i (pivot의 오른쪽 인덱스)를 찾습니다.
        //    이때 arr[i-1]이 다음 순열을 만들기 위한 'pivot'이 됩니다.
        int i = N;
        while (i > 1 && arr[i-1] >= arr[i]) {
            i--;
        }

        // i가 1이 되었다면 (배열 전체가 내림차순이면), 현재 배열이 가장 마지막 순열임
        if (i == 1) {
            System.out.print("-1");
            return;
        }

        // 2. arr[i-1] (pivot)보다 크면서, arr[i]부터 arr[N]까지의 부분에서 가장 작은 값 찾기 (인덱스 j).
        int j = N;
        while (arr[j] <= arr[i-1]) {
            j--;
        }

        // 3. arr[i-1]과 arr[j]를 교환합니다.
        swap(i-1, j);

        // 4. arr[i]부터 배열의 끝(arr[N])까지의 부분을 오름차순으로 정렬합니다.
        //    (이 부분은 이미 내림차순으로 정렬되어 있으므로, 단순히 뒤집기만 하면 됩니다.)
        reverse(i, N);

        // 결과 출력
        for (int k = 1; k <= N; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.print(sb.toString().trim());
    }

    // 배열의 두 요소 교환 유틸리티 함수
    private static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // 배열의 특정 범위 뒤집기 유틸리티 함수
    private static void reverse(int start, int end) {
        while (start < end) {
            swap(start, end);
            start++;
            end--;
        }
    }
}