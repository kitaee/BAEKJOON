import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static String[][] arr;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new String[N][2];
        
        for(int i=0; i<N; i++) {
            String[] info = br.readLine().split(" ");
            arr[i][0] = info[0];
            arr[i][1] = info[1];
        }
        
        Arrays.sort(arr, new Comparator<String[]>(){
           
           @Override
           public int compare(String[] o1, String[] o2) {
               return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
           }
        });
        
        for(int i=0; i<N; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
