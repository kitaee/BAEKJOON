import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static PriorityQueue<Integer> queue;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        queue = new PriorityQueue<>(new Comparator<Integer>() {
           
           @Override
           public int compare(Integer num1, Integer num2) {
               if(Math.abs(num1) == Math.abs(num2)) {
                   return num1 - num2;
               }
               
               return Math.abs(num1) - Math.abs(num2);
           }
        });
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                if(queue.isEmpty()) {
                    bw.write(String.valueOf(0) + "\n");
                }
                else {
                    bw.write(String.valueOf(queue.poll()) + "\n");
                }
            }
            else {
                queue.offer(command);
            }
        }
        
        bw.flush();
        bw.close();
    }
}
