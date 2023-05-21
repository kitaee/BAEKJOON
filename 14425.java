import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        String[] numbers = br.readLine().split(" ");
        int N = Integer.parseInt(numbers[0]);
        int M = Integer.parseInt(numbers[1]);
        int answer = 0;
        
        for(int i=0; i<N; i++) {
            String inputString = br.readLine();
            map.put(inputString, 1);
        }
        
        for(int i=0; i<M; i++) {
            String targetString = br.readLine();
            if(map.containsKey(targetString)) {
                answer+=1;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
