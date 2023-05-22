import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        
        for(int i=0; i<N; i++) {
            if(map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i])+1);
            }
            else {
                map.put(numbers[i], 1);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        String[] targetNumbers = br.readLine().split(" ");
        
        for(int i=0; i<M; i++) {
            if(!map.containsKey(targetNumbers[i])) {
                bw.write("0 ");   
            }
            else {
                bw.write(String.valueOf(map.get(targetNumbers[i])) + " ");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
