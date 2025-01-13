import java.util.Arrays;

public class Main {
    final int x = 5;
    private String name;

    // getter
    public String getName() {
        return name;
    }
    // setter
    public void setName(String newName) {
        this.name = newName;
    }

    public static Integer basicMath(String op, int v1, int v2) {
        return switch (op) {
            case "+" -> v1 + v2;
            case "-" -> v1 - v2;
            case "*" -> v1 * v2;
            case "/" -> v1 / v2;
            default -> 0;
        };
    }
    public static String noWhites(String m) {
        return m.replaceAll("\\s", "");
    }
    public static String convertBoolean(boolean m) {
        return (m == true) ? "True" : "False";
    }
    public static String removeChar(String m) {
        return m.substring(1, m.length()-1);
    }

    public static String repeatedStr(int n, String m) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i =0; i<n; i++) {
            result.append(m);
        }
        return result.toString();
    }

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5};
        double[] m = {1.1,2,3.2};
        System.out.println(removeChar("hello"));
        System.out.println(convertBoolean(false));
        System.out.println(basicMath("*", 5,4));
        System.out.println(repeatedStr(5, "hope"));
        System.out.println(noWhites("h o pepe hope e"));
        Main myObj = new Main();
        myObj.setName("Prince");
        System.out.println(myObj.getName());

    }
}