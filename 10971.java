import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] cost;
    static int[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        visited = new int[N];
        
        for(int i=0; i<N; i++) {
            String[] costInfo = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                cost[i][j] = Integer.parseInt(costInfo[j]);
            }
        }
        
        for(int i=0; i<N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i,i,0,0);
            }
        }
        
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
    
    static void dfs(int start, int now, int depth, int sum) {
        if(depth == N-1) {
            if(cost[now][start] != 0) {
                sum += cost[now][start];
                min = Math.min(min, sum);
            }
            return;
        }
        
        for(int i=0; i <N; i++) {
            if(visited[i]==0 && cost[now][i] > 0) {
                visited[i] = 1;
                dfs(start, i, depth+1, sum+cost[now][i]);
                visited[i] = 0;
            }
        }
    }
}
