import java.io.*;
import java.util.*;

public class Main {
    
    static int N,W,L;
    static int sum = 0;
    static int index = 0;
    static LinkedList<Integer> bridge = new LinkedList<>();
    static int time = 1;
    static int[] car;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] basicInfo = br.readLine().split(" ");
        N = Integer.parseInt(basicInfo[0]);
        L = Integer.parseInt(basicInfo[2]);
        W = Integer.parseInt(basicInfo[1]);
        
        car = new int[N];
        String[] carInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            car[i] = Integer.parseInt(carInfo[i]);
        }
        
        for(int i=0; i<W; i++) {
            bridge.offer(0);
        }
        
        while(true) {
            sum -= bridge.poll();
            
            if(index <= N-1 && sum + car[index] <= L) {
                bridge.offer(car[index]);
                sum+=car[index];
                index+=1;
            }
            else {
                bridge.offer(0);
            }
            
            time+=1;
            
            if(index == N && sum == 0) {
                break;
            }
        }
        
        bw.write(String.valueOf(time-1));
        bw.flush();
        bw.close();
    }
}
