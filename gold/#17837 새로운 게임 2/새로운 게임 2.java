import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] color;
	static Deque<Integer>[][] malPos;
	static int[][] direct = {
		{0,0},
		{0,1},
		{0,-1},
		{-1,0},
		{1,0}
	};

	static List<mal> list = new ArrayList<>();
	static int N;

	static class mal{
		int y;
		int x;
		int direct;

		public mal(int y,int x,int direct){
			this.y = y;
			this.x = x;
			this.direct = direct;
		}
	}

	static public void main(String[] args) throws Exception{	
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		color = new int[N][N];
		malPos = new ArrayDeque[N][N];

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++){
				int c = Integer.parseInt(st.nextToken());
				color[i][j] = c;
			}
		}

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				malPos[i][j] = new ArrayDeque<>();
			}
		}

		for(int i = 0 ; i < K ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new mal(a-1,b-1,c));
			malPos[a-1][b-1].push(i);
		}
		int turn = 1;
		while(turn < 1000){
			for(int i = 0 ; i < K ; i++){
				mal m = list.get(i);
				if(move(m,0,i)){
					System.out.println(turn);
					return;
				}
			}
			turn++;
		}
		
		System.out.println(-1);
	}

	static boolean move(mal m,int cnt,int num){
		int ny = m.y + direct[m.direct][0];
		int nx = m.x + direct[m.direct][1];

		if(!(ny >= 0 && ny < N && nx >= 0 && nx < N) || color[ny][nx] == 2){
			if(cnt == 0){
				changeDirect(m);
				return move(m,cnt+1,num);
			}
			return false;
		}

		if(color[ny][nx] == 0){
			white(m,ny,nx,num);
		} else if(color[ny][nx] == 1){
			red(m,ny,nx,num);
		}

		if(malPos[ny][nx].size() >= 4){
			return true;
		}

		return false;
	}

	static void red(mal m,int ny,int nx,int malNum){
		while(malPos[m.y][m.x].peek() != malNum){
			int tmpMalNum = malPos[m.y][m.x].pop();
			mal tmpMal = list.get(tmpMalNum);
			tmpMal.y = ny;
			tmpMal.x = nx;
			malPos[ny][nx].push(tmpMalNum);
		}
		// 끝나고 한번더 
		int tmpMalNum = malPos[m.y][m.x].pop();
			mal tmpMal = list.get(tmpMalNum);
			tmpMal.y = ny;
			tmpMal.x = nx;
			malPos[ny][nx].push(tmpMalNum);
		m.y = ny;
		m.x = nx;
	}

	static void white(mal m,int ny, int nx,int malNum){
		Deque<Integer> tmp = new ArrayDeque<>();

		while(malPos[m.y][m.x].peek() != malNum){
			int tmpMalNum = malPos[m.y][m.x].pop();
			mal tmpMal = list.get(tmpMalNum);
			tmpMal.y = ny;
			tmpMal.x = nx;
			tmp.push(tmpMalNum);
		}
		// 끝나고 한번더 
		int tmpMalNum = malPos[m.y][m.x].pop();
			mal tmpMal = list.get(tmpMalNum);
			tmpMal.y = ny;
			tmpMal.x = nx;
			tmp.push(tmpMalNum);

		while(!tmp.isEmpty()){
			malPos[ny][nx].push(tmp.pop());
		}

		m.y = ny;
		m.x = nx;
	}

	static void changeDirect(mal m){
		if(m.direct == 1){
			m.direct = 2;
		} else if(m.direct == 2){
			m.direct = 1;
		} else if(m.direct == 3){
			m.direct = 4;
		} else {
			m.direct = 3;
		}
	}
}
