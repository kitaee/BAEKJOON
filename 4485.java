import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static int T = 1;
    static int N;
    static PriorityQueue<Node> queue;
    static int[][] graph,dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            
            graph = new int[N][N];
            dist = new int[N][N];
            
            for(int i=0; i<N; i++) {
                String[] info = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    graph[i][j] = Integer.parseInt(info[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            dijkstra();
            
            bw.write("Problem " + String.valueOf(T) + ": " + String.valueOf(dist[N-1][N-1]) + "\n");
            T+=1;
        }
        
        bw.flush();
        bw.close();
    }
    
    static void dijkstra() {
        queue = new PriorityQueue<>();
        queue.offer(new Node(0,0,graph[0][0]));
        dist[0][0] = graph[0][0];
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(current.x == N-1 && current.y == N-1) {
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N) {
                    if(dist[nx][ny] > dist[current.x][current.y] + graph[nx][ny]) {
                       dist[nx][ny] = dist[current.x][current.y] + graph[nx][ny];
                       queue.offer(new Node(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
    }
}
