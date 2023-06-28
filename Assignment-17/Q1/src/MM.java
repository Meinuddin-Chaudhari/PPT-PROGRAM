
public class MM {
    public static int firstUniqChar(String s) {
        int[] count = new int[26]; // Assuming input only contains lowercase letters
        
        // Count the occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Find the index of the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1; // No non-repeating character found
    }
    
    public static void main(String[] args) {
        String input = "leetcode";
        int index = firstUniqChar(input);
        System.out.println("Index of the first non-repeating character: " + index);
    }
}
