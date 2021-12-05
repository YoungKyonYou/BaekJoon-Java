package Kakao2017;

import java.util.*;

public class Brian {
    public static void main(String[] args) throws Exception {
        String sentence1 = "HaEaLaLaObWORLDb";
        String sentence2 = "SpIpGpOpNpGJqOqA";
        String sentence3 = "AxAxAxAoBoBoB";
        String sentence4 = "HaEaLaLaOYYK";
        String sentence5 = "HaEaLeLaO";
        String sentence6 = "HaEaLaLaOYbYbK";
        String sentence7 = "HaEaLaLaOYaYaK";
        System.out.println(solution(sentence5));
    }

    public static String solution(String sentence) {
        boolean one = false;
        boolean two = false;
        String ans = "";
        int start = 0;
        char cc = '\0';
        char pre = '\0';
        boolean[] alpha = new boolean[27];
        for (int i = 0; i < sentence.length(); i++) {

            // rule 1번
            if (Character.isUpperCase(sentence.charAt(start))) {
                // 대문자일때
                if (Character.isUpperCase(sentence.charAt(i))) {
                    // 대문자 두개가 이어지면 다른 단어임
                    if (i > 0 && Character.isUpperCase(sentence.charAt(i - 1))) {
                        ans += " " + sentence.charAt(i);
                        start = i;
                        cc = 0;
                        continue;
                    } else {
                        //대문자 넣어주기
                        ans += sentence.charAt(i);
                    }
                    // rule 1 continue
                } else if (sentence.charAt(i) == cc && sentence.charAt(i) == cc) {
                    continue;
                } else {
                    // 한번도 쓰지 않은 소문자 알파벳일 때
                    if (cc == '\0' || !alpha[cc - 'a']) {

                        cc = sentence.charAt(i);
                        //반복된 문자일 경우
                        if (alpha[cc - 'a']) {
                            ans = "invalid";
                            break;
                        }
                        alpha[cc - 'a'] = true;
                    } else {
                        ans = "invalid";
                        break;
                    }
                }
            } else {
                // rule 2
                // 한번도 쓰지 않은 알파벳일 때
                if (cc == '\0' || !alpha[cc - 'a']) {
                    cc = sentence.charAt(i);
                    alpha[cc - 'a'] = true;
                    continue;
                }
                // 끝에 소문자일때
                if (Character.isLowerCase(sentence.charAt(i)) && alpha[sentence.charAt(i) - 'a']) {
                    continue;
                    // 끝 소문자가 안 맞을때
                } else if (Character.isLowerCase(sentence.charAt(i)) && !alpha[sentence.charAt(i) - 'a']) {
                    ans = "invalid";
                    break;
                }

                if (Character.isUpperCase(sentence.charAt(i))) {
                    ans += sentence.charAt(i);
                }
            }
        }
        return ans;

    }
}