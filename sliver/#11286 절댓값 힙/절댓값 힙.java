import java.io.*;
import java.util.*;

public  class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pluspq = new PriorityQueue<>();
		PriorityQueue<Integer> minuspq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < N ; i++){
			int command = Integer.parseInt(br.readLine());
			if (command == 0){
				if(!pluspq.isEmpty() && !minuspq.isEmpty()){
					int tmpPlus = pluspq.poll();
					int tmpMinus = minuspq.poll();
					
					if ( tmpPlus < tmpMinus){
						minuspq.add(tmpMinus);
						sb.append(tmpPlus).append('\n');
					} else {
						pluspq.add(tmpPlus);
						sb.append(-tmpMinus).append('\n');
					}
				} else if (!pluspq.isEmpty()){
					sb.append(pluspq.poll()).append('\n');
				} else if (!minuspq.isEmpty()){
						sb.append(-minuspq.poll()).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			} else{
				if (command > 0){
					pluspq.add(command);
				} else{
					minuspq.add(-command);
				}
			}
		}	
		System.out.print(sb);
	}
}