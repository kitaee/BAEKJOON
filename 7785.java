import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            String[] log = br.readLine().split(" ");
            if(log[1].equals("leave")) {
                map.remove(log[0]);
            }
            else {
                map.put(log[0], "enter");
            }
        }
        
        for(Map.Entry<String, String> entry : map.entrySet()) {
            answer.add(entry.getKey());
        }
        
        Collections.sort(answer, Collections.reverseOrder());
        
        for(String person : answer) {
            bw.write(person + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
