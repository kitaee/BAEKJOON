import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] arr;
    static int[] dp;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        arr = new int[N];
        dp = new int[N];
        String[] arrInfo = br.readLine().split(" ");
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(arrInfo[i]);
        }
        
        dp[0] = arr[0];
        for(int i=1; i<N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        
        for(int i=0; i<M; i++) {
            String[] sectionInfo = br.readLine().split(" ");
            int start = Integer.parseInt(sectionInfo[0]);
            int end = Integer.parseInt(sectionInfo[1]);
            
            if(start == 1) {
                bw.write(String.valueOf(dp[end-1]) + "\n");
            }
            else {
                bw.write(String.valueOf(dp[end-1] - dp[start-2]) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
