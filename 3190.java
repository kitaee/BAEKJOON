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
    
    static int N,K,L;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int direction = 1;
    // 0 : LEFT, 1 : RIGHT, 2 : UP, 3 : DOWN
    static int time = 0;
    
    static int[][] graph;
    static ArrayList<int[]> snakeBody = new ArrayList<>();
    static HashMap<Integer, String> directions = new HashMap<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        
        for(int i=0; i<K; i++) {
            String[] appleInfo = br.readLine().split(" ");
            graph[Integer.parseInt(appleInfo[0])-1][Integer.parseInt(appleInfo[1])-1] = 1;  // 사과 세팅
        }
        
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
            String[] directionInfo = br.readLine().split(" ");
            directions.put(Integer.parseInt(directionInfo[0]), directionInfo[1]);
        }
        
        traverse();
        
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
    
    static void traverse() {
        Node current = new Node(0,0);
        snakeBody.add(new int[] {0,0});
        
        while(true) {
            if(directions.containsKey(time)) {
                if(directions.get(time).equals("D")) {  // 오른쪽으로 회전인 경우
                    if(direction == 0) {
                        direction = 2;
                    }
                    else if(direction == 1) {
                        direction = 3;
                    }
                    else if(direction == 2) {
                        direction = 1;
                    }
                    else {
                        direction = 0;
                    }
                }
                else {  // 왼쪽으로 회전인 경우
                    if(direction == 0) {
                        direction = 3;
                    }
                    else if(direction == 1) {
                        direction = 2;
                    }
                    else if(direction == 2) {
                        direction = 0;
                    }
                    else {
                        direction = 1;
                    }
                }
            }
            
            time+=1;
            
            int nx = current.x + dx[direction];
            int ny = current.y + dy[direction];
            
            // 뱀이 죽는 경우 (1. 벽에 부딪히는 경우, 2. 자기 몸에 부딪히는 경우)
            
            // 1. 벽에 부딪히는 경우
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return;
            }
            
            // 2. 자기 몸에 부딪히는 경우
            for(int i=0; i<snakeBody.size(); i++) {
                if(nx == snakeBody.get(i)[0] && ny == snakeBody.get(i)[1]) {
                    return;
                }
            }
            
            // 뱀이 죽지 않은 경우 (머리 집어넣기 전에, 사과 체크해서 꼬리 빼기)
            if(graph[nx][ny] == 1) {    // 사과를 먹은 경우
                graph[nx][ny] = 0;
            }
            else {
                snakeBody.remove(0);
            }
            
            // 사과를 먹든 안먹든 머리는 집어넣어야함
            snakeBody.add(new int[] {nx,ny});
            
            current.x = nx;
            current.y = ny;
        }
    }
}
