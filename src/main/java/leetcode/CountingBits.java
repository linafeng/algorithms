package leetcode;

/**
 * 比特位计数
 */
public class CountingBits {
    public static void main(String[] args) {
        CountingBits CountingBits=new CountingBits();
        CountingBits.countBits(4);

    }
    public int[] countBits(int num) {
        int[] rs=new int[num+1];
        for(int i=0;i<=num;i++){
            int count=0;
            int bit=i;
            while (bit>0){
                bit=bit&(bit-1);
                count++;
            }
            rs[i]=count;
        }
        return rs;
    }
}
