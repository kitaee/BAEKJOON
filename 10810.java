import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] bucket = new int[N];
      
      for(int count=0; count<M; count++) {
          int i = sc.nextInt();
          int j = sc.nextInt();
          int k = sc.nextInt();
          
          for(int a = i-1; a<j; a++) {
              bucket[a] = k;
          }
      }
      
      for(int count=0; count<N; count++) {
          System.out.print(bucket[count] + " ");
      }
    }
}
