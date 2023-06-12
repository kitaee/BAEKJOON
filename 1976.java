import java.io.*;

public class Main {
    
    public static int[] parent = new int[201];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean isConnected = true;
        
        for(int i=1; i<= N; i++) {
            parent[i] = i;
        }
        
        for(int i=1; i<=N; i++) {
            String[] connection = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                if(connection[j].equals("1")) {
                    unionParent(i, j+1);
                }
            }
        }
        
        String[] plan = br.readLine().split(" ");
        int targetParent = findParent(Integer.parseInt(plan[0]));
        for(int i=1; i<M; i++) {
            if(findParent(Integer.parseInt(plan[i])) != targetParent) {
                bw.write("NO");
                isConnected = false;
                break;
            }
        }
        
        if(isConnected) {
            bw.write("YES");
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
