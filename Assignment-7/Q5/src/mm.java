public class mm {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        int left = 0;
        boolean rev = false;
        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                String subStr = s.substring(left, i);
                if (rev) {
                    subStr = new StringBuilder(subStr).reverse().toString();
                }
                builder.append(subStr);
                left = i;
                rev = !rev;
            }
        }
        String subStr = s.substring(left, len);
        if (rev) {
            subStr = new StringBuilder(subStr).reverse().toString();
        }
        builder.append(subStr);
        return builder.toString();
    }
}