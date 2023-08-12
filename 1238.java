import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int start;
        int cost;
        
        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node nd) {
            return this.cost - nd.cost;
        }
        
    }
    
    static int N,M,X;
    static int[] dist, dist2;
    static ArrayList<ArrayList<Node>> tempGraph = new ArrayList<>();
    static PriorityQueue<Node> queue;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] basicInfo = br.readLine().split(" ");
        N = Integer.parseInt(basicInfo[0]);
        M = Integer.parseInt(basicInfo[1]);
        X = Integer.parseInt(basicInfo[2]);
        
        dist = new int[N+1];
        
        for(int i=0; i<N+1; i++) {
            dist[i] = Integer.MAX_VALUE;
            tempGraph.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
            String[] roadInfo = br.readLine().split(" ");
            tempGraph.get(Integer.parseInt(roadInfo[0])).add(new Node(Integer.parseInt(roadInfo[1]), Integer.parseInt(roadInfo[2])));
        }
        
        dijkstra();
        
        for(int i=1; i<N+1; i++) {
            if(i == X) {
                continue;
            }
            dijkstra2(i);
        }
        
        for(int i=1; i<N+1; i++) {
            if(dist[i] > max) {
                max = dist[i];
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    
    static void dijkstra() {
        dist[X] = 0;
        queue = new PriorityQueue<>();
        queue.offer(new Node(X,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<tempGraph.get(current.start).size(); i++) {
                if(dist[tempGraph.get(current.start).get(i).start] > dist[current.start] + tempGraph.get(current.start).get(i).cost) {
                    dist[tempGraph.get(current.start).get(i).start] = dist[current.start] + tempGraph.get(current.start).get(i).cost;
                    queue.offer(new Node(tempGraph.get(current.start).get(i).start, dist[tempGraph.get(current.start).get(i).start]));
                }
            }
        }
    }
    
    static void dijkstra2(int index) {
        dist2 = new int[N+1];
        for(int i=0; i<N+1; i++) {
            dist2[i] = Integer.MAX_VALUE;
        }
        dist2[index] = 0;
        
        queue = new PriorityQueue<>();
        queue.offer(new Node(index,0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i=0; i<tempGraph.get(current.start).size(); i++) {
                if(dist2[tempGraph.get(current.start).get(i).start] > dist2[current.start] + tempGraph.get(current.start).get(i).cost) {
                    dist2[tempGraph.get(current.start).get(i).start] = dist2[current.start] + tempGraph.get(current.start).get(i).cost;
                    queue.offer(new Node(tempGraph.get(current.start).get(i).start, dist[tempGraph.get(current.start).get(i).start]));
                }
            }
        }
        dist[index] += dist2[X];
    }
}
