import java.io.*;
import java.util.*;

public  class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < N ; i++){
			int command = Integer.parseInt(br.readLine());
			if (command == 0){
				if(!pq.isEmpty()){
					sb.append(pq.poll()).append('\n');
				} else{
					sb.append(0).append('\n');
				}
			} else{
				pq.add(command);
			}
		}	
		System.out.print(sb);
	}
}