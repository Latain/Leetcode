package reverse;
/*
 * Reverse digits of an integer
 * Example:
 *         input 123,return 321
 *         input -123,return -321
 * Maybe the reversed integer overflow,so notice it.
 */
public class ReverseInt {
	public int reverse(int x) {
		return getReverseResult(x);
    }
    
    public static int getReverseResult(int x){
    	long result=0;
    	while(x!=0){
    		int temp=x%10;
    		result=result*10+temp;
    		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
    			return 0;
    		}
    		x/=10;
    	}
    	return (int)result;
    }
}
