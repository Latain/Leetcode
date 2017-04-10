package basicoperation;

public class DevideTwoInteger {
	public int devide(int deviden,int devisor){
		if(devisor==0)
			return Integer.MAX_VALUE;
		if(deviden==Integer.MIN_VALUE && (devisor==1 || devisor==-1))
			return devisor==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
		return getDevideResult(deviden,devisor);
	}
	
	public int getDevideResult(long deviden, long devisor){
		boolean mark=(deviden>0 && devisor>0) || (deviden<0 && devisor<0);
		int count=0;
		deviden=Math.abs(deviden);
		devisor=Math.abs(devisor);
		long dev=devisor;
		while(deviden>=dev){
			dev=dev<<1;
			count++;
		}
		
		int result=0;
		count--;
		while(count>=0){
			if(deviden>=devisor<<count){
				deviden-=devisor<<count;
				result+=1<<count;
			}
			count--;
		}
		
		return mark==true?result:-result;
	}
	
	public static void main(String[] args){
		DevideTwoInteger dev=new DevideTwoInteger();
		System.out.println(dev.devide(Integer.MIN_VALUE,-1));
	}
}
