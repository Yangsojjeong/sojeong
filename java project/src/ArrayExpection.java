
public class ArrayExpection {

	public static void main(String[] args) {
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		for(int i = 0; i<5; i++)
		{
			intArray[i+1] = i + 1 + intArray[i];
			System.out.println("intARRAY[" + i + "] = " + intArray[i]);
		}
		
	}

}
