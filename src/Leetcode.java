import java.util.*;
import java.util.stream.Collectors;

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

    public static int[] removeSmallest(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0];
        }

        int smallest = 0;
        for (int i=1; i<numbers.length;i++) {
            if (numbers[i]<numbers[smallest]) {
                smallest = i;
            }
        }

        List<Integer> newList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        newList.remove(smallest);

        return newList.stream().mapToInt(i -> i).toArray();
    }



    public static int minimumNumber(int[] numbers) {
        int sum = 0;
        for (int num: numbers) {
            sum +=num;
        }
        int nextPrime = sum;
        while (!isPrime(nextPrime)) {
            nextPrime++;
        }
        return nextPrime-sum;
    }

    private static boolean isPrime(int n) {
        if (n<2) return false;
        for (int i =2; i*i<=n;i++) {
            if (n%i==0) return false;
        }
        return true;
    }

    public static String order(String words) {
        if (words.isEmpty()) return "";

        Map<Integer, String> map = new TreeMap<>();
        String[] splitList = words.split(" ");
        for (String word: splitList) {
            for (char ch: word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    map.put(Character.getNumericValue(ch), word);
                }
            }
        }
        return String.join(" ", map.values());
    }

    static String removeExclamationMarks(String s) {
        StringBuilder sb = new StringBuilder();

        String[] str = s.split("!");
        for (String word: str) {
            sb.append(word);
        }
        return sb.toString();

    }

    public static double findUniq(double arr[]) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1] : arr[0];
    }

    public static String binaryAddition(int a, int b){
        int n = a + b;
        String s = "";
        while (n > 0)
        {
            s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
            n = n / 2;
        }
        return s;
    }

    public static Map<Character, Integer> count(String str) {
        if (str.isEmpty()) return new HashMap<>();

        Map<Character, Integer> charCount = new HashMap<>();

        for (Character ch: str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
        }
        return charCount;
    }

    public static long[] powersOfTwo(int n){
        long result[] = new long[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = (long) Math.pow(2, i);
        }
        return result;
    }

    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }
}
