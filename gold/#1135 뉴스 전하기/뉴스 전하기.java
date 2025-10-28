import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static public void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] parent = new int[N+1];
		List<List<Integer>> child = new ArrayList<>();
		for(int i = 0 ; i < N ; i++){
			child.add(new ArrayList<>());
		}

		for(int i = 0 ; i < N ; i++){
			parent[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				if(parent[j]==i){
					child.get(i).add(j);
				}
			}
		}
		
		int[] time = new int[N];


		for(int i = N-1 ; i >= 0 ; i--){
			// System.out.println(child.get(i));
			if(child.get(i).size() == 0){
				time[i] = 0;
			} else {
				List<Integer> tmpList = new ArrayList<>();

				int tmpTime = 0;
				for(int c : child.get(i)){
					tmpList.add(time[c]);
				}

				Collections.sort(tmpList,Comparator.reverseOrder());
				// System.out.println("sorted tmpList: "+tmpList);

				for(int k = 1 ; k <= tmpList.size(); k++){
					tmpTime = Math.max(k+tmpList.get(k-1),tmpTime);
				}

				time[i] = tmpTime;
			}
		}
		// System.out.println(Arrays.toString(time));
		System.out.println(time[0]);
	}
}