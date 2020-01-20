package leetcode;

/**
 * 判断是否是2的整数幂
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo PowerOfTwo=new PowerOfTwo();
        PowerOfTwo.isPowerOfTwo(4);

    }
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        return (n&(n-1))==0;
    }
}
