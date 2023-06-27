import java.io.*;
import java.util.*;

public class Main {
    
    static int N,M;
    static int[] card;
    static int answer = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        
        String[] cardInfo = br.readLine().split(" ");
        card = new int[N];
        
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(cardInfo[i]);
        }
        
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    int sum = card[i]+card[j]+card[k];
                    if(sum <= M && sum > answer) {
                        answer = sum;
                    }
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
