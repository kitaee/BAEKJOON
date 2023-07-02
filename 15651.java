import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] arr,visited,output;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        arr = new int[N];
        visited = new int[N];
        output = new int[M];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        duplicatedPermutation(0);
        
        System.out.println(sb);
    }
    
    static void duplicatedPermutation(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0; i<N; i++) {
            output[depth] = i+1;
            duplicatedPermutation(depth+1);
        }
    }
}
