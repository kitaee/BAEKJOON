import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static String[][] arr;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new String[N][4];
        for(int i=0; i<N; i++) {
            String[] info = br.readLine().split(" ");
            for(int j=0; j<4; j++) {
                arr[i][j] = info[j];
            }
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {
            
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].equals(o2[1])) {
                    if(o1[2].equals(o2[2])) {
                        if(o1[3].equals(o2[3])) {
                            return o1[0].compareTo(o2[0]);
                        }
                        return -Integer.parseInt(o1[3]) + Integer.parseInt(o2[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return -Integer.parseInt(o1[1]) + Integer.parseInt(o2[1]);
            }
        });
        
        for(int i=0; i<N; i++) {
            bw.write(arr[i][0] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
