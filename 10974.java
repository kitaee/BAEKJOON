import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] arr,visited,output;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        output = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        permutation(0,N,N);
    }
    
    static void permutation(int depth, int n, int r) {
        if(depth == r) {
            for(int i=0; i<r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                output[depth] = arr[i];
                permutation(depth+1, n, r);
                visited[i] = 0;
            }
        }
    }
}
