import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    static int T,N,S1,S2,D1,D2;
    static Queue<Node> queue;
    static int[][] visited;
    static int[] dx = {1,2,1,2,-1,-2,-1,-2};
    static int[] dy = {2,1,-2,-1,2,1,-2,-1};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            
            String[] start = br.readLine().split(" ");
            S1 = Integer.parseInt(start[0]);
            S2 = Integer.parseInt(start[1]);
            
            String[] end = br.readLine().split(" ");
            D1 = Integer.parseInt(end[0]);
            D2 = Integer.parseInt(end[1]);
            
            bw.write(String.valueOf(bfs()) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    public static int bfs() {
        queue = new LinkedList<>();
        visited = new int[N][N];
        visited[S1][S2] = 1;
        
        queue.offer(new Node(S1,S2,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(current.x == D1 && current.y == D2) {
                return current.count;
            }
            
            for(int i=0; i<8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Node(nx,ny,current.count+1));
                }
            }
        }
        return -1;
    }
}
