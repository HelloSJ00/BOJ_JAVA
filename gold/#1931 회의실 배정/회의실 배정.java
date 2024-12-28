import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		List<int[]> list = new ArrayList<>();
		for(int i = 0 ; i< N ; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[]{a,b});
		}
		int answer = Solution(list);
		System.out.print(answer);
	}

	public static int Solution(List<int[]> list){
		list.sort(
			Comparator.comparing((int[] arr)-> arr[1])
								.thenComparing(arr->arr[0]));
		int cnt = 0;
		int cur_t = 0;

		for(int[] meet : list){
			if(meet[0] >= cur_t){
				cnt += 1;
				cur_t = meet[1];
			}
		}
		return cnt;
	}
}