import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] arr;
    static long answer = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<N; i++) {
            answer += Math.abs(i+1-arr[i]);
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
