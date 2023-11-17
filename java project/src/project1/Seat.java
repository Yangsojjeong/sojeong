package project1;

import java.util.Objects;

public class Seat {
    private String name;
    private String phoneNumber;
    private int reservationNumber;

    //생성자
    public Seat(String name, String phoneNumber, int reservationNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservationNumber = reservationNumber;
    }

    //예약 메소드
    public void reserveName(String name, String phoneNumber, int reservationNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservationNumber = reservationNumber;
        //예약자 이름과 예약 번호 전화번호 설정
    }

    //좌석이 이미 예약되어 있는지 확인하는 메소드
    public boolean isOccupeied() {
        if (name == null)
            return false; //이름이 null이면 예약되지 않음, 그 외에는 예약된 상태
        else
            return true;
    }
    
    //예약 정보와 입력된 예약 정보가 일치하는지 확인하는 메소드
    public boolean match(String name, int reservationNumber) {
        return Objects.equals(this.name, name) && this.reservationNumber == reservationNumber;
        //이름은 Objects.equals로 null 체크하고, 예약번호도 일치하는지 확인
    }

    //예약 취소 메소드
    public void cancel() {
    	this.name = null;
        this.reservationNumber = 0;
        //예약자 이름과 예약번호 초기화
    }

    // 이름 정보 반환 메소드
    public String getName() {
        return name;
    }
    
    // 전화번호 정보 반환 메소드
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //예약번호 정보 반환 메소드
    public int getReservationNumber() {
        return reservationNumber;
    }

}
