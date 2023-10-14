import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람의 숫자를 입력하세요: ");
        int numberOfPeople = scanner.nextInt(); //사용자로부터 사람 수 입력 받음
        scanner.nextLine(); // 개행 문자 제거

        PhoneBook phoneBook = new PhoneBook(numberOfPeople); // PhoneBook 객체 생성하고 용량 설정

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.print("Name and Phonenumber (ex: 홍길동 010-1234-5678): ");
            String input = scanner.nextLine(); //사용자가 이름과 번호 입력
            
            String[] parts = input.split(" "); //공백으로 번호와 이름 구별함
            if (parts.length == 2) {
                String name = parts[0];
                String phoneNumber = parts[1];
                phoneBook.addPerson(name, phoneNumber); // 이름과 번호를 PhoneBook에 추가
            } else {
                System.out.println("잘못된 입력 형식입니다. 이름과 전화번호를 띄어쓰기로 구분해주세요.");
                i--; // 잘못된 입력은 다시 입력하게 함
            }
        }

        while (true) {
            System.out.print("Name to search(종료를 원할 시 exit 입력): ");
            String searchName = scanner.nextLine(); //사용자가 검색하고 싶은 이름 입력
            
            if (searchName.equalsIgnoreCase("stop")) {
                break; // 'stop'를 입력하면 검색 종료
            }
            
            String phoneNumber = phoneBook.findPhoneNumber(searchName);
            // 입력된 이름으로 번호 찾음
            if (!phoneNumber.startsWith("Phone number not found")) {
                System.out.println(searchName + "의 전화번호: " + phoneNumber);
            } else {
                System.out.println(phoneNumber);
            }
        }

        scanner.close(); // 프로그램 종료 시 스캐너 닫음
    }
}


