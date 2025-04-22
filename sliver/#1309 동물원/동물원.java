import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 3;
		for(int i = 2 ; i <= n ; i++){
			arr[i] = (2*arr[i-1] + arr[i-2])%9901;
		}
		System.out.print(arr[n]);
	}
}