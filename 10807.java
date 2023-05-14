import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int answer = 0;
      int count = sc.nextInt();
      int[] arr = new int[count];
      
      for(int i=0; i<count; i++) {
          arr[i] = sc.nextInt();
      }
      
      int target = sc.nextInt();
      
      for(int i=0; i<count; i++) {
          if (target == arr[i]) {
              answer+=1;
          }
      }
      System.out.print(answer);
    }
}
