package convert;
/*
 * Convert roman into integer
 * guanranteed that the input is within the range from 1 to 3999.
 */
public class RomanToInteger {
	public int convertRomanIntoInteger(String roman){
		int result=0;
		for(int i=roman.length()-1;i>=0;i--){
			char c=roman.charAt(i);
			if(c=='I'){
				if(result>=5)
					result-=1;
				else
					result+=1;
			}
			if(c=='V'){
				result+=5;
			}
			if(c=='X'){
				if(result>=50)
					result-=10;
				else
					result+=10;
			}
			if(c=='L'){
				result+=50;
			}
			if(c=='C'){
				if(result>=500)
					result-=100;
				else
					result+=100;
			}
			if(c=='D'){
				result+=500;
			}
			if(c=='M'){
				result+=1000;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		RomanToInteger rti=new RomanToInteger();
		System.out.println(rti.convertRomanIntoInteger("DCXXI"));
	}
}
