import java.io.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int sequenceNumber = 1; // 스택에 넣어야할 값
        boolean status = true;
        
        stack.push(0);
        
        for(int i=0; i<N; i++) {
            int targetNumber = Integer.parseInt(br.readLine());
            if(stack.peek() == targetNumber) {
                stack.pop();
                answer.add("-");
            }
            else if(stack.peek() < targetNumber) {
                if(sequenceNumber > targetNumber) {
                    status = false;
                    break;
                }
                else {
                    while(stack.peek() < targetNumber) {
                        stack.push(sequenceNumber);
                        sequenceNumber+=1;
                        answer.add("+");
                    }
                    stack.pop();
                    answer.add("-");
                }
            }
            else {
                while(stack.peek() >= targetNumber) {
                    stack.pop();
                    answer.add("-");
                }
            }
        }
        
        if(status) {
            for(int i=0; i<answer.size(); i++) {
                bw.write(answer.get(i) + "\n");
            }
        }
        else {
            bw.write("NO");
        }
        
        bw.flush();
        bw.close();
    }
}
