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
    	int sign=1;
    	if(x<0){
    		x=-x;
    		sign=-1;
    	}
    	while(x!=0){
    		int temp=x%10;
    		result=result*10+temp;
    		if(sign*result>Integer.MAX_VALUE || sign*result<Integer.MIN_VALUE){
    			return 0;
    		}
    		x/=10;
    	}
    	return sign*(int)result;
    }
    
    public static void main(String[] args){
    	ReverseInt r=new ReverseInt();
    	System.out.println(r.reverse(-1534236469));
    }
}
