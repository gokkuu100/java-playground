import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Third {
    public static String fakeBin(String number) {
        StringBuilder result = new StringBuilder();

        for (char digit: number.toCharArray()) {
            if (digit < '5') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }

    public static long findNextPerfectSquare(long sq) {
        long a = sq;
        long b = sq;
        if (a != b) {
            return -1;
        };
        long result = a*b;
        long nextSq1 = sq +1, nextSq2 = sq +1;
        long newResult = nextSq1*nextSq2;
        if (result<newResult) {
            return newResult;
        }
        return newResult;
    }

    public static long  findNextSquare(long sq) {
        long sqrt = (long) Math.sqrt(sq);
        if (sqrt * sqrt == sq) {
            long nextSquare = (sqrt+1) * (sqrt+1);
            return nextSquare;
        } else {
            return -1;
        }
    }



    public static String findNeedle(Object[] haystack) {
        for (int i=0; i< haystack.length; i++) {
            if ("needle".equals(haystack[i])) {
                return "found the needle at position " + i;
            }
        }
        return "needle not found";
    }

    public static boolean check(Object[] a, Object[] x) {
        return Arrays.asList(a).contains(x);
    }

    public static int squareDigits(int n) {
        String numbers = String.valueOf(n);
        String[] numberList = numbers.split("");
        StringBuilder result = new StringBuilder();

        for (String num : numberList) {
            int numberInt = Integer.valueOf(num);
            result.append(numberInt*numberInt);
        }
        return Integer.parseInt(result.toString());
    }

    public static String[] wave(String str) {
        // Your code here
        List<String> waveList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;

            StringBuilder result = new StringBuilder(str);
            result.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            waveList.add(result.toString());
        }

        return waveList.toArray(new String[0]);
    }


    public static int points(String[] games) {
        int totalPoints = 0;

        for (String game : games) {
            String[] scores = game.split(":");
            int x = Integer.parseInt(scores[0]);
            int y = Integer.parseInt(scores[1]);

            if (x > y) {
                totalPoints += 3;
            } else if (x == y) {
                totalPoints += 1;
            }
        }

        return totalPoints;
    }

    public static void main(String[] args) {
        System.out.println(wave("Hello"));
        System.out.println(3%5);
    }
}
