import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        
        String[] inputNumbers = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            cardMap.put(Integer.parseInt(inputNumbers[i]), 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        
        String[] targetNumbers = br.readLine().split(" ");
        
        for(int i=0; i<M; i++) {
            
            int targetNumber = Integer.parseInt(targetNumbers[i]);
    
            if(cardMap.containsKey(targetNumber)) {
                bw.write("1 ");
            }
            else {
                bw.write("0 ");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
