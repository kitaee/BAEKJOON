import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static long count,sum;
    static int[] price,distance;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        sum = 0;
        N = Integer.parseInt(br.readLine());
        price = new int[N];
        distance = new int[N-1];
        
        String[] distanceInfo = br.readLine().split(" ");
        for(int i=0; i<N-1; i++) {
            distance[i] = Integer.parseInt(distanceInfo[i]);
        }
        
        String[] priceInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            price[i] = Integer.parseInt(priceInfo[i]);
        }
        
        int index = 0;
        
        while(index < N-1) {
            count = distance[index];
            for(int i=index+1; i<N; i++) {
                if(price[index] >= price[i]) {
                    sum += (count*price[index]);
                    count = 0;
                    index = i;
                    break;
                }
                else {
                    if(i==N-1) {
                        sum += (count*price[index]);
                        index = i;
                        break;
                    }
                    count += distance[i];
                }
            }
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
