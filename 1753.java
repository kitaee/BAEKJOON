import java.io.*;
import java.util.*;

public class Main {
    
    static class Node{
        int num;
        int weight;
        
        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    
    public static int V,E,K;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] dist;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);
        K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=V; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i=0; i<E; i++) {
            String[] connection = br.readLine().split(" ");
            int u = Integer.parseInt(connection[0]);
            int v = Integer.parseInt(connection[1]);
            int w = Integer.parseInt(connection[2]);
            
            graph.get(u).add(new Node(v,w));
        }
        
        dist = new int[V+1];
        for(int i=0; i<=V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.weight, o2.weight));
        queue.offer(new Node(K,0));
        dist[K] = 0;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(dist[current.num] < current.weight) {
                continue;
            }
            
            for(int i=0; i<graph.get(current.num).size(); i++) {
                Node next = graph.get(current.num).get(i);
                
                if(dist[next.num] > current.weight + next.weight) {
                    dist[next.num] = current.weight + next.weight;
                    queue.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
        
        for(int i=1; i<=V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            }
            else {
                bw.write(String.valueOf(dist[i]) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
