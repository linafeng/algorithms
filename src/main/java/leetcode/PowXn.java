package leetcode;

public class PowXn {
    public static void main(String[] args) {
        PowXn PowXn=new PowXn();
        System.out.println(PowXn.myPow(2,-2));
    }

    /**
     * 减少一半的计算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if(n<0){
            return  1/(x*(cal(x,-n-1)));
        }
        return x*(cal(x,n-1));
    }
    public double cal(double x,int n){
        if(n==0) return 1;
        double half=half=cal(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
    /**
     * 递归暴力乘
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if(n==0){
            return 1;
        }else if(n<0){
           return  1/(x*(cal2(x,-n-1)));
        }
        return x*(cal2(x,n-1));
    }
    public double cal2(double x,int n){
        if(n==0){
            return 1;
        }
        return x*(cal2(x,n-1));
    }



}
