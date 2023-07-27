import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] arr,output,visited;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        output = new int[N];
        visited = new int[N];
        
        String[] arrInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(arrInfo[i]);
        }
        
        dfs(0);
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    
    static void dfs(int depth) {
        if(depth == N) {
            calculate(output);
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                output[depth] = arr[i];
                dfs(depth+1);
                visited[i] = 0;
            }
        }
    }
    
    static void calculate(int[] tempArr) {
        int sum = 0;
        for(int i=0; i<N-1; i++) {
            sum += Math.abs(tempArr[i]-tempArr[i+1]);
        }
        max = Math.max(max, sum);
    }
}
