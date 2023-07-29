import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
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
    
    static int N,M;
    static int[][] graph, dist;
    static PriorityQueue<Node> queue;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        graph = new int[M][N];
        dist = new int[M][N];
        
        for(int i=0; i<M; i++) {
            String graphInfo = br.readLine();
            for(int j=0; j<N; j++) {
                graph[i][j] = Character.getNumericValue(graphInfo.charAt(j));
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dijkstra();
        
        bw.write(String.valueOf(dist[M-1][N-1]));
        bw.flush();
        bw.close();
    }
    
    static void dijkstra() {
        queue = new PriorityQueue<>();
        dist[0][0] = 0;
        queue.offer(new Node(0,0,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.x == M-1 && current.y == N-1) {
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;
                
                if(0<=nx && nx<M && 0<=ny && ny<N) {
                    if(dist[nx][ny] > dist[current.x][current.y] + graph[nx][ny]) {
                        dist[nx][ny] = dist[current.x][current.y] + graph[nx][ny];
                        queue.offer(new Node(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
    }
}
