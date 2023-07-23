import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[][] graph;
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1};
    
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
        
        // 가로열 세팅
        for(int i=1; i<M; i++) {
            graph[0][i] += graph[0][i-1];
        }
        
        // 세로열 세팅
        for(int i=1; i<N; i++) {
            graph[i][0] += graph[i-1][0];
        }
        
        // 나머지 세팅
        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                graph[i][j] = Math.max(graph[i-1][j] + graph[i][j], graph[i][j-1] + graph[i][j]);
            }
        }
        
        bw.write(String.valueOf(graph[N-1][M-1]));
        bw.flush();
        bw.close();
    }
}
