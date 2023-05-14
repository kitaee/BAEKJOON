import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int max = -1000000;
      int min = 1000000;
      
      for(int i=0; i<N; i++) {
          int num = sc.nextInt();
          if (num > max) {
              max = num;
          }
          if (num < min) {
              min = num;
          }
      }
      
      System.out.print(min + " " + max);
    }
}
