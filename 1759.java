import java.io.*;
import java.util.*;

public class Main {
    
    static int L,C;
    static String[] targetArr,output;
    static int[] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] info = br.readLine().split(" ");
        L = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);
        
        visited = new int[C];
        output = new String[L];
        targetArr = br.readLine().split(" ");
        
        Arrays.sort(targetArr);
        
        combination(0,0,0,0);
    }
    
    static void combination(int depth, int consonantCount, int vowelCount, int start) {    // 재귀 깊이, 자음 갯수, 모음 갯수
        if(depth == L && consonantCount >= 2 && vowelCount >= 1) {
            for(int i=0; i<L; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }
        
        else if(depth == L) {
            return;
        }
        
        else {
            for(int i=start; i<C; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    output[depth] = targetArr[i];
                    if(targetArr[i].equals("a") || targetArr[i].equals("e") || targetArr[i].equals("i")
                    || targetArr[i].equals("o") || targetArr[i].equals("u")) {
                        combination(depth+1, consonantCount, vowelCount+1, i);
                    }
                    else {
                        combination(depth+1, consonantCount+1, vowelCount, i);
                    }
                    visited[i] = 0;
                }
            }    
        }
        
    }
}
