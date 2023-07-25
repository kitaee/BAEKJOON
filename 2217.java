import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] weight;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        
        for(int i=0; i<N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(weight);
        
        
		for (int i=0; i<N; i++) {
			max = Math.max(max, weight[i] * (N - i));
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
    }
}
