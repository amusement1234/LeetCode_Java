package labuladong;

//斐波那契
public class feibolaqie {
    //方法一：递归
    public int feb(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return feb(n - 1) + feb(n - 2);
    }

    //方法二：递归（带备忘录）
    public int feb2(int n) {
        int[] arr = new int[n + 1];
        return helper2(n, arr);
    }

    private int helper2(int n, int[] arr) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (arr[n] != 0)
            return arr[n];
        return helper2(n - 1, arr) + helper2(n - 2, arr);
    }

    //方法三：动态规划    
    public int feb3(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        //n从1开始
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    //方法四：动态规划 优化
    public int feb4(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}