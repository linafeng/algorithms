package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划，搜索三角形 最小路径
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Triangle Triangle = new Triangle();
        System.out.println(Triangle.minimumTotal2(triangle));

    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row+1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    /**
     * 自底向上
     * 耗时比较多
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {//从底层起遍历每一个元素拿到当前元素后面的最小路径
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字
                //System.out.println(minlen[i] + "-" + minlen[i + 1] + "-" + triangle.get(level).get(i));
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }
}
