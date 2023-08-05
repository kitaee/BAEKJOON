import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int T;
    static int M,N,K;
    static int[][] visited, graph;
    static LinkedList<Node> queue;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] info = br.readLine().split(" ");
            M = Integer.parseInt(info[0]);
            N = Integer.parseInt(info[1]);
            K = Integer.parseInt(info[2]);
            int answer = 0;
            
            graph = new int[N][M];
            visited = new int[N][M];
            queue = new LinkedList<>();
            
            for(int j=0; j<K; j++) {
                String[] cabbage = br.readLine().split(" ");
                graph[Integer.parseInt(cabbage[1])][Integer.parseInt(cabbage[0])] = 1;
            }
            
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(visited[j][k] == 0 && graph[j][k] == 1) {
                        answer+=1;
                        bfs(j,k);
                    }
                }
            }
            
            bw.write(String.valueOf(answer) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int x, int y) {
        visited[x][y] = 1;
        graph[x][y] = 1;
        queue.offer(new Node(x, y));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M && graph[nx][ny]==1 && visited[nx][ny]==0) {
                    queue.offer(new Node(nx,ny));
                    graph[nx][ny] = 0;
                    visited[nx][ny] = 1;
                }
            }
        }
    }
}
