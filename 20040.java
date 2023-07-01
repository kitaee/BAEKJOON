import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] parent;
    static int answer = 1;
    static boolean isCycle = false;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        parent = new int[N];
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            String[] connection = br.readLine().split(" ");
            int v1 = Integer.parseInt(connection[0]);
            int v2 = Integer.parseInt(connection[1]);
            
            if(findParent(v1) == findParent(v2)) {
                isCycle = true;
                break;
            }
            unionParent(v1, v2);
            answer+=1;
        }
        
        if(isCycle) {
            bw.write(String.valueOf(answer));
        }
        else {
            bw.write("0");
        }
        
        bw.flush();
        bw.close();
    }
    
    static int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        return findParent(parent[node]);
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
