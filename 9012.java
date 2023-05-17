import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            boolean condition = true;
            String inputString = br.readLine();
            for(int j=0; j<inputString.length(); j++) {
                if(inputString.charAt(j) == '(') {
                    stack.push(String.valueOf('('));
                }
                else {
                    if(stack.isEmpty()) {
                        condition = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(condition) {
                if(stack.size() > 0) {
                    bw.write("NO\n");
                }
                else {
                    bw.write("YES\n");
                }    
            }
            else {
                bw.write("NO\n");
            }
            
            stack.clear();
        }
        
        bw.flush();
        bw.close();
    }
}
