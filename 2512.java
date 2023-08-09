import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] money;
    static int min,max;
    static long answer;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        money = new int[N];
        
        String[] moneyInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(moneyInfo[i]);
        }
        
        M = Integer.parseInt(br.readLine());
        
        Arrays.sort(money);
        min = 0;
        max = money[N-1];
        
        while(min <= max) {
            int sum = 0;
            int mid = (min+max)/2;
            for(int i=0; i<N; i++) {
                if(money[i] > mid) {
                    sum += mid;
                }
                else {
                    sum += money[i];
                }
            }
            
            if(sum > M) {
                max = mid-1;
            }
            else {
                min = mid+1;
                answer = mid;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
