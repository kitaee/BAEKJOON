import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    
    public static int N,M,START,END;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] dist;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        dist = new int[N+1];
        for(int i=0; i<N+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<M; i++) {
            String[] info = br.readLine().split(" ");
            int v1 = Integer.parseInt(info[0]);
            int v2 = Integer.parseInt(info[1]);
            int w = Integer.parseInt(info[2]);
            graph.get(v1).add(new Node(v2,w));
        }
        
        String[] target = br.readLine().split(" ");
        START = Integer.parseInt(target[0]);
        END = Integer.parseInt(target[1]);
        
        dist[START] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(START, 0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            if(dist[current.index] < current.cost) {
                continue;
            }
            
            for(int i=0; i<graph.get(current.index).size(); i++) {
                Node nextNode = graph.get(current.index).get(i);
                if(dist[nextNode.index] > dist[current.index] + nextNode.cost) {
                    dist[nextNode.index] = dist[current.index] + nextNode.cost;
                    queue.offer(new Node(nextNode.index, nextNode.cost));
                }
            }
        }
        
        bw.write(String.valueOf(dist[END]));
        bw.flush();
        bw.close();
    }
}
