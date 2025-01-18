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


    public static void main(String[] args) {
        String[] myArray = {"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"};

        System.out.println(findNextPerfectSquare(11));
        System.out.println(findNextSquare(144));
        System.out.println(findNeedle(myArray));
    }
}
