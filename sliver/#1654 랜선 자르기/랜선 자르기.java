import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();
	static int[] nums;
	static int N;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		long l = 1;
		long r = 0;
		nums = new int[K];
		for(int i = 0 ; i < K ; i++){
			nums[i] = Integer.parseInt(br.readLine());
			r = Math.max(r,nums[i]);
		}

		long mid;
		while(l<=r){
			mid = (l+r)/2;

			long tmp = getK(mid);
			if(tmp >= N){
				l = mid + 1;
			} else if(tmp < N){
				r = mid - 1;
			}

		}

		System.out.println(l-1);
	}

	static long getK(long frag){
		long num = 0;

		for(long i : nums){
			num += i/frag;
		}
		return num;
	}
}