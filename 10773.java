import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                sum-=stack.pop();
            }
            else {
                stack.push(num);
                sum+=num;
            }
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
