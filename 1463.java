import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int value;
        int count;
        
        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    
    static int N;
    static int[] visited;
    static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        visited = new int[N+1];
        visited[N] = 1;
        queue.offer(new Node(N,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.value == 1) {
                bw.write(String.valueOf(current.count));
                break;
            }
            
            if(current.value % 3 == 0 && visited[current.value/3] == 0) {
                queue.offer(new Node(current.value/3, current.count+1));
                visited[current.value/3] = 1;
            }
            
            if(current.value % 2 == 0 && visited[current.value/2] == 0) {
                queue.offer(new Node(current.value/2, current.count+1));
                visited[current.value/2] = 1;
            }
            
            if(visited[current.value-1] == 0) {
                queue.offer(new Node(current.value-1, current.count+1));
                visited[current.value-1] = 1;
            }
        }
        
        bw.flush();
        bw.close();
    }
}
