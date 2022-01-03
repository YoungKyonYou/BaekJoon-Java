package Programmers;

import java.util.*;

public class BestAlbum2 {
    public static void main(String[] args) throws Exception {
        String[] genres = { "classic", "pop", "classic", "classic", "pop","pop","pop" };
        int[] plays = { 500, 600, 150, 800, 2500 ,2500,2500};
        int[] result = solution(genres, plays);
        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
        HashMap<String, Integer> hmGenres = new HashMap<>();
        //hmGenres에 key: 장르 value: 플레이 합산 수
        for (int i = 0; i < genres.length; i++) {
            hmGenres.put(genres[i], hmGenres.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 장르의 set를 넣음
        List<String> keySetList = new ArrayList<>(hmGenres.keySet());

        //장르를 플레이 합산 수의 내림차순으로 정렬
        Collections.sort(keySetList, (o1, o2) -> (hmGenres.get(o2).compareTo(hmGenres.get(o1))));

        for (String key : keySetList) {
            HashMap<Integer, Integer> hs = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    hs.put(i, plays[i]);
                }
            }

            List<Integer> keyLists = new ArrayList<>(hs.keySet());
            keyLists.sort((s1, s2) -> {
                if (hs.get(s1).equals(hs.get(s2))) {
                    return s1 - s2;
                }
                return hs.get(s2) - hs.get(s1);
            });
            int j = 0;
            for (Integer c : keyLists) {
                if (j > 1) {
                    break;
                }
                arrAnswer.add(c);
                j++;
            }
        }
        answer = new int[arrAnswer.size()];
        for (int i = 0; i < arrAnswer.size(); i++) {
            answer[i] = arrAnswer.get(i);
        }
        return answer;

    }
}