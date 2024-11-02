import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 명령어 개수 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0;i <N;i++){
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			Integer num = null;
            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }
			if (command.equals("add")){
				if(!set.contains(num)){
					set.add(num);
				}
			}else if (command.equals("remove")){
				if(set.contains(num)){
				set.remove(num);
				}
			}else if(command.equals("check")){
				if (set.contains(num)){
					sb.append(1).append('\n');
				}else{
					sb.append(0).append('\n');
				}
			}else if(command.equals("toggle")){
				if (set.contains(num)){
					set.remove(num);
				}else{
					set.add(num);
				}
			}else if(command.equals("all")){
				set.clear(); // 모든 값을 비움
					for (Integer j=0;j<20;j++){
						set.add(j+1);
					}
			}else if(command.equals("empty")){
				set.clear(); // 모든 값을 비움
			}
		}

		System.out.println(sb);
	} 
}

