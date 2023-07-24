import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int info = Integer.parseInt(br.readLine());
            
            if(info == 0) {
                if(!queue.isEmpty()) {
                    bw.write(queue.poll() + "\n");  
                }
                else {
                    bw.write(String.valueOf(0) + "\n");
                }
                
            }
            else {
                queue.offer(info);
            }
        }
        
        bw.flush();
        bw.close();
    }
}
