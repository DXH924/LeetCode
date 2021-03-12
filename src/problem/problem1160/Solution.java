package problem.problem1160;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int hasChars[] = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            hasChars[c - 'a']++;
        }
        for (String w : words) {
            int[] charCount = new int[26];
            boolean canSpell = true;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (charCount[i] > hasChars[i]) {
                    canSpell = false;
                    break;
                }
            }
            if (canSpell) {
                sum += w.length();
            }
        }
        return sum;
    }
}
class Test {
    public static void main(String[] args) {
        String[] words = new String[] {
                "hello","world","leetcode"
        };
        String chars = "welldonehoneyr";
        System.out.println(new Solution().countCharacters(words, chars));
    }
}
