import java.util.*;
import java.util.stream.IntStream;

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

    public static String longePalindromeSubstring(String s) {
        if (s == null || s.length() <1) return "";
        int start = 0, end = 0;

        for (int i=0; i<s.length();i++) {
            int len1 = expandFromCentre(s, i, i);
            int len2 = expandFromCentre(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expandFromCentre(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }

    public static String nickname(String name) {
        if (name.length()< 4) return "Name too short";
        String vowels = "aeiouAEIOU";

        char thirdChar = name.charAt(2);

        if (vowels.indexOf(thirdChar) != -1) {
            return name.substring(0,4);
        } else {
            return name.substring(0,3);
        }
    }

    public static double factorial(int n) {
        double ans = 1;
        while (n > 0) {
            ans *= n;
            n--;
        }
        return ans;
    }

    public static int century(int number) {
        return (number%100 == 0) ? number/100 : number/100 +1;
    }

    public static String encode(String word) {
        String wordLower = word.toLowerCase();

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c: wordLower.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c,0) +1);
        }

        StringBuilder result = new StringBuilder();
        for (char c: wordLower.toCharArray()) {
            if (charCount.get(c) > 1) {
                result.append(")");
            } else {
                result.append("(");
            }
        }
        return result.toString();
    }

    public static String solution(String str) {
        StringBuilder result = new StringBuilder(str);
        result.reverse();
        return result.toString();
    }

    public static long sumTwoSmallestNumbers(long[] numbers) {
        //Your solution here
        Arrays.sort(numbers);
        return numbers[0]+numbers[1];
    }

    public static int getCount(String str) {
        int count = 0;
        for (char c: str.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else {

                if (!st.empty() &&
                        ((st.peek() == '(' && s.charAt(i) == ')') ||
                                (st.peek() == '{' && s.charAt(i) == '}') ||
                                (st.peek() == '[' && s.charAt(i) == ']'))) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        return st.empty();
    }

    public static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map= new HashMap<>();

        for (int i=0; i<array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(array[i], i);
        }
        return new int[]{};
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        int arrSize = merged.length;
        double  median = 0.0;
        for (int num: merged) {
            if (arrSize%2==0) {
                int middle = arrSize/2;
                median = (merged[middle] + merged[middle+1]) / 2;
                return median;
            } else {
                int middle = arrSize%2+1;
                median = merged[middle];
                return median;
            }
        }
        return median;
    }

    public static boolean comp(int[] a, int[] b) {
        List<Integer> squaredA = new ArrayList<>();
        List<Integer> arrayListB = new ArrayList<>();

        for (int num: a) {
            squaredA.add(num*num);
        }

        for (int num: b) {
            arrayListB.add(num);
        }

        squaredA.sort(Integer::compare);
        arrayListB.sort(Integer::compare);

        System.out.println(squaredA);
        System.out.println(arrayListB);
        return squaredA.equals(arrayListB);
    }

    public static String toAlternativeString(String string) {
        // your code here!
        StringBuilder result = new StringBuilder();

        for (Character s: string.toCharArray()) {
            if (Character.isLowerCase(s)) {
                result.append(Character.toUpperCase(s));
            } else if (Character.isUpperCase(s)) {
                result.append(Character.toLowerCase(s));
            }
        }
        return result.toString();
    }

    public static String highAndLow(String numbers) {
        // Code here or
        if (numbers.isEmpty()) {
            return "invalid input";
        }
        String[] splitString = numbers.split(" ");
        List<Integer> numbersArray = new ArrayList<>();

        for (String num: splitString) {
            numbersArray.add(Integer.parseInt(num));
        }

        Collections.sort(numbersArray);
        String lowest = Integer.toString(numbersArray.get(0));
        String highest = Integer.toString(numbersArray.get(numbersArray.size()-1));

        return lowest + " " + highest;
    }

    public static int duplicateCount(String text) {
        Map<String, Integer> charCount = new HashMap<>();

        String lowerText = text.toLowerCase();
        for (Character ch: lowerText.toCharArray()) {
            if ()
        }
    }

    public static void main(String[] args) {
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(comp(a, b));
        System.out.println(toAlternativeString("HeLLo WoRLD"));
    }
}




