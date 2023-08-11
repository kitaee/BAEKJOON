import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int answer = 0;
    static int[] parent;
    static HashMap<Integer,Integer> map = new HashMap<>();
    
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
            String[] vInfo = br.readLine().split(" ");
            int v1 = Integer.parseInt(vInfo[0]);
            int v2 = Integer.parseInt(vInfo[1]);
            
            unionParent(v1, v2);
        }
        
        for(int i=1; i<N+1; i++) {
            if(!map.containsKey(findParent(i))) {
                map.put(findParent(i), 1);
                answer+=1;
            }
        }
        
        bw.write(String.valueOf(answer));
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
