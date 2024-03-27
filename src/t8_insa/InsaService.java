package t8_insa;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;

	// 오늘의 날짜를 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance(); // 싱글톤이라 클래스명으로 호출
		vo.setCbYY(cal.get(Calendar.YEAR)+""); // Calendar객체에서 지정해준 오늘의 연도 (객체->String이므로 문자형으로 변환)
		vo.setCbMM((cal.get(Calendar.MONTH)+1)+""); // 월은 0부터 출력이라 +1을 더해서 저장
		vo.setCbDD(cal.get(Calendar.DATE)+"");
		
		return vo;
	}

}
