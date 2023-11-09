public class PhoneBook {
    private Person[] people; //사람 정보 저장하는 배열
    private int size; // 현재 저장된 항목 수

    public PhoneBook(int capacity) {
        people = new Person[capacity]; //지정된 용량으로 배열을 초기화함
        size = 0; //저장된 항목을 초기화
    }

    public void addPerson(String name, String phoneNumber) {
        if (size < people.length) {
            people[size] = new Person(name, phoneNumber); // 배열에 공간이 남아있으면 Person객체 생성해서 저장 
            size++;
        } else {
            System.out.println("Phone book is full. Cannot add more entries."); // 배열에 공간이 없는 경우
        }
    }

    public String findPhoneNumber(String name) {
        for (int i = 0; i < size; i++) {
            if (people[i].getName().equals(name)) {
                return people[i].getPhoneNumber(); //이름이 일치하면 번호 반환
            }
        }
        return "Phone number not found for " + name;
    }
}
