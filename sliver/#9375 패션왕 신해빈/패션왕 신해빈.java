import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for(int i = 0; i < tc; i++){
			int items = Integer.parseInt(br.readLine());
			Map<String,List<String>> arr = new HashMap<>();
			List<String> types = new ArrayList<>();

			for(int j = 0; j < items ; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String type = st.nextToken();

				if(arr.containsKey(type)){
					arr.get(type).add(item);
				} else {
					types.add(type);
					arr.put(type,new ArrayList<>());
					arr.get(type).add(item);
				}
			}

			int answer = 1;
			for(String type : types){
				answer *= (arr.get(type).size()+1);
			}

			sb.append(answer-1).append('\n');
		}

		System.out.print(sb);
	}
}