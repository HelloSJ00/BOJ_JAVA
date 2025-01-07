import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < testCase ; i++){
			int numOfCommand = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			Map<Integer,Integer> isExist = new HashMap<>();
			int cnt = 0;
			for(int j = 0 ; j < numOfCommand ; j++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("D")){
					if(cnt !=0) {
						cnt--;
						int cur = 0;
						if(num == 1){
							cur = maxHeap.poll();
							while(isExist.get(cur) == 0 ){
								cur = maxHeap.poll();
							}
							isExist.put(cur,isExist.get(cur)-1);
						} else {
							cur = minHeap.poll();
							while(isExist.get(cur) == 0){
								cur = minHeap.poll();
							}
							isExist.put(cur,isExist.get(cur)-1);
						}
					}
				} else if(command.equals("I")){ // command 가 I일때
						cnt ++;
						if(isExist.containsKey(num)){
							isExist.put(num,isExist.get(num)+1);
						} else{
							isExist.put(num,1);
						}
						// System.out.println(num + " " +isExist.get(num));
						maxHeap.add(num);
						minHeap.add(num);
				}
			}

			

			if(cnt==0){
				sb.append("EMPTY");
			} else{
				int cur = maxHeap.poll();
				while(isExist.get(cur) == 0){
				cur = maxHeap.poll();
				}
				maxHeap.add(cur);

				cur = minHeap.poll();
				while(isExist.get(cur) == 0){
					cur = minHeap.poll();
				}
				minHeap.add(cur);

				sb.append(maxHeap.poll()).append(' ').append(minHeap.poll());
			}
			sb.append('\n');
		}
		System.out.print(sb);		
		}
		
}