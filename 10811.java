import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] arr = new int[N];
      
      for(int i=0; i<N; i++) {
          arr[i] = i+1;
      }
      
      for(int k=0; k<M; k++) {
          
        int order1 = sc.nextInt() - 1;
		int order2 = sc.nextInt() - 1;
			
		while (order1 < order2) {
    		int temp = arr[order1];
    		arr[order1++] = arr[order2];
    		arr[order2--] = temp;
		}
      }
      
      for(int i=0; i<N; i++) {
          System.out.print(arr[i] + " ");
      }
    }
}
