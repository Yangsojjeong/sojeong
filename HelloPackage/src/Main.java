import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람의 숫자를 입력하세요: ");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        PhoneBook phoneBook = new PhoneBook(numberOfPeople);

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.print("Name and Phonenumber (ex: 홍길동 010-1234-5678): ");
            String input = scanner.nextLine();
            
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String name = parts[0];
                String phoneNumber = parts[1];
                phoneBook.addPerson(name, phoneNumber);
            } else {
                System.out.println("잘못된 입력 형식입니다. 이름과 전화번호를 띄어쓰기로 구분해주세요.");
                i--; // 잘못된 입력은 다시 입력받도록 합니다.
            }
        }

        while (true) {
            System.out.print("Name to search(종료를 원할 시 exit 입력): ");
            String searchName = scanner.nextLine();
            
            if (searchName.equalsIgnoreCase("exit")) {
                break; // 'exit'를 입력하면 검색 종료
            }
            
            String phoneNumber = phoneBook.findPhoneNumber(searchName);
            if (!phoneNumber.startsWith("Phone number not found")) {
                System.out.println(searchName + "의 전화번호: " + phoneNumber);
            } else {
                System.out.println(phoneNumber);
            }
        }

        scanner.close(); // 프로그램 종료 시 스캐너 닫음
    }
}


