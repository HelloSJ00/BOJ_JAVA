import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static StringBuilder sb = new StringBuilder();
	static int[] parent;

	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N+1];
		for(int i = 1 ; i <= N ; i++){
			parent[i] = i;
		}

		for(int i = 1 ; i <= N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++){
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1){
					if(isSameGroup(i,j)) continue;
					else {
						parent[findRoot(j)] = i;
					}
				}
			}
		}

		// System.out.println(Arrays.toString(parent));

		int[] route = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++){
			route[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0 ; i < M-1 ; i++){
			if(isAvail(route[i],route[i+1])){
				continue;
			} else {
				System.out.print("NO");
				return;
			}
		}

		System.out.print("YES");
	}

	static public boolean isAvail(int cur,int next){
		if(isSameGroup(cur, next)) return true;
		return false;
	}

	static public boolean isSameGroup(int a,int b){
		int ap = findRoot(a);
		int bp = findRoot(b);

		if( ap == 0 || bp == 0) return false;

		if(ap == bp ) return true;
		else return false;
	}

	static int findRoot(int a){
		if(parent[a] == a) return a;
		else return findRoot(parent[a]);
	}
}