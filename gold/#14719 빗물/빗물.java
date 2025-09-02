import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int H;
    static int W;
    static int[][] map ;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 맵을 눕혔음
        map = new int[W][H];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < W ; i++){
            int tmp = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < tmp ; j++){
                // 블록
                map[i][j] = 1;
            }
        }

        rain();

        // for(int i = 0 ; i < W ; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        System.out.println(counting());
    }

    static void rain(){
        for(int i = 0 ; i < H ; i++){
            // 물이 고일수 있는 높이인지 체크
            int blockStartIdx = -1;
            int blockEndIdx = -1;
            for(int j = 0 ; j < W ; j++){
                if(blockStartIdx == -1 && map[j][i] == 1){
                    blockStartIdx = j;
                } else if(blockStartIdx != -1 && map[j][i] == 1){
                    blockEndIdx = j;
                    // 같은 높이 블록 만났으면 물로 채우기 
                    for(int k = blockStartIdx + 1 ; k < blockEndIdx ; k++){
                        map[k][i] = 2;
                    }
                    blockStartIdx = blockEndIdx;
                }
            }
        }
    }

    static int counting(){
        int cnt = 0;
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                if(map[j][i] == 2){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}