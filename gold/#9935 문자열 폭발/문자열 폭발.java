import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws IOException{
        String s1 = br.readLine();
        String s2 = br.readLine();

        int s2Length = s2.length();

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0 ; i < s1.length() ; i++){
            stack.push(s1.charAt(i));

            if(stack.size() >= s2Length && stack.peek() == s2.charAt(s2Length-1)){
                Deque<Character> tmpStack = new ArrayDeque<>();
                boolean isC4 = true;
                for(int j = s2Length-1 ; j >= 0 ; j --){
                    if(stack.peek() == s2.charAt(j)){
                        tmpStack.push(stack.pop());
                    } else {
                        isC4 = false;
                        break;
                    }
                }

                if(!isC4){
                    while(!tmpStack.isEmpty()){
                        stack.push(tmpStack.pop());
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        System.out.println(sb.toString());
    }
}