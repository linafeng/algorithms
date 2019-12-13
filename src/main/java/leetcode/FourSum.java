package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    private static int[] nums = {-2,-1,-1,0,2,3,4};

    public static void main(String[] args) {
        FourSum obj = new FourSum();
        List<List<Integer>> list = obj.fourSum2(nums);
        list.forEach(o -> {
            System.out.println(Arrays.toString(o.toArray()));
        });
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len-3 ; i++) {
            if(target<=0&&nums[i]>0){ break; }// 如果当前数字大于0，则4数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            for(int nextId=i+1;nextId<len-2;nextId++){
                if(target<=0&&nums[nextId]>0){ break; }// 如果当前数字大于0，则4数之和一定大于0，所以结束循环
                int L = nextId+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] +nums[nextId]+ nums[L] + nums[R];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[nextId],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }else if (sum < 0) {
                        L++;
                    }else if (sum > 0){
                        R--;
                    }
                }
            }

        }
        return ans;
    }
    public List<List<Integer>> fourSum7(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {// 如果当前数字大于0，则4数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            for(int j=i+1;j<len;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue; // 去重
                int L = j+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] +nums[j]+ nums[L] + nums[R];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }else if (sum < 0) {
                        L++;
                    }else if (sum > 0){
                        R--;
                    }
                }
            }

        }
        return ans;
    }

    public List<List<Integer>> fourSum4(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len-3 ; i++) {// 如果当前数字大于0，则4数之和一定大于0，所以结束循环
            if(target<=0&&nums[i]>0){
                break;
            }else if(target>0&& nums[i]>target){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int begin=i+1;
            for(int nextId=begin;nextId<len-2;nextId++){
                if(target<=0&&nums[nextId]>0){// 如果当前数字大于0，则4数之和一定大于0，所以结束循环
                    break;
                }else if(target>0&& nums[i]+nums[nextId]>target){
                    break;
                }
                if(nextId!=begin&& nums[nextId] == nums[nextId-1]) continue; // 去重
                int L = nextId+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] +nums[nextId]+ nums[L] + nums[R];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[nextId],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }else if (sum < 0) {
                        L++;
                    }else if (sum > 0){
                        R--;
                    }
                }
            }

        }
        return ans;
    }

    public List<List<Integer>> fourSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则4数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int nextId=i+1;
            int L = i+2;
            int R = len-1;
            while(L < R){
                int sum = nums[i] +nums[nextId]+ nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[nextId],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }else if (sum < 0) {
                    L++;
                }else if (sum > 0){
                    R--;
                }
            }
        }
        return ans;
    }


}
