import java.io.*;
import java.util.*;

public class Main {
    
    static int N,P;
    static int[] arr;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        
        String[] info = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i+1] = Integer.parseInt(info[i]);
        }
        
        P = Integer.parseInt(br.readLine());
        for(int i=0; i<P; i++) {
            String[] inputSwitch = br.readLine().split(" ");
            if(inputSwitch[0].equals("1")) {
                switchForBoy(Integer.parseInt(inputSwitch[1]));
            }
            else {
                switchForGirl(Integer.parseInt(inputSwitch[1]));
            }
        }
        
        for(int i=1; i<arr.length; i++) {
            bw.write(String.valueOf(arr[i]) + " ");
            if(i % 20 == 0) {
                bw.write("\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
    
    static void switchForBoy(int num) {
        for(int i=1; i<100; i++) {
            if(num*i >= arr.length) {
                return;
            }
            switchBulb(num*i);
        }
    }
    
    static void switchForGirl(int num) {
        switchBulb(num);
        int index = 1;
        while(num-index>0 && num+index<arr.length && arr[num-index] == arr[num+index]) {
            switchBulb(num-index);
            switchBulb(num+index);
            index+=1;
        }
    }
    
    static void switchBulb(int num) {
        if(arr[num] == 1) {
            arr[num] = 0;
        }
        else {
            arr[num] = 1;
        }
    }
}
