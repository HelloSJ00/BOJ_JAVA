import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[][] map ;
	static int N;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		

		for(int i = 0 ; i < N ; i++){
			String[] tmp = br.readLine().split("");
			map[i] = tmp;
		}

		
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(map[i][j].equals("*")){
					game(i,j);
					return;
				}
			}
		}
	}

	static void game(int a,int b){
		int gjfl = 0;
		int leftArm = 0;
		int rightArm = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		boolean findHeart = false;
		int[] heart;

		while(true){
			// 팔 발견
			if(map[a][b-1].equals("*")){
				// System.out.println(a+" "+b);
				leftArm = getLeftArm(a,b-1);
				rightArm = getRightArm(a,b+1);
				findHeart = true;
				heart = new int[]{a,b};
				break;
			}
			a++;
		}

		while(true){
			if(!map[a+1][b].equals("*")){
				leftLeg = getLeftLeg(a+1,b-1);
				rightLeg = getRightLeg(a+1,b+1);
				break;
			}

			a++;
			gjfl++;
		}

		System.out.println((heart[0]+1) +" " + (heart[1]+1));
		System.out.println(leftArm+" "+rightArm+" "+gjfl+" "+leftLeg+" "+rightLeg);
	}

	static int getLeftArm(int a, int b){
		int ans = 0;
		// System.out.println(a+" "+b);
		while(b >= 0 && map[a][b].equals("*")){
				b--;
				ans++;
		}
		return ans;
	}

	static int getRightArm(int a, int b){
		int ans = 0;
		while(b < N && map[a][b].equals("*")){
				b++;
				ans++;
		}
		return ans;
	}
	
	static int getLeftLeg(int a, int b){
		int ans = 0;
		while(a < N && map[a][b].equals("*")){
				a++;
				ans++;
		}
		return ans;
	}
	static int getRightLeg(int a, int b){
		int ans = 0;
		while(a < N && map[a][b].equals("*")){
				a++;
				ans++;
		}
		return ans;
	}
	}