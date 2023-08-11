import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] dp;
    static int answer = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        
        for(int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][2] + dp[i-1][0];
            dp[i][2] = dp[i-1][1] + dp[i-1][0];
            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }
        
        for(int i=0; i<3; i++) {
            answer += dp[N][i];
        }
        
        bw.write(String.valueOf(answer%9901));
        bw.flush();
        bw.close();
    }
}
