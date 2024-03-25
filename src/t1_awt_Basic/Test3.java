package t1_awt_Basic;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 종료버튼처리...(인터페이스를 이용)
@SuppressWarnings("serial")
public class Test3 extends Frame implements WindowListener {
	
	// Test2 객체 생성시에 UI설계 처리를 한다(프레임 배치 등)
	public Test3() {
		// 1. 화면 띄우기
		super("AWT 프레임");
		setSize(300, 250);
		setVisible(true);
		
		// 3. 윈도우리스너 올리기 (동작 감시하여 실행하기)
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new Test3(); // 자신이 가지고 있는 생성자 호출
		
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); // 2. 실행종료(윈도우창 닫기) JVM닫는 메소드 호출(0번이 무조건 닫는것)
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
