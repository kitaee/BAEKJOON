import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[][] graph;
    static int[] parent;
    static int count = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[M][3];
        parent = new int[N+1];
        
        for(int i=0; i<N+1; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            String[] info = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(info[0]);
            graph[i][1] = Integer.parseInt(info[1]);
            graph[i][2] = Integer.parseInt(info[2]);
        }
        
        Arrays.sort(graph, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] dist1, int[] dist2) {
                return dist1[2] - dist2[2];
            }
        });
        
        for(int i=0; i<M; i++) {
            if(findParent(graph[i][0]) != findParent(graph[i][1])) {
                count+=graph[i][2];
                unionParent(graph[i][0], graph[i][1]);
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
    
    static int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        
        return parent[node] = findParent(parent[node]);
    }
    
    static void unionParent(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        
        if(node1 < node2) {
            parent[node2] = node1;
        }
        else {
            parent[node1] = node2;
        }
    }
}
