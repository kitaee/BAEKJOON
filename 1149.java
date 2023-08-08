import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] dp;
    static int[][] color;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        color = new int[N][3];
        dp = new int[N][3];
        
        for(int i=0; i<N; i++) {
            String[] colorInfo = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                color[i][j] = Integer.parseInt(colorInfo[j]);
            }
        }
        
        dp[0][0] = color[0][0];
        dp[0][1] = color[0][1];
        dp[0][2] = color[0][2];
        
        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
        }
        
        for(int i=0; i<3; i++) {
            min = Math.min(min, dp[N-1][i]);
        }
        
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
