import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(); // 결과 저장용
    
    public static void main(String[] args) throws Exception {
        while (true) {
            List<String> currentCommandList = new ArrayList<>();
            List<Long> currentNumValues = new ArrayList<>(); 

            while (true) {
                String line = br.readLine();
                if (line == null) { 
                    System.out.print(sb.toString());
                    return;
                }
                
                String[] parts = line.split(" ");
                String command = parts[0];

                if (command.equals("QUIT")) {
                    System.out.print(sb.toString());
                    return; // 전체 프로그램 종료
                } else if (command.equals("END")) {
                    break; 
                }

                currentCommandList.add(command);
                if (command.equals("NUM")) {
                    currentNumValues.add(Long.parseLong(parts[1])); 
                }
            }

            int testCaseCount = Integer.parseInt(br.readLine()); 

            for (int i = 0; i < testCaseCount; i++) {
                Stack<Long> stack = new Stack<>(); // 각 테스트 케이스마다 스택 초기화
                long initialValue = Long.parseLong(br.readLine()); // 각 테스트 케이스의 초기 스택 값 읽기
                stack.push(initialValue);

                // 현재 명령어 블록을 가지고 스택 플레이
                playStack(stack, currentCommandList, currentNumValues);
                
            }
            sb.append("\n");
            br.readLine(); 
        }
    }

    // 스택을 플레이하는 함수 (테스트 케이스마다 호출됨)
    public static void playStack(Stack<Long> stack, List<String> commands, List<Long> numValues) {
        int numValueIndex = 0; // numValues 리스트에서 현재 사용할 인덱스
        boolean isError = false;

        for (String command : commands) {
            try { // 각 연산마다 에러 여부 확인 및 처리
                if (command.equals("NUM")) {
                    if (numValueIndex < numValues.size()) { // 저장된 NUM 값이 있는지 확인
                        stack.push(numValues.get(numValueIndex++));
                    } else {
                        isError = true; // NUM 명령어가 있는데 해당하는 값이 없는 경우 (논리적 오류)
                        break;
                    }
                } else if (command.equals("POP")) {
                    if (stack.isEmpty()) throw new Exception();
                    stack.pop();
                } else if (command.equals("INV")) {
                    if (stack.isEmpty()) throw new Exception();
                    stack.push(-stack.pop());
                } else if (command.equals("DUP")) {
                    if (stack.isEmpty()) throw new Exception();
                    stack.push(stack.peek());
                } else if (command.equals("SWP")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop();
                    long tmp2 = stack.pop();
                    stack.push(tmp1);
                    stack.push(tmp2);
                } else if (command.equals("ADD")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop();
                    long tmp2 = stack.pop();
                    long result = tmp1 + tmp2;
                    // 오버플로우/언더플로우 검사 (절댓값이 10^9 초과)
                    if (Math.abs(result) > 1_000_000_000L ||
                        (tmp1 > 0 && tmp2 > 0 && result < 0) || // 양수+양수=음수 (오버플로우)
                        (tmp1 < 0 && tmp2 < 0 && result > 0)    // 음수+음수=양수 (언더플로우)
                    ) {
                        throw new Exception();
                    }
                    stack.push(result);
                } else if (command.equals("SUB")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop(); // 첫 번째 pop이 빼는 수
                    long tmp2 = stack.pop(); // 두 번째 pop이 빼지는 수
                    long result = tmp2 - tmp1;
                    if (Math.abs(result) > 1_000_000_000L ||
                        (tmp2 > 0 && tmp1 < 0 && result < 0) || // 양수 - 음수 = 음수 (오버플로우)
                        (tmp2 < 0 && tmp1 > 0 && result > 0)    // 음수 - 양수 = 양수 (언더플로우)
                    ) {
                        throw new Exception();
                    }
                    stack.push(result);
                } else if (command.equals("MUL")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop();
                    long tmp2 = stack.pop();
                    long result = tmp1 * tmp2;
                    if (Math.abs(result) > 1_000_000_000L ||
                        (tmp1 != 0 && result / tmp1 != tmp2) // 0이 아닌 수로 나눴을 때 본래 값이 아니면 오버플로우
                    ) {
                        throw new Exception();
                    }
                    stack.push(result);
                } else if (command.equals("DIV")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop(); // 나눌 수
                    long tmp2 = stack.pop(); // 나누어지는 수
                    if (tmp1 == 0) throw new Exception(); 
                    long result = tmp2 / tmp1;
                    stack.push(result);
                } else if (command.equals("MOD")) {
                    if (stack.size() < 2) throw new Exception();
                    long tmp1 = stack.pop(); // 나머지 연산에 사용될 수
                    long tmp2 = stack.pop(); // 나누어지는 수
                    if (tmp1 == 0) throw new Exception(); // 0으로 나누기
                    
                    long result = tmp2 % tmp1;
                    stack.push(result);
                }
            } catch (Exception e) {
                isError = true; // 연산 중 에러 발생
                break;
            }
        }

        // 모든 명령어 처리 후 결과 확인
        if (isError || stack.size() != 1 || Math.abs(stack.peek()) > 1_000_000_000L) {
            sb.append("ERROR\n");
        } else {
            sb.append(stack.pop()).append("\n");
        }
    }
}