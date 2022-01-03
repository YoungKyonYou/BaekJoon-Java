package ESTSoft;
import java.util.*;
public class  test{
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        String s1 = "Hi";
        String s2 = "Hi";
        String s3 = "Hi";
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(new String("Hi"));
        set.add(new String("Hi"));
        set.add(new String("Hi"));
        set.add(new String("Hi"));
        System.out.println(new String("test"));
        System.out.println(set.size());
    }
    public static void solution() {

    }
}