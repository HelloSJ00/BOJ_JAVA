import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i< N ; i++){
			set.add(bf.readLine());
		}
		for (int i = 0; i< K ; i++){
			String tmp = bf.readLine();
			if (set.contains(tmp)){
				list.add(tmp);
			}
		}
		Collections.sort(list);
		String[] newArray = list.toArray(new String[0]);
		StringBuilder sb = new StringBuilder();
		sb.append(newArray.length).append('\n');
		for(int i = 0 ; i < newArray.length;i++){
			sb.append(newArray[i]).append('\n');
		}
		System.out.println(sb);
	}
}