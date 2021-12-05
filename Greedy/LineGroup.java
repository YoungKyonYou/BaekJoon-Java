package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LineGroup {
    public static class Line {
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N + 1];
        Line[] list = new Line[N];
        for (int i = 1; i <= 3; i++) {
            map[i] = i;
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            list[i - 1] = new Line(x1, y1, x2, y2);
        }
        
    }
    public static void solution() {

    }
}