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
    
    public static int N;
    public static int[][] graph;
    public static int[][] visited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<Node> queue;
    public static ArrayList<Integer> answer;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      N = Integer.parseInt(br.readLine());
      graph = new int[N][N];
      visited = new int[N][N];
      answer = new ArrayList<>();
      
      for(int i=0; i<N; i++) {
          String info = br.readLine();
          for(int j=0; j<N; j++) {
              graph[i][j] = Character.getNumericValue(info.charAt(j));
          }
      }
      
      for(int i=0; i<N; i++) {
          for(int j=0; j<N; j++) {
              if(graph[i][j] == 1 && visited[i][j] == 0) {
                  answer.add(bfs(i,j));
              }
          }
      }
      
      Collections.sort(answer);
      
      bw.write(String.valueOf(answer.size()) + "\n");
      for(int i=0; i<answer.size(); i++) {
          bw.write(String.valueOf(answer.get(i)) + "\n");
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
                
                if(0<=nx && nx < N && 0<=ny && ny<N && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    count+=1;
                    queue.offer(new Node(nx,ny));
                    visited[nx][ny] = 1;
                }
            }
        }
        
        return count;
    }
}
