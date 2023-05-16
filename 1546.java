import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = 0;
        double average = 0;
        int N = sc.nextInt();
        int[] score = new int[N];
        
        for(int i=0; i<N; i++) {
            score[i] = sc.nextInt();
            if(M < score[i]) {
                M = score[i];
            }
        }
        
        for(int i=0; i<N; i++) {
            average+=(((double)score[i]/M)*100);
        }
        
        System.out.print(average/N);
    }
}
