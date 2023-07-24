import java.io.*;
import java.util.*;

public class Main {
    
    static int x,y;
    static int N,M;
    static int r,c,d;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] graph;
    static int count = 0;
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        String[] robotInfo = br.readLine().split(" ");
        r = Integer.parseInt(robotInfo[0]);
        c = Integer.parseInt(robotInfo[1]);
        d = Integer.parseInt(robotInfo[2]);
        
        x = r;
        y = c;
        
        graph = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        while(true) {
            
            boolean isCleanGraphExist = false;
            
            if(graph[x][y] == 0) {
                count+=1;
                graph[x][y] = 2;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(graph[nx][ny] == 0) {
                        isCleanGraphExist = true;
                        break;
                    }
                }
            }
            
            if(!isCleanGraphExist) { // 현재 칸의 주변 4칸 중, 청소되지 않은 빈칸이 있는 경우
                if(d == 0) {
                    x+=1;
                }
                else if(d == 1) {
                    y-=1;
                }
                else if(d == 2) {
                    x-=1;
                }
                else {
                    y+=1;
                }
                
                if(0<=x && x<N && 0<=y && y<M && graph[x][y]!=1) {
                    continue;
                }
                else {
                    break;
                }
            }
            else {  // 현재 칸의 주변 4칸 중, 쳥소되지 않은 빈칸이 없는 경우
                while(true) {
                    d-=1;
                    if(d < 0) {
                        d+=4;
                    }
                    
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if(0<=nx && nx<N && 0<=ny && ny<M && graph[nx][ny]==0) {
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
