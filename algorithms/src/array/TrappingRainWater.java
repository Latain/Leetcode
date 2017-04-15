package array;
import java.util.List;
import java.util.ArrayList;
public class TrappingRainWater {
	
	public int trap(int[] nums){
		if(nums.length<3)
			return 0;
		int result=0;
		int left=0;
		int right=nums.length-1;
		while(left<right && nums[left]<nums[left+1])
			left++;
		while(left<right && nums[right]<nums[right-1])
			right--;
		while(left<right){
			int leftVal=nums[left];
			int rightVal=nums[right];
			if(leftVal<rightVal){
				while(left<right && leftVal>nums[++left]){
					result+=leftVal-nums[left];
				}
			}else{
				while(left<right && rightVal>nums[--right]){
					result+=rightVal-nums[right];
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args){
		int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater trap=new TrappingRainWater();
		System.out.println(trap.trap(nums));
	}
}
