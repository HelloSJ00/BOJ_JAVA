import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[50001];

		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		List<Integer> three = new ArrayList<>();


		// 하나의 제곱수로 나타낼수 있는 수
		int tmp = 1;
		while(tmp*tmp <= 50000){
			one.add(tmp*tmp);
			dp[tmp*tmp] = 1;
			tmp++;
		}

		// 두개의 제곱수로 나타낼 수 있는 수
		int sum ;
		for(int i = 0; i < one.size() ; i++){
			for(int j = 0 ; j < one.size() ; j ++){
				sum = one.get(i)+one.get(j);
				if( sum <= 50000 && (dp[sum] > 2 || dp[sum] == 0)){
					dp[sum] = 2;
					two.add(sum);
				}
			}
		}

		// 세개의 제곱수로 나타낼수 있는 수 
		for(int i = 0; i < one.size() ; i ++){
			for(int j = 0 ; j < two.size(); j++){
				sum = one.get(i) + two.get(j);
				if( sum <= 50000 && (dp[sum] > 3 || dp[sum] == 0)){
					dp[sum] = 3;
					three.add(sum);
				}
			}
		}

		for(int i = 0; i <one.size() ; i ++){
			for(int j = 0 ; j < three.size(); j++){
				sum = one.get(i) + three.get(j);
				if( sum<= 50000 && (dp[sum] > 4 || dp[sum] == 0)){
					dp[sum] = 4;
				}
			}
		}

		System.out.print(dp[N]);
	}
}