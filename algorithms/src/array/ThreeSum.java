package array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
	private List<List<Integer>> list=new ArrayList<List<Integer>>();
	public List<List<Integer>> threeSum(int[] nums){
		if(nums.length<3)
			return list;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]){
				continue;
			}else
				findTwoSum(nums,i+1,nums.length-1,nums[i]);
		}
		return list;
	}
	
	public void findTwoSum(int[] nums,int start,int end,int target){
		while(start<end){
			if(nums[start]+nums[end]+target==0){
				ArrayList<Integer> childList=new ArrayList<Integer>();
				childList.add(target);
				childList.add(nums[start]);
				childList.add(nums[end]);
				list.add(childList);
				while(start<end && nums[start+1]==nums[start])
					start++;
				while(start<end && nums[end-1]==nums[end])
					end--;
				start++;
				end--;
			}else if(nums[start]+nums[end]+target<0){
				start++;
			}else
				end--;
				
		}
	}
}
