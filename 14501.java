import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] t,p;
    static ArrayList<Integer> sum = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];
        
        for(int i=0; i<N; i++) {
            String[] info = br.readLine().split(" ");
            t[i] = Integer.parseInt(info[0]);
            p[i] = Integer.parseInt(info[1]);
        }
        
        dfs(0,0);
        
        bw.write(String.valueOf(Collections.max(sum)));
        bw.flush();
        bw.close();
    }
    
    static void dfs(int start, int tempSum) {
        if(start > N) {
            return;
        }
        
        sum.add(tempSum);
        
        for(int i=start; i<N; i++) {
            dfs(i+t[i], tempSum+p[i]);
            dfs(i+1, tempSum);
        }
    }
}
