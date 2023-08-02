import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M,V;
    static int[] visited;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> queue = new LinkedList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        V = Integer.parseInt(info[2]);
        
        graph = new int[N+1][N+1];
        visited = new int[N+1];
        
        for(int i=0; i<M; i++) {
            info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            graph[start][end] = graph[end][start] = 1;
        }
        
        dfs(V);
        sb.append("\n");
        visited = new int[N+1];
        bfs(V);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static void dfs(int now) {
        visited[now] = 1;
        sb.append(String.valueOf(now) + " ");
        
        for(int i=1; i<N+1; i++) {
            if(graph[now][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
    
    static void bfs(int now) {
        visited[now] = 1;
        sb.append(String.valueOf(now) + " ");
        queue.offer(now);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i=1; i<N+1; i++) {
                if(graph[current][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                    sb.append(String.valueOf(i) + " ");
                }
            }
        }
    }
}
