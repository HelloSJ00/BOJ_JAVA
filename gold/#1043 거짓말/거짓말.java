import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> peoples = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++){
			peoples.add(new ArrayList<>());
		}

		int trigger = 0;
		// 진실을 아는 사람들 
		st = new StringTokenizer(br.readLine());
		int knowTruthPeoples = Integer.parseInt(st.nextToken());
		if(knowTruthPeoples == 1){
			int tmp = Integer.parseInt(st.nextToken());
			trigger = tmp;

		} else if(knowTruthPeoples > 1){
			int tmp = Integer.parseInt(st.nextToken());
			trigger = tmp;

			int prev = tmp;
			for(int i = 1; i < knowTruthPeoples ; i++){
				int next = Integer.parseInt(st.nextToken());
				peoples.get(prev).add(next);
				peoples.get(next).add(prev);
				prev = next;
			}
		} else{
			System.out.print(M);
			return;
		}

		List<List<Integer>> party = new ArrayList<>();
		for(int i = 0 ; i < M ; i ++){
			party.add(new ArrayList<>());

			st = new StringTokenizer(br.readLine());
			int curPeoples = Integer.parseInt(st.nextToken());

			for(int j = 0 ; j < curPeoples ; j++){
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}

		}
		
		for(int i = 0 ; i < M ; i++){
			int partySize = party.get(i).size();
			if(partySize > 1){
				int prev = party.get(i).get(0);
				for(int j = 1 ; j < partySize ; j++ ){
					int next = party.get(i).get(j);
					peoples.get(prev).add(next);
					peoples.get(next).add(prev);
					prev = next;
				}
			}
		}

		Map<Integer,Integer> knowTruth = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(trigger);
		knowTruth.put(trigger,1);

		while(!q.isEmpty()){
			int cur = q.poll();
			for(int next : peoples.get(cur)){
				if(!knowTruth.containsKey(next)){
					knowTruth.put(next,1);
					q.add(next);
				}
			}
		}


		int answer = 0;
		for(List<Integer> curParty : party){
			boolean flag = true;
			for(int curPeople : curParty){
				if(knowTruth.containsKey(curPeople)){
					flag = false;
					break;
				}
			}
			if(flag) answer ++;
		}

		System.out.print(answer);
		}
}