package leetcode;

/**
 * bit cal solution
 * [1 = 可放置,0-占用]
 */
public class NqueenII {
    public static void main(String[] args) {
        System.out.println("nnnnn");
        System.out.println((0|1)>>1);
        NqueenII NqueenII=new NqueenII() ;
        System.out.println( NqueenII.totalNQueens(4));

    }

    int count=0;
    int columns=0;
    public int totalNQueens(int n) {
        columns = (1 << n) - 1;
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    public void dfs(int n,int row, int cols ,int pie,  int na ) {
        if (row >= n) {
            count++;
            return;
        }
        // 得到当前所有的空位
        int bits = (~(cols | pie | na)) & columns;
        while(bits>0){
            int p = bits & -bits;//x&(-x)取最低位的1
            bits = bits & (bits - 1);// x&(x-1)去掉最低位的1，把P位置上放入皇后
            cols=cols | p;
            pie=(pie | p) << 1;//标记当前皇后左边相邻的列不允许下一个皇后放置。
            na=(na | p) >> 1; //标记当前皇后右边相邻的列不允许下一个皇后放置。
            // 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归
            // 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位
            System.out.println(cols+"-"+pie+"-"+na);
            dfs(n,row+1,cols,pie,na);
        }
    }

}


