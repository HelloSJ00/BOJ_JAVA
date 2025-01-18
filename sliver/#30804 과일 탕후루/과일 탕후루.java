import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if(N == 1){
			System.out.print(1);
			return;
		} else if(N == 2){
			System.out.print(2);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i <N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] curList = new int[2];
		curList[0] = arr[0];
		int front = 0;
		int[] back = new int[3];
		
		front = 0;
		if(arr[1]== arr[0]){
			back = new int[]{arr[1],0,1};
		} else{
			curList[1] = arr[1];
			back = new int[]{arr[1],1,1};
		}

		int answer = 0;
		int curLength = back[2]-front+1;

		for(int i = 2 ; i < N ; i++){
			// System.out.println(front +  " = " + "front");
			// System.out.println( Arrays.toString(back)+": "+ "back");
			if(arr[i] == back[0]){
				// 가장 뒤에 있는 수와 같은 수가 들어왔을 경우
				back[2] = i;
			} else if(arr[i] != back[0] && (curList[0] == arr[i] || curList[1] == arr[i])){
				// 가장 뒤에 있는 수와 다른 수지만 curList에 존재하는 수일 경우 back을 바꿈
				back = new int[]{arr[i],i,i};
			} else {
				// 아예 curList에 존재하지 않는 수가 들어왔을 경우
				for(int j = 0 ; j < 2 ; j++){
					if (curList[j] != back[0]){
						curList[j] = arr[i];
					}
				}

				front = back[1];
				back = new int[]{arr[i],i,i};
			}
			curLength = back[2]-front+1;
			answer = Math.max(answer,curLength);
			// System.out.println(curLength);
		}
		System.out.print(answer);
	}
}