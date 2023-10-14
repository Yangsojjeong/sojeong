public class Person {
    private String name;  //사람 이름 저장
    private String phoneNumber; // 번호 저장

    public Person(String name, String phoneNumber) {
        this.name = name; // 이름을 변수에 할당
        this.phoneNumber = phoneNumber; // 번호를 변수에 할당
    }

    public String getName() {
        return name; // 이름 반환
    }

    public String getPhoneNumber() {
        return phoneNumber; // 번호 반환
    }
}
