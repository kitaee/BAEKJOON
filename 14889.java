import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] power;
    static int[] arr,output,visitied;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int MAX_VALUE = Integer.MIN_VALUE;
    static ArrayList<Integer> powerList = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        arr = new int[N];
        output = new int[N/2];
        visitied = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                power[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        dfs(0,0);
        
        for(int i=0; i<powerList.size()/2; i++) {
            answer.add(Math.abs(powerList.get(i) - powerList.get(powerList.size()-i-1)));
        }
        
        bw.write(String.valueOf(Collections.min(answer)));
        bw.flush();
        bw.close();
    }
    
    static void dfs(int depth, int start) {
        if(depth == N/2) {
            powerList.add(getPower(output));
            return;
        }
        
        for(int i=start; i<N; i++) {
            if(visitied[i] == 0) {
                visitied[i] = 1;
                output[depth] = arr[i];
                dfs(depth+1, i);
                visitied[i] = 0;
            }
        }
    }
    
    static int getPower(int[] cases) {
        int sum = 0;
        for(int i=0; i<cases.length; i++) {
            for(int j=0; j<cases.length; j++) {
                sum += power[cases[i]-1][cases[j]-1];
            }
        }
        return sum;
    }
}
