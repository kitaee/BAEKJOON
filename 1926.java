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
    static int[][] visited;
    static ArrayList<Integer> answer;
    static Queue<Node> queue;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        graph = new int[N][M];
        visited = new int[N][M];
        answer = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String[] connection = br.readLine().split(" ");
            for(int j=0; j<connection.length; j++) {
                graph[i][j] = Integer.parseInt(connection[j]);
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(graph[i][j] == 1 && visited[i][j] == 0) {
                    answer.add(bfs(i,j));
                }
            }
        }
        
        Collections.sort(answer);
        
        if(answer.isEmpty()) {
            bw.write(String.valueOf(answer.size()) + "\n");
            bw.write(String.valueOf(0) + "\n");
        }
        else {
            bw.write(String.valueOf(answer.size()) + "\n");
            bw.write(String.valueOf(answer.get(answer.size()-1)) + "\n");    
        }
        
        bw.flush();
        bw.close();
    }
    
    static int bfs(int x, int y) {
        int count = 1;
        queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y] = 1;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    queue.offer(new Node(nx,ny));
                    visited[nx][ny] = 1;
                    count+=1;
                }
            }
        }
        
        return count;
    }
}
