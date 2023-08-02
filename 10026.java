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
    
    static int N, count;
    static int[][] visited;
    static String[][] graph;
    static LinkedList<Node> queue;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        graph = new String[N][N];
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                graph[i][j] = String.valueOf(line.charAt(j));
            }
        }
        
        visited = new int[N][N];
        count = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] == 0) {
                    case1(i,j);
                    count+=1;
                }
            }
        }
        
        bw.write(String.valueOf(count) + " ");
        
        visited = new int[N][N];
        count = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] == 0) {
                    case2(i,j);
                    count+=1;
                }
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
    
    static void case1(int x, int y) {
        visited[x][y] = 1;
        queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && visited[nx][ny]==0 && graph[nx][ny].equals(graph[current.x][current.y])) {
                    visited[nx][ny] = 1;
                    queue.offer(new Node(nx,ny));
                }
            }
        }
    }
    
    static void case2(int x, int y) {
        visited[x][y] = 1;
        queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && visited[nx][ny]==0) {
                    if(graph[current.x][current.y].equals("B")) {
                        if(graph[nx][ny].equals("B")) {
                            visited[nx][ny] = 1;
                            queue.offer(new Node(nx,ny));
                        }
                    }
                    else {
                        if(graph[nx][ny].equals("G") || graph[nx][ny].equals("R")) {
                            visited[nx][ny] = 1;
                            queue.offer(new Node(nx,ny));
                        }
                    }
                }
            }
        }
    }
}
