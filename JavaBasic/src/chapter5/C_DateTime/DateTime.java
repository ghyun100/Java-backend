package chapter5.C_DateTime;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

// 날짜 및 시간
public class DateTime {

	public static void main(String[] args) {
		// System.currentTimeMillis()
		// 현재 시간을 long 타입으로 0.001초 단위로 표현
		// 기준 1960년 1월 1일
		
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
	
		for (int count = 0; count < 100000000; count++) {
			count++;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		// Date class
		// 날짜를 관리 해주는 클래스
		// 주고 날짜와 관련된 데이터타입을 취급할 때 사용
		Date date = new Date();
		System.out.println(date);
		
		System.out.println(date.getMonth()); // 1월이 0, 2월이 1, 3월이 2, ...
		                                     // getMonth에 줄이그인 이유는 옛날거라 
		                                     // 가능한 사용하지 말라고 그여있음  
		                                     // 컨트롤 마우스 들어가면 @Deprecated 가 있다.
		
		date.setHours(date.getHours() + 2);
		System.out.println(date);
		
		Date now = Date.from(Instant.now());
		System.out.println(now);
		
		Date minusTwoHour = Date.from(Instant.now().minus(2, ChronoUnit.HOURS));
		System.out.println(minusTwoHour);
				
		// SimpleDateFormat
		// Date 타입의 참조변수를 지정한 포맷의 문자열로 변경해주는 클래스
		// y : 연, M : 월, d : 일, H : 시간, m : 분, s : 초
		SimpleDateFormat simpleDateFormat 
				= new SimpleDateFormat("yyyy. MM. dd. HH:mm:ss");
		
		String formatedDate = simpleDateFormat.format(now);
		System.out.println(formatedDate);
				
		// Time Package
		// Date와 Calander 클래스의 단점 보완
		
		// LocalDate class
		// 날짜를 관리해주는 class
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalDate localDateOf = LocalDate.of(2022, 12, 25);
		System.out.println(localDateOf);
		
		// LocalTime class
		// 시간을 관리해주는 class (나노까지나옴)
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		LocalTime localTimeOf = LocalTime.of(12, 40);
		System.out.println(localTimeOf);
		
		// LocalDateTime class
		// 날짜와 시간을 관리해주는 class
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		LocalDateTime localDateTimeOf = LocalDateTime.of(localDateOf, localTimeOf);
		System.out.println(localDateTimeOf);
		
		// 특정 날짜 또는 시간 가져오기
		// .getXXX();
		int year = localDateTime.getYear();
		
		int month = localDateTime.getMonthValue();
		Month enumMonth = localDateTime.getMonth();
		
		int dayOfYear = localDateTime.getDayOfYear(); // 이번년도 며칠지났는지
		int dayOfMonth = localDateTime.getDayOfMonth(); // 이번달 며칠인지
		DayOfWeek dayOfWeek = localDateTime.getDayOfWeek(); // 영어로 요일
		
		boolean isLeapYear = localDate.isLeapYear(); // 윤달인지 아닌지
		
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		int second = localDateTime.getSecond();
		int nano = localDateTime.getNano();
		
		// 특정 날짜 및 시간 변경 (직접 변경, 더하기, 빼기)
		// 직접 변경 : withXXX(int 타입 데이터);
		// 더하기 - 빼기 : plusXXX(long 타입 데이터), minusXXX(long 타입 데이터):
		localDateTime.withYear(2012).plusWeeks(4).minusHours(9);
		localDateTime.withDayOfYear(1).plusMinutes(50).minusNanos(50000);

		Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
		// 어떤 지역인지 지정하고 인스턴트로 바꿈
		Date datetime = Date.from(instant); // 로컬데이터나 타임을 이렇게 바꿔줄 수 있음
		System.out.println(datetime);
		
		
	}
	

}
