import java.io.*;
import java.util.*;

public class Main {
    
    static int N,count1,count2;
    static int[] arr1,arr2,target;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        count1 = 0;
        count2 = 1;
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];
        target = new int[N];
        
        String inputArr = br.readLine();
        for(int i=0; i<N; i++) {
            arr1[i] = Character.getNumericValue(inputArr.charAt(i));
        }
        
        String targetArr = br.readLine();
        for(int i=0; i<N; i++) {
            target[i] = Character.getNumericValue(targetArr.charAt(i));
        }
        
        for(int i=0; i<N; i++) {
            arr2[i] = arr1[i];
        }
        
        switchBulb(arr2, 0);
        
        for(int i=1; i<N; i++) {
            if(arr1[i-1] != target[i-1]) {
                switchBulb(arr1, i);
                count1+=1;
            }
            if(arr2[i-1] != target[i-1]) {
                switchBulb(arr2, i);
                count2+=1;
            }
        }
        
        if(!Arrays.equals(arr1, target)) {
            count1 = Integer.MAX_VALUE;
        }
        
        if(!Arrays.equals(arr2, target)) {
            count2 = Integer.MAX_VALUE;
        }
        
        if(count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else {
            System.out.print(Math.min(count1, count2));
        }
    }
    
    static void switchBulb(int[] arr, int index) {
        if(index == 0) {
            change(arr, 0);
            change(arr, 1);
        }
        else if(index == N-1) {
            change(arr, N-1);
            change(arr, N-2);
        }
        else {
            change(arr, index-1);
            change(arr, index);
            change(arr, index+1);
        }
    }
    
    static void change(int arr[], int index) {
        if(arr[index] == 0) {
            arr[index] = 1;
        }
        else {
            arr[index] = 0;
        }
    }
}
