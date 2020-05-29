package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 动态规划
 */
public class Dynamic {
    public static void main(String[] args) {
        System.out.println(MaxChildArrayOrder(new int[]{3, 1, 4, 1, 5, 9, 6, 7}));
    }

    public static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        int temp[] = new int[n];//temp[i]代表0...i上最长递增子序列
        for (int i = 0; i < n; i++) {
            temp[i] = 1;//初始值都为1
        }
        //以自己a[i]为最后一个数的最大序列值
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && temp[j] + 1 > temp[i]) {
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    System.out.println("needchange,j=" + j + "i=" + i);
                    System.out.println(Arrays.toString(temp));
                    temp[i] = temp[j] + 1;
                    System.out.println(Arrays.toString(temp));
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for (int i = 1; i < n; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }

    /**
     * 数组最大连续子序列和
     * 如arr[] = {6,-1,3,-4,-6,9,2,-2,5}的最大连续子序列和为14。即为：9,2,-2,5
     *
     * @param a
     * @return
     */
    public static int MaxContinueArraySum(int a[]) {
        int n = a.length;
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + a[i], a[i]);
            if (sum >= max) {
                max = sum;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        int[][] arr = {{3},
                {1, 5},
                {8, 4, 3},
                {2, 6, 7, 9},
                {6, 2, 3, 5, 1}};
        System.out.println(minNumberInRotateArray3(arr));
    }


    public static int minNumberInRotateArray3(int n[][]) {
        int rownum = n.length;
        int[] temp = n[rownum - 1];

        //i是遍历行倒数第二行开始遍历
        // 由于行数字与该行数字个数一样，j在i范围内，从左开始看，j能匹配的只有正下方temp[j]和右方temp[j+1},对于j的位置来说这两个哪个大选哪个
        //j的值需要加上这个值
        for (int i = rownum - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                temp[j] = Math.max(temp[j], temp[j + 1]) + n[i][j];
            }
        }
        return temp[0];
    }

    public static int MaxTwoArraySameOrderMethod(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        /*
         * 定义一个二维数组保存公共子序列长度
         * dp[i][j]表示字符串1从头开始长度是i，字符串2从头开始长度是j，这两个字符串的最长公共子序列的长度
         * 设置数组行列比他们长度大一,往二维数组中填写数字时，每个位置的数字跟他上方或者左方或者左上方数字有关系，这样处理边界数字时不用处理这种情况，方便接下来的循环
         */
        int[][] dp = new int[m + 1][n + 1];
        /*
         * 初始化第一行第一列
         * dp[0,j]表示啥？表示字符串1的长度是0，字符串2的长度是j，这两个字符串的最长公共子序列的长度是0，因为，字符串1 根本就没有嘛
         */
        for (int[] row : dp)    { row[0] = 0;   }
        for (int first : dp[0]) { first=0;    }
        //从dp[1,1]开始按行遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                 * 如果当c[i][j]时，字符串1从头开始长度是i，字符串2从头开始长度是j时他们最后一个字符相同
                 * 就同时把他们向前移动一位，找c[i-1][j-1]时长度最大的再加一
                 * 表现在二维数组中就是c[i][j]左上方的点
                 */
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    /*
                     * 如果当c[i][j]时，他们最后一个字符不相同
                     * 要将str1往前移动一位的c[i-1][j]的lcs长度，或者将str2往前移动一位的c[i][j-1]的lcs长度
                     * 哪个长，将它赋给c[i][j]
                     * 表现在二维数组中就是c[i][j]上方的点或者左方的点
                     */
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test2() {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int array = MaxTwoArraySameOrderMethod(str1, str2);
        System.out.println(array);
    }


}