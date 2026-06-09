package day11;
import java.util.*;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		System.out.println("현재 날짜");
		System.out.println(now.get(Calendar.YEAR) + "년");
		System.out.println(now.get(Calendar.MONTH)+1 + "월");
		System.out.println(now.get(Calendar.DAY_OF_MONTH) + "일");
		System.out.println(now.get(Calendar.HOUR_OF_DAY) + "시");
		System.out.println(now.get(Calendar.MINUTE) + "분");
		System.out.println(now.get(Calendar.SECOND) + "초");
				

	}

}
