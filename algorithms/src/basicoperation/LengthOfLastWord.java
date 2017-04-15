package basicoperation;

public class LengthOfLastWord {
	public int getLengthLastWord(String str){
		if(str==null)
			return 0;
		str=str.trim();
		if(str.length()==0)
			return 0;
		return str.substring(str.lastIndexOf(" ")+1,str.length()).length();
	}
	
	public int minDistance(String word1,String word2){
		if(word1.equals(word2))
			return 0;
		int result=0;
		if(word1.length()==word1.length()){
			for(int i=0;i<word1.length()-1;i++){
				if(word1.charAt(i)==word2.charAt(i))
					continue;
				result++;
			}
			return result;
		}else if(word1.length()>word2.length()){
			if(word1.contains(word2))
				return word1.length()-word2.length();
			else{
				for(int i=word2.length()-1;i>=0;i--){
					if(!word1.contains(String.valueOf(word2.charAt(i))))
						result++;
					continue;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args){
		String str="happy";
		LengthOfLastWord lw=new LengthOfLastWord();
		System.out.println(lw.getLengthLastWord(str));
	}
}
