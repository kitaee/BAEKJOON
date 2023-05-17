import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<N; i++) {
            String[] command = br.readLine().split(" ");
            
            if(command[0].equals("push")) {
                stack.push(Integer.parseInt(command[1]));
            }
            
            else if(command[0].equals("top") && stack.isEmpty()) {
                bw.write("-1" + "\n");
            }
            
            else if(command[0].equals("top") && !stack.isEmpty()) {
                bw.write(stack.peek() + "\n");
            }
            
            else if(command[0].equals("size")) {
                bw.write(stack.size() + "\n");
            }
            
            else if(command[0].equals("empty") && stack.isEmpty()) {
                bw.write("1" + "\n");
            }
            
            else if(command[0].equals("empty") && !stack.isEmpty()) {
                bw.write("0" + "\n");
            }
            
            else if(command[0].equals("pop") && !stack.isEmpty()) {
                bw.write(stack.pop() + "\n");
            }
            
            else if(command[0].equals("pop") && stack.isEmpty()) {
                bw.write("-1" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
