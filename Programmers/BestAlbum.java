package Programmers;
import java.util.*;
public class  BestAlbum{
    public static void main(String[] args) throws Exception {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        List<Integer> result=solution(genres, plays);
        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<String, Integer> topGenres = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            topGenres.put(genres[i], topGenres.getOrDefault(genres[i], 0) + plays[i]);
            if (map.containsKey(genres[i])) {
                HashMap<Integer, Integer> temp = map.get(genres[i]);
                temp.put(i, plays[i]);
            } else {
                HashMap<Integer, Integer> temp = new LinkedHashMap<>();
                temp.put(i, plays[i]);
                map.put(genres[i], temp);
            }
        }
        List<Map.Entry<String,Integer>> list=new LinkedList<>(topGenres.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry:list) {
            HashMap<Integer, Integer> tempMap = map.get(entry.getKey());
            List<Map.Entry<Integer, Integer>> result = new LinkedList<>(tempMap.entrySet());
            Collections.sort(result,(o1,o2)->{
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            });
            if (result.size() > 1) {
                answer.add(result.get(0).getKey());
                answer.add(result.get(1).getKey());
            } else {
                answer.add(result.get(0).getKey());
            }
        }
        
        return answer;
    }
}