package convert;

public class IntegerToRoman {
	public String convertIntIntoRoman(int x){
		String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
		int[] value = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
		String result="";
		for(int i=0;x!=0;i++){
			while(x>=value[i]){
				x-=value[i];
				result+=symbol[i];
			}
		}
		return result;
	}
}
