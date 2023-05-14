import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] bucket = new int[N];
      
      for(int i=0; i<N; i++) {
          bucket[i] = i+1;
      }
      
      for(int count=0; count<M; count++) {
          int i = sc.nextInt()-1;
          int j = sc.nextInt()-1;
          
          int temp = bucket[i];
          bucket[i] = bucket[j];
          bucket[j] = temp;
      }
      
      for(int i=0; i<N; i++) {
          System.out.print(bucket[i] + " ");
      }
    }
}
