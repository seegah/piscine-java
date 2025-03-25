public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}