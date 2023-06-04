class mm {
public void numPermsDISequence(String S) {
        int n = S.length(), mod = (int) (1e9 + 7);
        vector<vector<Integer>> dp(n + 1, vector<Integer>(n + 1));
        int[][] dp;
		for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (S[i] == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        
        return dp[n][0];
    }
}