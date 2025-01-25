import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class Codewars {
    public static int min(int[] list) {
        int[] sorted = stream(list).sorted().toArray();
        return sorted[0];
    }

    public static int max(int[] list) {
        int[] sorted = stream(list).sorted().toArray();
        return sorted[sorted.length-1];
    }

    public static int howOld(final String herOld) {
        String age = Character.toString(herOld.charAt(0));
        return Integer.parseInt(age);
    }

    public static List<String> friend(List<String> x){
        List<String> friends = new ArrayList<>();
        for (String name: x) {
            if (name.length()<=4) {
                friends.add(name);
            }
        }
        return friends;
    }


    public static void main(String[] args) {
        int[] myList = {8,8,6,4,7,3,2};
        List<String> names = List.of("John", "Mark", "Amy", "Paul", "Elizabeth");
        System.out.println(min(myList));
        System.out.println(max(myList));
        System.out.println(friend(names));
    }
}
