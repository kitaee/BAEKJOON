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
    
    static int N,M;
    static int[][] graph;
    static ArrayList<Integer> count = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        graph = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        dfs(0);
        
        bw.write(String.valueOf(Collections.max(count)));
        bw.flush();
        bw.close();
    }
    
    static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(wall + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }
    
    static void bfs() {
        int safeArea = 0;
        Queue<Node> queue = new LinkedList<>();
        int[][] virusGraph = new int[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                virusGraph[i][j] = graph[i][j];
                if(virusGraph[i][j] == 2) {
                    queue.offer(new Node(i,j));
                }
            }
        }
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M && virusGraph[nx][ny]==0) {
                    virusGraph[nx][ny] = 2;
                    queue.offer(new Node(nx,ny));
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virusGraph[i][j] == 0) {
                    safeArea+=1;
                }
            }
        }
        
        count.add(safeArea);
    }
}
