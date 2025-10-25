import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		int TC = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < TC ; i++){
			game();
			System.out.println();
		}
	}

	static void game() throws Exception{
		int N = Integer.parseInt(br.readLine());
		list.clear();
		recur(0,N,0,0,"",true);

		Collections.sort(list);
		for(String s : list){
			System.out.println(s);
		}
	}

	static void recur(int depth,int N,int total,int dummy,String s,boolean flag){
		dummy = dummy*10 + (depth+1);

		if(depth == N-1){
			s = s+String.valueOf(depth+1);
			// N번째
			if(flag && total + dummy == 0){
				list.add(s);
			} else if(!flag && total - dummy == 0) {
				list.add(s);
			}
			return;
		}

		// 더미를 더해야할때
		if(flag){
			recur(depth+1,N,total+dummy,0,s+String.valueOf(depth+1)+"+",true);
			recur(depth+1,N,total+dummy,0,s+String.valueOf(depth+1)+"-",false);
			recur(depth+1,N,total,dummy,s+String.valueOf(depth+1)+" ",flag);
		}

		// 더미를 빼야할때 
		if(!flag){
			recur(depth+1,N,total-dummy,0,s+String.valueOf(depth+1)+"+",true);
			recur(depth+1,N,total-dummy,0,s+String.valueOf(depth+1)+"-",false);
			recur(depth+1,N,total,dummy,s+String.valueOf(depth+1)+" ",flag);
		}
	}
}