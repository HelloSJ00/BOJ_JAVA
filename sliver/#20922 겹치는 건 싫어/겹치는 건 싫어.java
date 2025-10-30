import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static public void main(String[] args) throws Exception{	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[N];

		Map<Integer,Integer> map = new HashMap<>();

		int l = 0;
		int r = 1;
		int length = 0;

		while(r <= N && l < N){
			// System.out.println(l + " " + r +"; " + length);
			// for(int i : map.keySet()){
			// 	System.out.println(i + " : " +map.get(i));
			// }
			if(r <= N && !map.containsKey(arr[r-1])){
				map.put(arr[r-1],1);
				r++;
				length++;
			} else if(r <= N && map.get(arr[r-1]) < K){
				map.put(arr[r-1],map.get(arr[r-1]) + 1);
				r++;
				length++;
			} else if(l < N){
				// System.out.println(arr[l]);
				map.put(arr[l],map.get(arr[l])-1);
				l++;
				length--;
			}

			// System.out.println(l + " " + r);
			answer[l] = Math.max(length,answer[l]);
		}

		// System.out.println(Arrays.toString(/nswer));
		int max = 0;
		for(int i = 0 ; i < N ; i++){
			max = Math.max(answer[i],max);
		}

		System.out.println(max);
		
	}
}

