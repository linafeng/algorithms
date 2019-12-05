package leetcode;

import java.util.*;

public class ThreeSum {
    private static int[] nums={-1, 0, 1, 2, -1, -4,1};
    public static void main(String[] args) {
        ThreeSum obj=new ThreeSum();
        obj.threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null) {
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        Set<Integer> set=map.keySet();
        StringBuilder rs=new StringBuilder();
        Integer[] newnums=set.toArray(new Integer[set.size()]);
        for(int i=0;i<newnums.length;i++){
            for(int j=i+1;j<newnums.length;j++){
                if(map.get(newnums[i]+newnums[j])!=null){
                    if(newnums[i]!=0&&newnums[j]!=0){
                        rs.append(newnums[i]+","+newnums[j]+","+(newnums[i]+newnums[j])+";");
                        continue;
                    }
                    if(newnums[i]==0 &&map.get(newnums[j])>1){
                        rs.append(newnums[i]+","+newnums[j]+","+newnums[j]+";");
                    }else if(newnums[j]==0 &&map.get(newnums[i])>1){
                        rs.append(newnums[i]+","+newnums[j]+","+newnums[i]+";");
                    }

                }
            }
        }
        map.forEach((k,v)->{
            if(v>1&&map.get(k*2)!=null){
                rs.append(k+","+k+","+(k*2)+";");
            }
        });
        System.out.println(rs.toString());
        return null;



    }
}
