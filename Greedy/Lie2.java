package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Lie2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, total = 0;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수
        boolean[] truePeople = new boolean[51];
        int[] parent;
        // 1. union-find 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 2. 진실을 아는 사람 정보 받아오기 truePeople[진실을아는사람] == true
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            truePeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 3. 파티 정보를 받아오면서 같은 파티에 있는 사람들 union
        ArrayList<Integer>[] peoples = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            peoples[i] = new ArrayList<>();
        }
        int value, pre = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for (int j = 1; j < n; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value,parent); // 두명씩 union하면 모두가 같은 parent를 갖게 됨.
                pre = value;
            }
        }

        // 4. 진실을 아는 사람들의 parent는 같이 파티를 참여 했으므로 진실을 아는 사람들
        int p;
        for (int i = 1; i < truePeople.length; i++) {
            if (truePeople[i]) {
                truePeople[find(i,parent)] = true;
            }
        }

        // 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
        for (int i = 0; i < M; i++) {
            if (peoples[i].size() > 0) {
                p = find(peoples[i].get(0),parent);
                if (!truePeople[p])
                    total++;
            }
        }

        // 6. 거짓말 할 수 있는 파티 최대 수 출력
        System.out.println(total);
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return parent[x] = x;
        else
            return find(parent[x],parent);

    }

    private static boolean union(int a, int b, int[] parent) {
        a = find(a,parent);
        b = find(b,parent);

        if (a != b) {
            if (a > b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }

}