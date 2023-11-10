package generic;

import java.util.*;

class Student {
	private int stuID;
	private String phoneNo;
	
	public Student(int stuID, String phoneNo) {
		this.stuID = stuID;
		this.phoneNo = phoneNo;
	}
	
	public int getStuID() {
		return this.stuID;
	}
	
	public String getPhoneNo() {
		return this.phoneNo;
	}
}

public class HashMapStuEx {
	public static void main(String[] args) {
		HashMap<String, Student> studentMap = new HashMap<String, Student>();
		
		studentMap.put("양소정", new Student(1, "010-8584-8675"));
		studentMap.put("주하은", new Student(2, "010-1234-5678"));
		studentMap.put("최윤하", new Student(3, "010-8765-4321"));
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("검색할 이름?");
			String name = scanner.nextLine();
			if(name.equalsIgnoreCase("exit")) break;
			Student stu = studentMap.get(name);
			if (stu == null) {
				System.out.println("name " + "not found");
			}else {
				System.out.println("id: " + stu.getStuID() + ", phone: " + stu.getPhoneNo());
			}
		}
		
		scanner.close();
	}

}
