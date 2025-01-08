import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            Solution(start, dest);
        }
    }

    public static void Solution(int start, int dest) {
			List<List<String>> arr = new ArrayList<>();
      for (int i = 0; i < 10000; i++) {
        arr.add(new ArrayList<>());
      }

      Queue<Integer> q = new LinkedList<>();
      q.add(start);

      while (!q.isEmpty()) {
        int cur = q.poll();
        if (cur == dest) {
          break; // 도착점에 도달하면 종료
				}

        // D
        int D = (cur * 2) % 10000;
        if (D != cur && arr.get(D).isEmpty() || arr.get(D).size() > arr.get(cur).size() + 1) {
          arr.set(D,new ArrayList<>(arr.get(cur)));
          arr.get(D).add("D");
          q.add(D);
        }

        // S
        int S = (cur == 0) ? 9999 : cur - 1;
        if (S != cur && arr.get(S).isEmpty() || arr.get(S).size() > arr.get(cur).size() + 1) {
					arr.set(S,new ArrayList<>(arr.get(cur)));
					arr.get(S).add("S");
					q.add(S);
				}

        // L
        int a = cur / 1000;
        int b = (cur / 100) % 10;
        int c = (cur / 10) % 10;
        int d = cur % 10;
        int L = b * 1000 + c * 100 + d * 10 + a;
        if (L != cur && arr.get(L).isEmpty() || arr.get(L).size() > arr.get(cur).size() + 1) {
					arr.set(L,new ArrayList<>(arr.get(cur)));
					arr.get(L).add("L");
					q.add(L);
				}

        // R
        int R = d * 1000 + a * 100 + b * 10 + c;
        if (R != cur && arr.get(R).isEmpty() || arr.get(R).size() > arr.get(cur).size() + 1) {
					arr.set(R,new ArrayList<>(arr.get(cur)));
					arr.get(R).add("R");
					q.add(R);
				}
        }

      StringBuilder sb = new StringBuilder();
      for (String s : arr.get(dest)) {
        sb.append(s);
      }
      System.out.println(sb);
    }
}
