import java.util.Arrays;

public class Second {
    public static int nbYear(int p0, double percent, int aug, int p) {

        int years = 0;
        double currentPopulation = p0;

        while (currentPopulation < p) {
            currentPopulation += Math.floor((currentPopulation * (percent / 100)) + aug);
            years++;
        }
        return years;
    }

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }

    public static String evenOrOdd(int number) {
        return number%2==0 ? "Even": "Odd";
    }

    public static int countSheeps(boolean[] arrayOfSheeps) {
        if (arrayOfSheeps == null) {
            return 0;
        }
        int numPresent = 0;
        for (boolean sheep: arrayOfSheeps) {
            if (sheep) {
                numPresent++;
            }
        }
        return numPresent;
    }

    public static String printerError(String s) {
        int error = 0;
        int length = s.length();

        for (char c: s.toCharArray()) {
            if (c<'a' || c>'m') {
                error++;
            }
        }
        return error + "/" + length;
    }

    public static boolean zeroFuel(double distanceToPomp, double mpg, double fuelLeft) {
        double distanceCoverable = mpg * fuelLeft;

        return (distanceCoverable>=distanceToPomp) ? true: false;
    }

    public static void  evenLength(String myStr) {
        for (String w: myStr.split(" ")) {
            if (w.length() % 2 == 0) {
                System.out.println(w);
            }
        }
    }

    public static void insertString(String myStr) {
        StringBuffer s = new StringBuffer(myStr);
        String toInsert ="For";
        s.insert(4, toInsert);
        System.out.println(s.toString());
    }

    public static void reverseString(char[] myArray) {
        int left = 0;
        int right = myArray.length -1;
        while (left < right) {
            char temp = myArray[left];
            myArray[left] = myArray[right];
            myArray[right] = temp;

            left++;
            right--;
        }
    }

    public static boolean isPalindrome(String myStr) {
        myStr=myStr.toLowerCase();

        String rev = "";
        for (int i = myStr.length() - 1; i >= 0; i--) {
            rev = rev + myStr.charAt(i);
        }
        return myStr.equals(rev);
    }

    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str1.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i<arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public static String convertToInitials(String name) {
        String[] parts = name.split(" ");
        String initials = parts[0].substring(0,1).toUpperCase() + "." + parts[1].substring(0,1).toUpperCase();
        return initials;
    }

    public static String fakeBin(String numberString) {
        StringBuilder result = new StringBuilder();
        for (char digit: numberString.toCharArray()) {
            if (digit < '5') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        boolean[] myArray = {true,  true,  true,  false,
                true,  true,  true,  true ,
                true,  false, true,  false,
                true,  false, false, true ,
                true,  true,  true,  true ,
                false, false, true,  true};
        System.out.println(boolToWord(true));
        System.out.println(evenOrOdd(6));
        System.out.println(countSheeps(myArray));
        System.out.println(zeroFuel(100, 50, 1));
    }
}




