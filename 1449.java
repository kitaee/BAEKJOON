import java.io.*;
import java.util.*;

public class Main {
    
    static int N,L;
    static int count = 0;
    static int[] water;
    static double index = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        L = Integer.parseInt(info[1]);
        
        water = new int[N];
        String[] waterInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            water[i] = Integer.parseInt(waterInfo[i]);
        }
        
        Arrays.sort(water);
        
        index = water[0] - 0.5;
        index+=L;
        count+=1;
        
        for(int i=1; i<N; i++) {
            if(water[i]+0.5 > index) {
                index = water[i] - 0.5 + L;
                count+=1;
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
