import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int position;
        int count;
        
        public Node(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }
    
    static int N,K;
    static int[] visited = new int[100000*2];
    static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);
        
        queue.offer(new Node(N,0));
        visited[N] = 1;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(current.position == K) {
                bw.write(String.valueOf(current.count));
                break;
            }
            
            if(current.position*2 < 100000*2 && visited[current.position*2] == 0) {
                queue.offer(new Node(current.position*2, current.count+1));
                visited[current.position*2] = 1;
            }
            
            if(current.position+1 < 100000*2 && visited[current.position+1] == 0) {
                queue.offer(new Node(current.position+1, current.count+1));
                visited[current.position+1] = 1;
            }
            
            if(current.position-1 >= 0 && visited[current.position-1] == 0) {
                queue.offer(new Node(current.position-1, current.count+1));
                visited[current.position-1] = 1;
            }
        }
        
        bw.flush();
        bw.close();
    }
}
