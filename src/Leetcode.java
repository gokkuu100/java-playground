import java.util.*;

public class Leetcode {
    public static String mergeAlternatively(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<word1.length() || i<word2.length(); i++) {
            if (i<word1.length()) {
                result.append(word1.charAt(i));
            }if (i<word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }



    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i=0; i<haystack.length()-needle.length();i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static String reverseWords(final String original) {
        String[] words = original.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i=0; i<words.length;i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i<words.length-1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static int solve(int [] arr){
        return Arrays.stream(arr).distinct().sum();
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int n : elements) {
            int count = countMap.getOrDefault(n, 0);

            if (count < maxOccurrences) {
                result.add(n);
                countMap.put(n, count + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int n: nums1) {
            set1.add(n);
        }

        for(int n: nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    public static int lengthOfLongestSubsting(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right<s.length();right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static int[] enoughIsEnough(int[] elements, int max) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int n: elements) {
            int count = countMap.getOrDefault(n, 0);
            if (count < max) {
                result.add(n);
                countMap.put(n, count+1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static String breakCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch: str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(" ");
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static String multiTable(int num) {
        StringBuilder result = new StringBuilder();
        for (int i=1; i<=10;i++){
            result.append(i).append(" * ").append(num).append(" = ").append(i * num);
            if (i < 10) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String disemvowel(String str) {
        return str.replaceAll("([AEIOUaeiou])", "");
    }

    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static String breakCamelLowerNext(String str) {
        StringBuilder result = new StringBuilder();
        boolean foundUpperCase = false;

        for (char ch: str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(" ");
                foundUpperCase = true;
            }
            if (foundUpperCase) {
                result.append(Character.toLowerCase(ch));
                foundUpperCase = false;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static double[] tribonacci(double[] s, int n) {
        if (n==0) return new double[0];

        double[] arr = new double[n];

        for (int i=0; i<Math.min(3, n); i++) {
            arr[i] = s[i];
        }

        for (int i=3;i<n;i++) {
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr;
    }

    public static String[] dup(String[] arr){
        String[] result = new String[arr.length];
        for (int i=0; i< arr.length;i++) {
            result[i] = removeDuplicates(arr[i]);
        }
        return result;
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        char previousChar = '\0';

        for (char ch: str.toCharArray()) {
            if (ch != previousChar) {
                sb.append(ch);
            }
            previousChar = ch;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(breakCamelCase("helloPrince"));
        System.out.println(multiTable(5));
        double[] result1 = tribonacci(new double[]{1, 1, 1}, 10);
        System.out.println(Arrays.toString(result1));
    }
}
