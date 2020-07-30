package oop;


public class temp_test {
    public int coinChange(int[] coins, int amount) {      
        // 解法二
        if (amount < 1)
            return 0;
        int[] arr=new int[amount];
        int num= coinChange(coins, amount, arr);
        return num;

        // // 解法三
        // int max = amount + 1;
        // int[] dp = new int[amount + 1];
        // Arrays.fill(dp, max);
        // dp[0] = 0;
        // for (int i = 1; i <= amount; i++) {
        //     for (int j = 0; j < coins.length; j++) {
        //         if (coins[j] <= i) {
        //             dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        //         }
        //     }
        // }
        // return dp[amount] > amount ? -1 : dp[amount];

    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (count[rem - 1] != 0)
            return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
 
        count[rem - 1] =(min == Integer.MAX_VALUE)?-1: min;
        return count[rem - 1];
    }

}
// @lc code=end
