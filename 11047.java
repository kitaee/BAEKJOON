import java.io.*;
import java.util.*;

public class Main {
    
    static int N,K,count;
    static int[] coins;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);
        count = 0;
        
        coins = new int[N];
        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=N-1; i>=0; i--) {
            if(K == 0) {
                break;
            }
            
            if(K/coins[i] > 0) {
                count += K/coins[i];
                K = K%coins[i];
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
