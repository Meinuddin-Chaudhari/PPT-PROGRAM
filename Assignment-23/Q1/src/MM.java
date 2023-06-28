class BinaryTreeDepth {
    static int findDepth(String preorder) {
        int depth = 0;
        int maxDepth = 0;
        
        for (char c : preorder.toCharArray()) {
            if (c == 'n') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == 'l') {
                depth--;
            }
        }
        
        return maxDepth;
    }
    
    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = findDepth(preorder);
        System.out.println("Depth: " + depth);
    }
}
