import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int H;
	static int[] suksoon;
	static int[] zong;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		suksoon = new int[N/2];
		zong = new int[N/2];

		int[] arr = new int[H+1];

		for(int i = 0 ; i < N ;i++){
			if(i%2 == 0){
				suksoon[i/2] = Integer.parseInt(br.readLine());
			} else {
				zong[i/2]  = Integer.parseInt(br.readLine());
			}
		}
		
		Arrays.sort(suksoon);
		Arrays.sort(zong);

		for(int i = 1 ; i <= H ; i++){
			// System.out.println("H :" + i);
			int suk = ub(i); // -1
			if(suk == -1){
				suk = N/2;
			} else {
				suk = N/2 -suk-1;
			}
			int z = zong.length - lb(H+1-i); // 3

			// System.out.println("suk :" + suk + " zong :" + z);
			arr[i] = suk + z;
			
		}

		// System.out.println(Arrays.toString(arr));
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1 ; i <= H ; i++){
			if(arr[i] == min) cnt++;
			else if(arr[i] < min){
				min = arr[i];
				cnt = 1;
			}
		}

		System.out.print(min + " " + cnt);
	}

	static int ub(int a){
		int l = 0 ;
		int r = N/2-1;
		int mid;

		while(l <= r){
			mid = (l+r)/2;
			if(suksoon[mid] < a ){
				l = mid+1;
			} else {
				r = mid -1;
			}
		}
		// System.out.println("suk r :" +(r));
		return r;
	}

	static int lb(int a ){
		// System.out.println("a "+a);
		// System.out.println(Arrays.toString(zong));
		int l = 0 ;
		int r = N/2-1;
		int mid;

		while(l <= r){
			mid = (l+r)/2;
			if(zong[mid] >= a ){
				r = mid - 1 ;
			} else {
				l = mid + 1;
			}
		}
		// System.out.println("lb :" +(l));

		return l;
	}
}