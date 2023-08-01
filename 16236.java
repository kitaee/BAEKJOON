import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] graph;
    static int time = 0;    // 시간
    static int count = 0;   // 먹은 물고기 개수
    static int size = 2;    // 상어 크기
    static int xIndex, yIndex;         // 현재 상어 위치
    static PriorityQueue<Node> queue = new PriorityQueue<>(); // 현재 지점에서 가장 가까운 물고기를 찾기 위한 우선순위 큐
    static LinkedList<Node> traverseQueue;  // BFS로 거리를 구하기 위해 쓰일 큐
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Node node) {
            if(this.dist == node.dist) {
                if(this.x == node.x) {
                    return this.y - node.y;
                }
                return this.x - node.x;
            }
            return this.dist - node.dist;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        
        for(int i=0; i<N; i++) {
            String[] info = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                int tempInfo = Integer.parseInt(info[j]);
                if(tempInfo == 9) {
                    xIndex = i;
                    yIndex = j;
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = tempInfo;
            }
        }
        
        while(true) {
            traverse();
            if(queue.isEmpty()) {
                bw.write(String.valueOf(time));
                break;
            }
            else {
                Node nearestNode = queue.poll();
                time += nearestNode.dist;
                graph[nearestNode.x][nearestNode.y] = 0;
                xIndex = nearestNode.x;
                yIndex = nearestNode.y;
                count+=1;
                
                if(count == size) {
                    size+=1;
                    count = 0;
                }
            }
            queue.clear();
        }
        
        bw.flush();
        bw.close();
    }
    
    static void traverse() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(graph[i][j] != 0 && graph[i][j] < size) {
                    Node targetNode = new Node(i,j,getDist(i,j));
                    if(targetNode.dist != -1) {
                        queue.offer(targetNode);
                    }
                }
            }
        }
    }
    
    static int getDist(int tempX, int tempY) {
        int[][] visited = new int[N][N];
        traverseQueue = new LinkedList<>();
        visited[xIndex][yIndex] = 1;
        traverseQueue.offer(new Node(xIndex,yIndex,0));
        
        while(!traverseQueue.isEmpty()) {
            Node current = traverseQueue.poll();
            if(current.x == tempX && current.y == tempY) {
                return current.dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && visited[nx][ny]==0 && graph[nx][ny]<=size) {
                    traverseQueue.offer(new Node(nx,ny,current.dist+1));
                    visited[nx][ny] = 1;
                }
            }
        }
        return -1;
    }
}
