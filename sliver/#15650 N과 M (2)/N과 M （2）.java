import java.io.*;
import java.util.*;

public class Main{
	static List<int[]> list = new ArrayList<>();
	static int[] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		for(int i = 1 ; i <= N ; i++){
			Solution(i,0);
		}

		// 리스트 출력

		StringBuilder sb = new StringBuilder();
		for (int[] arr : list) {
			for(int num : arr){
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	public static void Solution(int num ,int depth){
		arr[depth] = num;
		if(depth == M-1 ){
			list.add(arr.clone());
			// System.out.println("배열에 추가" +Arrays.toString( arr));
			arr[depth] = 0;
		} else{
			for(int i = num+1 ; i <= N ; i++){
				Solution(i,depth+1);
				// System.out.println("다음 층 추가");
			}
		}

		arr[depth] = 0;
	}
}