package array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/*
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

   A solution set is:
  [
   [-1,  0, 0, 1],
   [-2, -1, 1, 2],
   [-2,  0, 0, 2]
  ]
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums,int target){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		Set<List<Integer>> set=new HashSet<List<Integer>>();
		if(nums.length<4)
			return list;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){
			for(int j=i+1;j<nums.length-2;j++){
				int start=j+1;
				int end=nums.length-1;
				while(start<end){
					int sum=nums[i]+nums[j]+nums[start]+nums[end];
					if(sum==target){
						List<Integer> element=new ArrayList<Integer>();
						element.add(nums[i]);
						element.add(nums[j]);
						element.add(nums[start]);
						element.add(nums[end]);
						if(!set.contains(element)){
							list.add(element);
							set.add(element);
						}
						start++;
						end--;
					}else if(sum<target)
						start++;
					else
						end--;
				}
			}
		}
		return list;
	}
	public static void main(String[] args){
		FourSum fs=new FourSum();
		int[] nums=new int[]{-4,-3,-2,-1,0,0,1,2,3,4};
		System.out.println(fs.fourSum(nums,-0));
	}
}
