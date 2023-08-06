import java.io.*;
import java.util.*;

public class Main {
    
    static int T,N;
    static String[] phone;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            phone = new String[N];
            for(int j=0; j<N; j++) {
                phone[j] = br.readLine();
            }
            
            if(isStartWith()) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
    
    static boolean isStartWith() {
        Arrays.sort(phone);
        for(int i=1; i<N; i++) {
            if(phone[i].startsWith(phone[i-1])) {
                return false;
            }
        }
        return true;
    }
}
