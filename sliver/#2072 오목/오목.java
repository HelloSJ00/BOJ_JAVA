import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = new int[20][20];
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= N ; i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(omok(y,x,i)){
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	static boolean omok(int y, int x,int turn){
		Deque<int[]> q1 = new ArrayDeque<>();
		Deque<int[]> q2 = new ArrayDeque<>();
		Deque<int[]> q3 = new ArrayDeque<>();
		Deque<int[]> q4 = new ArrayDeque<>();

		int cnt = 1;

		Set<String> set = new HashSet<>();

		if(turn%2==0){
			// 백 2
			board[y][x] =2;
			q1.offer(new int[]{y,x,2});
			q2.offer(new int[]{y,x,2});
			q3.offer(new int[]{y,x,2});
			q4.offer(new int[]{y,x,2});
			set.add(y+" "+x);

		} else {
			// 흑 1
			board[y][x] =1;
			q1.offer(new int[]{y,x,1});
			q2.offer(new int[]{y,x,1});
			q3.offer(new int[]{y,x,1});
			q4.offer(new int[]{y,x,1});
			set.add(y+" "+x);
		}
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};
		

		while(!q1.isEmpty()){
			int[] cur = q1.poll();
			int cy = cur[0];
			int cx = cur[1];
			int color = cur[2];

			for(int i = 0 ; i < 2 ; i++){
				int ny = cy + dy[i];
				if(ny > 0 && ny < 20 && board[ny][cx] == color && !set.contains(ny+" "+cx)){
					cnt++;
					q1.offer(new int[]{ny,cx,color});
					set.add(ny+" "+cx);
				}
			}
		}
		if(cnt == 5) return true;
		set.clear();
		set.add(y + " " + x);
		cnt = 1;

		while(!q2.isEmpty()){
			int[] cur = q2.poll();
			int cy = cur[0];
			int cx = cur[1];
			int color = cur[2];

			for(int i = 0 ; i < 2 ; i++){
				int nx = cx + dx[i+2];
				if(nx > 0 && nx < 20 && board[cy][nx] == color && !set.contains(cy+" "+nx)){
					cnt++;
					q2.offer(new int[]{cy,nx,color});
					set.add(cy+" "+nx);
				}
			}
		}
		if(cnt == 5) return true;
		set.clear();
		set.add(y + " " + x);
		cnt = 1;

		while(!q3.isEmpty()){
			int[] cur = q3.poll();
			int cy = cur[0];
			int cx = cur[1];
			int color = cur[2];

			for(int i = 0 ; i < 2 ; i++){
				int ny = cy + dy[i];
				int nx = cx + dx[i+2];
				if(ny > 0 && ny < 20 && nx > 0 && nx < 20 && board[ny][nx] == color && !set.contains(ny+" "+nx)){
					// System.out.println(ny+" "+ cx);
					cnt++;
					q3.offer(new int[]{ny,nx,color});
					set.add(ny+" "+nx);
				}
			}
		}
		if(cnt == 5) return true;
		set.clear();
		set.add(y + " " + x);
		cnt = 1;

		while(!q4.isEmpty()){
			int[] cur = q4.poll();
			int cy = cur[0];
			int cx = cur[1];
			int color = cur[2];

			for(int i = 0 ; i < 2 ; i++){
				int ny = cy + dy[i];
				int nx = cx - dx[i+2];
				if(ny > 0 && ny < 20 && nx > 0 && nx < 20 && board[ny][nx] == color && !set.contains(ny+" "+nx)){
					cnt++;
					q4.offer(new int[]{ny,nx,color});
					set.add(ny+" "+nx);
				}
			}
		}

		if(cnt == 5) return true;
		return false;
	}
}