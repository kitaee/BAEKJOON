import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] arr,visited,output;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        arr = new int[N];
        visited = new int[N];
        output = new int[M];
        
        String[] inputArr = br.readLine().split(" ");
        for(int i=0; i<inputArr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        
        Arrays.sort(arr);
        
        dfs(0,0);
        
        System.out.println(sb);   
    }
    
    static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=start; i<N; i++) {
            output[depth] = arr[i];
            dfs(depth+1, i);
        }
    }
}
