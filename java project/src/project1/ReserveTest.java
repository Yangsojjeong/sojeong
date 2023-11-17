package project1;

import java.util.*;

public class ReserveTest extends Seat {
	
	public ReserveTest() {
        super("defaultName","defaultPhoneNumber" ,0); // Replace with appropriate parameters
    }

    public static void main(String[] args) {
        SeatType[] aSeatType = new SeatType[4];

        aSeatType[0] = new SeatType('V',30);     
        aSeatType[1] = new SeatType('S',30);     
        aSeatType[2] = new SeatType('A',30);     
        aSeatType[3] = new SeatType('B',30);     

        int choice = 0 ;

        while(choice != 4 ) {
            int type;
            System.out.println("=============== 메인 메뉴 =============== ");
            System.out.println(" 다음 중 하나의 메뉴를 선택하세요.");
            System.out.println(" 1. 예약");
            System.out.println(" 2. 조회");
            System.out.println(" 3. 취소");
            System.out.println(" 4. 종료");
            System.out.println(" 선택하세요 >>>>> ");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            switch (choice) {
                case 1: // 예약
                    System.out.println("<좌석 구분>");
                    System.out.println("1. V석 (30석)");
                    System.out.println("2. S석 (30석)");
                    System.out.println("3. A석 (30석)");
                    System.out.println("4. B석 (30석)");

                    type = in.nextInt();

                    if (type < 1 || type > 4) {
                        System.out.println("예약시 잘못된 자석 타입 입니다.");
                        break;
                    }
                    aSeatType[type - 1].seatReserve();
                    break;
                case 2:  // 조회
                    System.out.print("이름: ");
                    String name = in.next();  // Get the name for which you want to check the reservation
                    System.out.print("예약번호: ");
                    int reservationNumber = in.nextInt();  // Get the reservation number for which you want to check the reservation

                    boolean reservationFound = false;

                    for (int i = 0; i < aSeatType.length; i++) {
                        aSeatType[i].showReservationInfo(name, reservationNumber);
                        if (aSeatType[i].isReserved(name, reservationNumber)) {
                            reservationFound = true;
                            break;  // Break out of the loop once the reservation is found
                        }
                    }
                    break;
                case 3: // 취소
                     System.out.println("<좌석 구분>");
                     System.out.println("1. V석 (30석)");
                     System.out.println("2. S석 (30석)");
                     System.out.println("3. A석 (30석)");
                     System.out.println("4. B석 (30석)");
                     type = in.nextInt();

                     if(type < 1 || type > 4) {
                         System.out.println("취소시 잘못된 자석 타입입니다");
                         break;
                     }
                     aSeatType[type-1].cancel();
                     break;
                case 4:  // 종료
                    break;

                default:
                    System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }
    }
}