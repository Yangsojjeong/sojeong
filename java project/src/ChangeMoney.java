import java.util.Scanner;
public class ChangeMoney {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("금액을 입력하세요: ");
		int price = stdin.nextInt();
		
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		//각 지폐와 동전 배열 생성
		int[] counts = new int[unit.length];
		//각 지폐와 동전이 필요한 개수 저장할 배열 생성
		
		for (int i = 0;  i < unit.length; i++) 
	    {
			if(price >= unit[i]) //가격이 각 지폐와 동전보다 클 때 
				counts[i] = price / unit[i]; //지폐와 동전 개수가 들어갈 배열에 가격을 지폐와 동전으로 나눈 몫을 넣음
			    price %= unit[i]; //넣은 후 나머지를 price로 재설정
			
		}
		
		for (int i = 0; i<unit.length; i++)
		{
			if(counts[i] > 0)
				System.out.println(unit[i] + "원: " + counts[i] + "장/개");
		} 
		

	}

}
