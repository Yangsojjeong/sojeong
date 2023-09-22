import java.util.Scanner;
public class Game369 
{
     public static void main(String[] args) 
     {
    	Scanner stdin = new Scanner(System.in);
 		System.out.print("1~99 사이의 숫자를 입력하세요: ");
 		int number = stdin.nextInt();
 		
 		if(number%10 == 3 || number%10 == 6 || number%10 == 9)   //일의 자리 숫자에 3,6,9가 있는지 확인
 			if(number/10 == 3 || number/10 == 6 || number/10 == 9)  //있다면 십의 자리 숫자에 3,6,9가 있는지 확인
 				System.out.println("박수 짝짝"); //있다면 박수 짝짝 출력
 			else // 십의 자리 숫자에 3,6,9가 없다면
 				System.out.println("박수 짝"); //일의 자리 숫자에는 3,6,9 중 하나가 존재하므로 박수 짝 출력
 		else if (number/10 == 3 || number/10 == 6 || number/10 == 9) //십의 자리 숫자에 3,6,9가 있는지 확인
 				System.out.println("박수 짝"); //일의 자리는 업고 십의 자리에는 있으므로 박수 짝 출력
 			
 		else
 			System.out.println("없음");
	 }

}
