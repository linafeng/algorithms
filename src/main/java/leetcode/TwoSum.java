package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1
 */
public class TwoSum {
    private static int[] nums={3,2,4};//{5,2,7,11,15};
    private static int target=6;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(nums,target)));
        System.out.println(Arrays.toString(twoSum2(nums,target)));
        System.out.println(Arrays.toString(twoSum3(nums,target)));

    }
    /**
     * 复杂度n平方
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 2遍哈希表
     * 时间复杂度：O(n)O(n)，
     * 我们把包含有 nn 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)O(1) ，所以时间复杂度为 O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 nn 个元素。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
           Integer rightindex= map.get(target-nums[i]);
           if(Objects.nonNull(rightindex)){
               if(rightindex.intValue()==i){
                  continue;
               }
               return new int[]{i,rightindex};
           }
        }
        return new int[0];
    }

    /**
     * 1遍hash表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
