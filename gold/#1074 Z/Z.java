import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// 입력값
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int answer = recrusion(N, R, C);
		System.out.println(answer);
		}

	static int recrusion(int n,int r,int c){
		if(n==1){
			if(r==0 && c==0){
				return 0;
			} else if(r==0 && c==1){
				return 1;
			} else if(r==1 && c ==0){
				return 2;
			} else if(r==1 && c==1){
				return 3;
			}
		}

		int half = (int) Math.pow(2, n - 1); // n-1 제곱을 정수로 변환
    if (half <= r && half <= c) {
      return 3 * half *half + recrusion(n - 1, r - half, c - half); 
		}else if(half <= r && half>=c){
			return 2 *half *half + recrusion(n - 1, r - half, c );
		}else if(half >= r && half<=c){
			return half *half + recrusion(n - 1, r , c - half);
		}else{
			return recrusion(n - 1, r , c );
		}
	}
}