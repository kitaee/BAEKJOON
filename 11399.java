import java.io.*;
import java.util.*;

public class Main {
    
    static int[] arr;
    static int sum = 0;
    static int N;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        String[] info = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<N; i++) {
            sum += (arr[i]*(N-i));
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
