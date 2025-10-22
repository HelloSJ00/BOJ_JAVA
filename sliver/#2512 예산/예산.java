import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[][] map ;
	static int N;
	static StringTokenizer st;
	static int[] arr;
	static int M;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		int l = 1;
		int r = 100_000;

		while(l <= r){
			int mid = (l+r)/2;

			if(search(mid)){
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if(r == 100_000){
			Arrays.sort(arr);
			System.out.println(arr[N-1]);
			return;
		}

		System.out.println(l-1);
	}

	static boolean search(int mid){
		long sum = 0;

		for(int i = 0 ; i < N ; i++){
			if(arr[i]>mid) sum += mid;
			else sum += arr[i];
		}

		if(sum <= M) return true;
		return false;
	}
}