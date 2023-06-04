import java.util.HashMap;

public class mm {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> dict = new HashMap<>();
        dict.put('0','0');
        dict.put('1','1');
        dict.put('8','8');
        dict.put('6','9');
        dict.put('9','6');
        int i=0; 
        int j = num.length()-1;
        while(i<=j){
            char f = num.charAt(i);
            char b = num.charAt(j);
            if(dict.containsKey(f) && dict.containsKey(b) && dict.get(f) == b){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;

    }
}