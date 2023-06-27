import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int answer = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<N; i++) {
            if(isAccumulateSum(i)) {
                answer = i;
                break;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    
    static boolean isAccumulateSum(int num) {
        int sum = num;
        String tempNum = String.valueOf(num);
        for(int i=0; i<tempNum.length(); i++) {
            sum+=(Character.getNumericValue(tempNum.charAt(i)));
        }
        
        if(sum == N) {
            return true;
        }
        return false;
    }
}
