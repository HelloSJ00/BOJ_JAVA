import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> blank = new ArrayList<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i,j});
                    
                } else if(map[i][j] == 0){
                    blank.add(new int[]{i,j});
                }
            }
        }

        for(int i = 0 ; i < blank.size() ; i++){
            map[blank.get(i)[0]][blank.get(i)[1]] = 1;
            for(int j = i+1 ; j < blank.size() ; j++){
                map[blank.get(j)[0]][blank.get(j)[1]] = 1;
                for(int k = j + 1 ; k < blank.size(); k++){
                    map[blank.get(k)[0]][blank.get(k)[1]] = 1;
                    int[][] tmpMap = spreadVirus();
                    ans = Math.max(countingSafe(tmpMap),ans);
                    map[blank.get(k)[0]][blank.get(k)[1]] = 0;
                }
                map[blank.get(j)[0]][blank.get(j)[1]] = 0;
            }
            map[blank.get(i)[0]][blank.get(i)[1]] = 0;
        }

        System.out.println(ans);
    }

    static int[][] spreadVirus(){
        int[][] newMap = new int[N][M];

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};

        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                newMap[i][j] = map[i][j];
            }
        }

        // for(int i = 0 ; i < N ; i++){
        //     System.out.println(Arrays.toString(newMap[i]));
        // }

        for(int[] v : virus){
            q.add(v);
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0 ; i < 4 ; i++){
                int ny = cy+ dy[i];
                int nx = cx + dx[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < M && newMap[ny][nx] == 0){
                    newMap[ny][nx] = 2;
                    q.offer(new int[]{ny,nx});
                }
            }
        }

        return newMap;
    }

    static int countingSafe(int[][] map){
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        // System.out.println(cnt);
        return cnt;
    }
}