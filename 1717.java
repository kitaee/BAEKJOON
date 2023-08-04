import java.io.*;
import java.util.*;

public class Main {
    
    static int[] parent;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        parent = new int[N+1];
        for(int i=0; i<N+1; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            String[] command = br.readLine().split(" ");
            int a = Integer.parseInt(command[0]);
            int b = Integer.parseInt(command[1]);
            int c = Integer.parseInt(command[2]);
            
            if(a == 0) {
                unionParent(b, c);
            }
            else {
                if(findParent(b) == findParent(c)) {
                    sb.append("YES\n");
                }
                else {
                    sb.append("NO\n");
                }
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        node = parent[node];
        return findParent(node);
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
