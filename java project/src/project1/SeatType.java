package project1;

import java.util.Scanner;
import java.util.stream.Stream;

public class SeatType {
    private char type; //좌석 유형을 나타내는 변수
    private Seat[] aSeat;      // Seat 클래스의 객체를 참조하는 배열, 좌석 정보를 관리

    // 생성자
    public SeatType(char type, int num){     // 인자값이 좌석의 유형, 좌석수
        this.type = type;
        aSeat = new Seat[num];              // 좌석 수에 맞는 배열 객체 생성

        for (int i = 0; i<aSeat.length; i++) {
            aSeat[i] = new Seat(null, null, i); // 각 좌석을 초기화하면서 생성자 호출
        }
    }

    //좌석 예약
    public boolean seatReserve() {
        Scanner in = new Scanner(System.in);
        int seatNum;
        String name1, phoneNumber1= null, phoneNumber2, name2 = null;
        show(); // 현재 예약 상태 출력
        System.out.print("이름 : ");
        name1 = in.next();
        System.out.print("전화번호 : ");
        phoneNumber1 = in.next();
        System.out.print("좌석 번호 : ");
        seatNum = in.nextInt();

        //잘못된 좌석 번호 입력 시 예외 처리
        if(seatNum < 1 || seatNum > aSeat.length){
            System.out.println("잘못된 좌석번호 입니다.");
            return false;
        }
        //이미 예약된 좌석일 경우 예외 처리
        if (aSeat[seatNum-1].isOccupeied()){
            System.out.println("이미 예약된 좌석번호 입니다.");
            return false;
        }
        //예약 번호 생성 및 출력
        int reservationNumber1 = generateReservationNumber(seatNum);
        System.out.println("예약이 완료되었습니다. 예약 번호: " + reservationNumber1);
        aSeat[seatNum - 1].reserveName(name1, phoneNumber1, reservationNumber1); // 예약된 정보 설정

        
        System.out.print("2명 예약하시겠습니까? (y/n): "); // 2명 예약 여부 확인
        String answer = in.next().toLowerCase();

        if (answer.equals("y")) {
            System.out.print("이름 (2인) : ");  
            name2 = in.next();
            System.out.print("전화번호 (2인) : ");
            phoneNumber2 = in.next();
            System.out.print("좌석 번호 (2인) : "); 
            seatNum = in.nextInt();

            // 잘못된 좌석 번호 입력 시 예외 처리
            if(seatNum < 1 || seatNum > aSeat.length){
                System.out.println("잘못된 좌석번호 입니다.");
                return false;
            }
            // 이미 예약된 좌석일 경우 예외 처리
            if (aSeat[seatNum-1].isOccupeied()){
                System.out.println("이미 예약된 좌석번호 입니다.");
                return false;
            }
           
            //예약 번호 생성 및 출력
            int reservationNumber2 = generateReservationNumber(seatNum);
            aSeat[seatNum - 1].reserveName(name2, phoneNumber2, reservationNumber2);
            System.out.println("예약이 완료되었습니다. 예약 번호: " + reservationNumber2);
        }
        return true;
    }
    
    //예약번호 생성 메소드
    private int generateReservationNumber(int seatNum) {
    	return (int) (System.currentTimeMillis() % 100000);
    }
    
    //좌석 취소
    public boolean cancel() {
        Scanner in = new Scanner(System.in);
        show();  // 현재 예약 상태 출력
        
        System.out.print("이름과 예약번호를 입력해주세요.");
        System.out.println();
        System.out.print("이름: ");
        String name = in.next();        // 취소할 예약자 이름 입력
        System.out.print("예약번호: ");
        int reservationNumber = in.nextInt(); //취소할 예약번호 입력
        
        boolean canceled = false;

        // 예약자 정보와 예약번호 일치하는 좌석 찾기
        for (int i = 0; i < aSeat.length; i++) {
            if (aSeat[i].match(name, reservationNumber)) {
                aSeat[i].cancel(); //예약 취소
                System.out.println("예약이 취소되었습니다.");
                canceled = true;
                break;
            }
        }

        // 일치하는 정보가 없는 경우 예외 처리
        if (!canceled) {
            System.out.println("예약자 이름과 예약번호를 찾을 수 없습니다.");
        }

        return canceled;
    }
    
    //좌석이 예약완료되었는지 보여줌
    public void show() {
        System.out.println(type + "석 예약 현황 : ");

        for ( int i=0; i<aSeat.length; i++){
            if(aSeat[i].isOccupeied())
            	System.out.print("예약완료");
            else
                System.out.print("---");
            System.out.print(" ");
        }
        System.out.println();
    }
    
    //좌석 조회
    public void showReservationInfo(String name, int reservationNumber) {
        System.out.println(type + "석 예약 현황 : ");

        boolean found = false;

        for (int i = 0; i < aSeat.length; i++) {
            if (aSeat[i].match(name, reservationNumber)) {
            	System.out.println("예약하신 좌석: " + type + "석 " + (i + 1)+"번");
                return;
            }
        }

        if (!found) {
            System.out.println("No reservation found for name: " + name + " and reservation number: " + reservationNumber);
        }
    }

    public boolean isReserved(String name, int reservationNumber) {
        for (int i = 0; i < aSeat.length; i++) {
            if (aSeat[i].match(name, reservationNumber)) {
                return true;
            }
        }
        return false;
    }
}
