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

    public static boolean feast(String beast, String dish) {

        return false;

    }


    public static void main(String[] args) {
        int[] myList = {8,8,6,4,7,3,2};
        System.out.println(min(myList));
        System.out.println(max(myList));
    }
}
