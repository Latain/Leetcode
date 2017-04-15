package interestingQuestion;
import java.util.Scanner;
public class ClimbingStairs {
	public static int climbingStairs(int n){
		if(n==1 || n==2)
			return n;
		int preCount=1,pre=2,total=3;
		for(int i=3;i<=n;i++){
			total=preCount+pre;
			preCount=pre;
			pre=total;
		}
		return total;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			int way=climbingStairs(scan.nextInt());
			System.out.println(way);
		}
	}
}
