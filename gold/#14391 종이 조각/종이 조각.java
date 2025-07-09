import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] map ;
    static int result=0; // long 타입으로 변경하는 것이 안전합니다. 합계가 커질 수 있기 때문입니다.

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine(); // charAt()을 사용하기 위해 split("") 대신 바로 String으로 받습니다.
            for(int j = 0 ; j < M ; j++){
                map[i][j] = line.charAt(j) - '0'; // char를 int로 변환
            }
        }

        // 비트마스크를 이용하여 모든 자르기 경우의 수를 탐색
        // mask의 k번째 비트가 0이면 가로, 1이면 세로로 자른다고 가정
        // k는 (r * M + c) 에 해당 (2차원 좌표를 1차원 비트 인덱스로 변환)
        for(int mask = 0 ; mask < (1 << (N*M)); mask++){
            long current_sum = 0; // 현재 마스크 조합의 총 합계 (int 대신 long 사용 권장)

            // 1. 가로 조각 합계 계산
            for(int r = 0 ; r < N ; r++){ // 행(r)을 기준으로 순회
                long current_horizontal_num = 0; // 현재 처리 중인 가로 조각의 숫자
                for(int c = 0 ; c < M ; c++){ // 열(c)을 순회
                    // 2차원 좌표 (r, c)를 1차원 비트 인덱스 (idx)로 변환
                    // 올바른 공식: r * M + c
                    int idx = r * M + c;

                    // 해당 비트가 0이면 가로 조각에 속함
                    if((mask & (1 << idx)) == 0){ // k번째 비트가 0인지 확인
                        current_horizontal_num = current_horizontal_num * 10 + map[r][c];
                    } else {
                        // 세로 조각을 만나면, 이전까지의 가로 조각을 합계에 더하고 초기화
                        current_sum += current_horizontal_num;
                        current_horizontal_num = 0;
                    }
                }
                // 한 행의 끝에 도달했을 때, 남아있는 가로 조각을 합계에 더합니다.
                current_sum += current_horizontal_num;
            }


            // 2. 세로 조각 합계 계산
            for(int c = 0 ; c < M ; c++){ // 열(c)을 기준으로 순회
                long current_vertical_num = 0; // 현재 처리 중인 세로 조각의 숫자
                for(int r = 0 ; r < N ; r++){ // 행(r)을 순회
                    // 2차원 좌표 (r, c)를 1차원 비트 인덱스 (idx)로 변환
                    // 올바른 공식: r * M + c
                    int idx = r * M + c;

                    // 해당 비트가 1이면 세로 조각에 속함
                    // (mask & (1 << idx)) == 1 대신, 비트가 켜져 있는지를 확인하는 일반적인 방법 사용
                    if((mask & (1 << idx)) != 0){
                        // 세로 조각은 map[행][열] 이므로 map[r][c]를 사용
                        current_vertical_num = current_vertical_num * 10 + map[r][c];
                    } else {
                        // 가로 조각을 만나면, 이전까지의 세로 조각을 합계에 더하고 초기화
                        current_sum += current_vertical_num;
                        current_vertical_num = 0;
                    }
                }
                // 한 열의 끝에 도달했을 때, 남아있는 세로 조각을 합계에 더합니다.
                current_sum += current_vertical_num;
            }

            // 현재 마스크 조합으로 얻은 합계가 최대값인지 확인하고 갱신
            result = (int)Math.max(result, current_sum); // result가 int라면 캐스팅 필요. long으로 바꾸는 게 좋습니다.
        }

        System.out.print(result);
    }
}