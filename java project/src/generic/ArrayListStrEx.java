package generic;

import java.util.*;

public class ArrayListStrEx {
	//문자열만 삽입 가능한 ArrayList 컬렉션 생성
   public static void main(String[] args) {
      ArrayList<String> a = new ArrayList<String>();
      
      //키보드로부터 4개의 이름을 입력 받아 ArrayList에 삽입
      
      Scanner scanner = new Scanner(System.in);
      for (int i=0;i<4;i++){
         System.out.print("이름을 입력하세요>>> ");
         String s = scanner.next();
         a.add(s);   
      }
      
      //ArrayList에 들어있는 모든 이름 출력
      for(int i=0;i<a.size();i++) {
    	  //ArrayList의 i번재 문자열 얻어오기
         String name=a.get(i);
         System.out.print(name +"  ");
      }
      System.out.println();
      
      //가장 긴 이름 출력
      int longestIndex = 0;
      for(int i=0;i<a.size();i++) {
         if (a.get(longestIndex).length()<a.get(i).length()) {
            longestIndex = i;
         }
      }
      System.out.println("가장 긴 이름은: " + a.get(longestIndex));
      
      scanner.close();

   }

}