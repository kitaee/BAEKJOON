import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        graph = new int[N][M];
        dist = new int[N][M];
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<line.length(); j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
                dist[i][j] = -1;
            }
        }
        
        dist[0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M && dist[nx][ny] == -1 && graph[nx][ny] == 1) {
                    queue.offer(new Node(nx,ny));
                    dist[nx][ny] = dist[current.x][current.y] + 1;
                }
            }
        }
        
        bw.write(String.valueOf(dist[N-1][M-1]+1));
        bw.flush();
        bw.close();
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
