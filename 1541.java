import java.io.*;
import java.util.*;

public class Main {
    
    static int answer = 0;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] subSentence = br.readLine().split("-");
        for(int i=0; i<subSentence.length; i++) {
            int sum = 0;
            String[] plusSentence = subSentence[i].split("\\+");
            for(int j=0; j<plusSentence.length; j++) {
                sum += Integer.parseInt(plusSentence[j]);
            }
            
            if(i==0) {
                answer += sum;
            }
            else {
                answer -= sum;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
