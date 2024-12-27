import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i< N ; i++){
			int command = Integer.parseInt(bf.readLine());
			if(command != 0){
				pq.add(command);
			} else{
				if(pq.isEmpty()){
					sb.append(0).append('\n');
				} else{
					sb.append(pq.poll()).append('\n');
				}
			}
		}
		System.out.print(sb);
	}
}