import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];
        int[] visited = new int[N+1];
        
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            String[] connect = br.readLine().split(" ");
            graph[Integer.parseInt(connect[0])][Integer.parseInt(connect[1])] = 1;
            graph[Integer.parseInt(connect[1])][Integer.parseInt(connect[0])] = 1;
        }
        
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()) {
            int computer = queue.remove();
            for(int i=1; i<=N; i++) {
                if(graph[computer][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    answer+=1;
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
