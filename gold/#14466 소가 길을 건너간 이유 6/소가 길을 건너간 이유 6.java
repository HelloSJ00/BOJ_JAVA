import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<int[]> q = new ArrayDeque<>();
	static HashMap<String,List<int[]>> road = new HashMap<>();
	static boolean[][] visit ;
	static int N;
	static int[][] map; 
	static public void main(String[] args) throws Exception{	
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] cow = new int[N+1][N+1];
		map = new int[N+1][N+1];
		int cnt = 1;
		visit = new boolean[N+1][N+1];

		for(int i = 0 ; i < R ; i++){
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			String k1 = String.valueOf(y1) +" " + String.valueOf(x1);
			String k2 = String.valueOf(y2) +" " + String.valueOf(x2);
			if(!road.containsKey(k1)){
				road.put(k1,new ArrayList<>());
			}

			if(!road.containsKey(k2)){
				road.put(k2,new ArrayList<>());
			}

			road.get(k1).add(new int[]{y2,x2});
			road.get(k2).add(new int[]{y1,x1});
		}

		for(int i = 0 ; i < K ; i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			cow[y][x] = 1;
		}

		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= N ; j++){
				if(!visit[i][j]){
					bfs(i,j,cnt);
					cnt++;
				} 
			}
		}

		// for(int i = 1 ; i <= N ; i++){
		// 	for(int j =1 ; j <= N ; j++){
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		List<Integer> l = new ArrayList<>();

		for(int c = 1 ; c < cnt ; c++){
			int num = 0;

			for(int i = 1 ; i <= N ; i++){
				for(int j =1 ; j <= N ; j++){
					if(map[i][j] == c && cow[i][j] == 1) num++;
				}
			}

			l.add(num);
		}

		// System.out.println(l);

		for(int i = 0 ; i < l.size();i++){
			for(int j = i+1 ; j < l.size() ; j++){
				answer += l.get(i)*l.get(j);
			}
		}
		System.out.println(answer);
	}

	static void bfs(int y,int x,int cnt){
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};
		q.offer(new int[]{y,x});
		visit[y][x] = true;
		map[y][x] = cnt;

		while(!q.isEmpty()){
			int[] cur =q.poll();

			int cy = cur[0];
			int cx = cur[1];

			for(int i = 0 ; i < 4 ;i++){
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if(ny > 0 && ny <= N && nx > 00 && nx <= N && !visit[ny][nx]){
					String k = String.valueOf(cy) + " " + String.valueOf(cx);

					boolean ct = true;

					if(road.containsKey(k)){
						for(int[] c : road.get(k)){
							if(c[0] == ny && c[1] == nx){
								ct = false;
							}
					}}

					if(!ct){
						continue;
					} else{
						// System.out.println("k : " +k);
						map[ny][nx] = cnt;
						visit[ny][nx] = true;
						q.offer(new int[]{ny,nx});
					}
				}
			}
		}
	}
	}

