import java.util.HashSet;

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


    public static void main(String[] args) {
        System.out.println(mergeAlternatively("abc", "pqr"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(solution("abc", "bc"));
        System.out.println(reverseWords("double  spaces"));
        System.out.println(lengthOfLongestSubsting("pwwkew"));
    }
}
