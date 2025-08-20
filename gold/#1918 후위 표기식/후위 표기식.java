import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            // 곱셈 나눗셈
            if(s.charAt(i)=='*' || s.charAt(i)=='/'){
                if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    sb.append(String.valueOf(stack.pop()));
                    stack.push(s.charAt(i));
                } else {
                    stack.push(s.charAt(i));
                }
            } else if(s.charAt(i)=='+' || s.charAt(i)=='-'){
                // 덧셈 뻴셈
                if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    while(!(stack.isEmpty() || stack.peek() == '(')){
                        sb.append(String.valueOf(stack.pop()));
                    }
                    stack.push(s.charAt(i));
                } else if(!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')){
                    while(!(stack.isEmpty() || stack.peek() == '(')){
                        sb.append(String.valueOf(stack.pop()));
                    }
                    stack.push(s.charAt(i));
                } else {
                    stack.push(s.charAt(i));
                }
            } else if(s.charAt(i) == '('){
                // 괄호 열고
                stack.push('(');
            } else if(s.charAt(i) == ')'){
                // 괄호 닫고
                while(stack.peek() != '('){
                    sb.append(String.valueOf(stack.pop()));
                }
                stack.pop();
            } else {
                sb.append(String.valueOf(s.charAt(i)));
            }
        }

        while(!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }

        System.out.println(sb.toString());
    }
}