import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] arr,visited,output;
    static LinkedHashSet<String> answer;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        arr = new int[N];
        visited = new int[N];
        output = new int[M];
        answer = new LinkedHashSet<>();
        
        String[] inputArr = br.readLine().split(" ");
        for(int i=0; i<inputArr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        
        Arrays.sort(arr);
        
        dfs(0,0);
        
        for(String ans : answer) {
            System.out.println(ans);
        }
    }
    
    static void dfs(int depth, int start) {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                sb.append(output[i] + " ");
            }
            answer.add(sb.toString());
            return;
        }
        
        for(int i=start; i<N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                output[depth] = arr[i];
                dfs(depth+1, i);
                visited[i] = 0;
            }
        }
    }
}
