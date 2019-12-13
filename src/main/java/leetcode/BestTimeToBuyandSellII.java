package leetcode;

public class BestTimeToBuyandSellII {
    public static void main(String[] args) {
        BestTimeToBuyandSellII BestTimeToBuyandSellII=new BestTimeToBuyandSellII();

    }

    /**
     * 不断的找到折线中的低谷和高峰
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];

        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
