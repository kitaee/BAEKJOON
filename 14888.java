import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] nums,operations;
    static int MAX_VALUE = Integer.MIN_VALUE;
    static int MIN_VALUE = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operations = new int[4];
        
        String[] numInfo = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(numInfo[i]);
        }
        
        String[] operationInfo = br.readLine().split(" ");
        for(int i=0; i<4; i++) {
            operations[i] = Integer.parseInt(operationInfo[i]);
        }
        
        dfs(nums[0], 1);
        
        bw.write(String.valueOf(MAX_VALUE) + "\n");
        bw.write(String.valueOf(MIN_VALUE) + "\n");
        
        bw.flush();
        bw.close();
    }
    
    static void dfs(int num, int index) {
        if(index == N) {
            MAX_VALUE = Math.max(num, MAX_VALUE);
            MIN_VALUE = Math.min(num, MIN_VALUE);
        }
        
        for(int i=0; i<4; i++) {
            if(operations[i] > 0) {
                operations[i]-=1;
                
                switch(i) {
                    case 0:
                        dfs(num + nums[index], index+1);
                        break;
                    case 1:
                        dfs(num - nums[index], index+1);
                        break;
                    case 2:
                        dfs(num * nums[index], index+1);
                        break;
                    case 3:
                        dfs(num / nums[index], index+1);
                        break;
                }
                operations[i]+=1;
            }
        }
    }
}
