import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] arr,visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        arr = new int[N];
        visited = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        combination(0,M);
    }
    
    static void combination(int depth, int r) {
        if(r == 0) {
            for(int i=0; i<N; i++) {
                if(visited[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
        else if(depth == arr.length) {
            return;
        }
        else {
            visited[depth] = 1;
            combination(depth+1, r-1);
            visited[depth] = 0;
            combination(depth+1, r);
        }
    }
}
