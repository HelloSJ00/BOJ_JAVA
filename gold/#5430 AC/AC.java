import java.io.*;
import java.util.*;

public class Main{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int testCase = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < testCase ; i ++ ){
			String[] commands = br.readLine().split("");
			int length = Integer.parseInt(br.readLine());

			Deque<Integer> arr = new ArrayDeque<>();
			String[] string = br.readLine().split("\\[|\\]|,");
			for(String s : string){
				if(!s.isEmpty()){
					arr.addLast(Integer.parseInt(s));
				}
			}
			Solution(arr,commands);
		}
	}

	public static void Solution(Deque<Integer> arr,String[] commands){
		StringBuilder sb = new StringBuilder();
		boolean isReverse = false;
		for(String command : commands){
			if(command.equals("R")){
				isReverse = !isReverse;
			} else if(command.equals("D")){
				if (arr.isEmpty()){
					sb.append("error");
					System.out.println(sb);
					return;
				}else if(isReverse){
					arr.pollLast();
				} else{
					arr.pollFirst();
				}
			}
		}
		sb.append('[');
		if (isReverse) {
			Iterator<Integer> iterator = arr.descendingIterator(); // 역순 처리
			while (iterator.hasNext()) {
					sb.append(iterator.next());
					if (iterator.hasNext()) {
							sb.append(',');
					}
			}
	} else {
			Iterator<Integer> iterator = arr.iterator(); // 정방향 처리
			while (iterator.hasNext()) {
					sb.append(iterator.next());
					if (iterator.hasNext()) {
							sb.append(',');
					}
			}
	}
	sb.append(']');

		System.out.println(sb);
}}