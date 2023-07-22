import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static ArrayList<Integer> count = new ArrayList<>();
    static int[] student;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        student = new int[N*2];
        String[] info = br.readLine().split(" ");
        
        for(int i=0; i<N*2; i++) {
            student[i] = Integer.parseInt(info[i]);
        }
        
        Arrays.sort(student);
        
        for(int i=0; i<N; i++) {
            count.add(student[i] + student[N*2-i-1]);
        }
        
        bw.write(String.valueOf(Collections.min(count)));
        bw.flush();
        bw.close();
    }
}
