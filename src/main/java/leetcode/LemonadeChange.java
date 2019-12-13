package leetcode;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(arr));


    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                ten++;
                if ((--five) < 0) {
                    return false;
                }
            } else if (bills[i] == 20) {
                    twenty++;
                    if ((--ten) < 0) {
                        ten++;
                        five=five-2;
                        if ((--five) < 0) {
                            return false;
                        }
                    }else{
                        if ((--five) < 0) {
                            return false;
                        }
                    }
            }
        }
        return true;
    }
}
