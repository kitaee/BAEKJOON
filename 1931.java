import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] rooms;
    static int count = 1;
    static long time;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        rooms = new int[N][2];
        for(int i=0; i<N; i++) {
            String[] roomInfo = br.readLine().split(" ");
            rooms[i][0] = Integer.parseInt(roomInfo[0]);
            rooms[i][1] = Integer.parseInt(roomInfo[1]);
        }
        
        Arrays.sort(rooms, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
        
        
        time = rooms[0][1];
        for(int i=1; i<N; i++) {
            if(rooms[i][0] >= time) {
                time = rooms[i][1];
                count+=1;
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
