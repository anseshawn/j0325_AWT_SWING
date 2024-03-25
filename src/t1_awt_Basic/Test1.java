package t1_awt_Basic;

import java.awt.Frame;

// 직접 Frame 객체를 생성해서 작업처리
public class Test1 {
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		frame.setTitle("AWT 프레임");
		frame.setSize(300, 250); // 프레임의 크기 (폭, 높이) : 픽셀단위
		
		frame.setVisible(true); // 화면에 보여주는 것을 참으로 설정
	}
}
