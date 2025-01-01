import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++ ){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(Solution(N,K,arr));
	}

	public static int Solution(int N,int K,int[] trees){
		// 나무 오름차숭 정렬
		Arrays.sort(trees);
		// 이분탐색으로 해결 O(logN)
		int left = 0;
		int mid;
		int right = trees[N-1];
		int result = 0;
		long sum ;
		while(left <= right){
			/*
			 * 1. 벌목 나무 합이 K보다 크면 
			 * 2. 벌목 나무 합이 K보다 작으면
			 */
			mid = (left+right)/2;
			sum = 0; // 합 초기화
			for(int index = 0; index < trees.length ; index++){
				int tmp = trees[index]-mid;
				if(tmp > 0){
					sum += tmp;
				}
			}

			if (sum >= K){
				result = mid;
				left = mid + 1;
			} else{
				right = mid-1;
			}
		}

		return result;
	}
}