package tengxun2017;
import java.util.Scanner;
/*
 * 给定一个正数，计算有多少对质数的和等于给定的数
 */
public class Main {
	public static boolean isPrime(int num){
		if(num<2)
			return false;
		
		for(int i=2;i*i<=num;i++){
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			int count=0;
			int num=scan.nextInt();
			for(int i=2;i<=num/2;i++){
				if(isPrime(i) && isPrime(num-i))
					count++;
			}
			System.out.println(count);
		}
	}
}
