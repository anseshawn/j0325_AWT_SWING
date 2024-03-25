package t1_awt_Basic;

import java.awt.Frame;

// Frame 객체를 상속받아서 작업처리
@SuppressWarnings("serial")
public class Test2 extends Frame{
	
	// Test2 객체 생성시에 UI설계 처리를 한다(프레임 배치 등)
	public Test2() {
		//setTitle("AWT 프레임");
		super("AWT 프레임"); // 상속받았으므로 super로 생성 가능
		setSize(300, 250); // 프레임의 크기 (폭, 높이) : 픽셀단위
		
		setVisible(true); // 화면에 보여주는 것을 참으로 설정
		
	}
	
	public static void main(String[] args) {
		new Test2(); // 자신이 가지고 있는 생성자 호출
	}
}
