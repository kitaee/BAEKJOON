import java.io.*;
import java.util.*;

public class Main {
    
    static int T;
    static int N;
    static int[] graph;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int maxValue = 0;
            long sum = 0;
            N = Integer.parseInt(br.readLine());
            graph = new int[N];
            
            String[] graphInfo = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                graph[j] = Integer.parseInt(graphInfo[j]);
            }
            
            for(int j=N-1; j>=0; j--) {
                if(graph[j] > maxValue) {
                    maxValue = graph[j];
                }
                else {
                    sum += (maxValue-graph[j]);
                }
            }
            
            bw.write(String.valueOf(sum) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
