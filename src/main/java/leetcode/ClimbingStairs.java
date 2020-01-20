package leetcode;

/**
 * 爬楼梯
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs ClimbingStairs=new ClimbingStairs();
        System.out.println(ClimbingStairs.climbStairs(3));

    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 暴力递归法
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
       return  climb_Stairs1(0, n);
    }
    public int climb_Stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        int a=climb_Stairs1(i + 1, n);
        int b=climb_Stairs1(i + 2, n);
        System.out.println(a+"-"+b);
        return  a+b;
    }


}
