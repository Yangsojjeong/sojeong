public class ArrayParameterEx {
	static void replaceSpace(char a[]) {
		
		
	}
	static void printCharArray(char a[]) {
		System.out.println(a);
	}
	public static void main(String[] args) {
		char c[] = {'T', 'h', 'i', 's', ' ', 'i','s',' ','a',' ','p','e','n','c','i','l','.'};
		
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
	}

}
