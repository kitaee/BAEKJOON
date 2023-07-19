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
    
    static int answer = 0;
    static int N,L,R;
    static int[][] visited,graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int openCount;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        L = Integer.parseInt(info[1]);
        R = Integer.parseInt(info[2]);
        
        graph = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        while(true) {
            openCount = 0;
            visited = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j] == 0) {
                        openCount += bfs(i,j);
                    }
                }
            }
            if(openCount == 0) {
                break;
            }
            answer+=1;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    
    static int bfs(int x, int y) {
        ArrayList<Node> openList = new ArrayList<>();
        int sum = graph[x][y];
        int count = 1;
        Queue<Node> queue = new LinkedList<>();
        openList.add(new Node(x,y));
        queue.offer(new Node(x,y));
        visited[x][y] = 1;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && visited[nx][ny]==0) {
                    int difference = Math.abs(graph[nx][ny] - graph[current.x][current.y]);
                    if(L<=difference && difference<=R) {
                        count+=1;
                        sum+=graph[nx][ny];
                        queue.offer(new Node(nx,ny));
                        openList.add(new Node(nx,ny));
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
        
        if(openList.size() > 1) {
            for(int i=0; i<openList.size(); i++) {
                graph[openList.get(i).x][openList.get(i).y] = sum / count;
            }
        }
        
        return count-1;
    }
}
