import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        
        while(true) {
            String sentence = br.readLine();
            boolean condition = true;
            if(sentence.equals(".")) {
                break;
            }
            
            for(int i=0; i<sentence.length(); i++) {
                if(sentence.charAt(i) == '[') {
                    stack.push(0);
                }
                else if(sentence.charAt(i) == '(') {
                    stack.push(1);
                }
                else if(sentence.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek() == 0) {
                        stack.pop();
                    }
                    else {
                        condition = false;
                        break;
                    }
                }
                else if(sentence.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == 1) {
                        stack.pop();
                    }
                    else {
                        condition = false;
                        break;
                    }
                }
                else {
                    continue;
                }
            }
            if(condition && stack.isEmpty()) {
                bw.write("yes\n");
            }
            else {
                bw.write("no\n");
            }
            stack.clear();
        }
        
        bw.flush();
        bw.close();
    }
}
