package leetcode;

/**
 * 1的个数
 */
public class NumberOfBits {
    public static void main(String[] args) {
        System.out.println(16<<2);
        System.out.println(16>>2);
        NumberOfBits NumberOfBits=new NumberOfBits();
        System.out.println(5&1);
        System.out.println(NumberOfBits.hammingWeight(8));

    }

    /**
     * 循环和位移动
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /**
     * 位操作的小技巧
     * 在二进制表示中，数字 n 中最低位的 1总是对应 n - 1 中的 0 。
     * 因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1变成 0，并保持其他位不变。
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }




}
