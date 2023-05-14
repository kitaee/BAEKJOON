import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      List<Integer> remainList = new ArrayList<>();
      
      for(int i=0; i<10; i++) {
          int num = sc.nextInt();
          int remain = num % 42;
          
          if (!remainList.contains(remain)) {
              remainList.add(remain);
          }
      }
      
      System.out.print(remainList.size());
    }
}
