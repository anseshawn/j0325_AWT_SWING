package t1_awt_Basic;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 프레임 위치 조절
@SuppressWarnings("serial")
public class Test5 extends Frame implements WindowListener, ActionListener {
	
	// Test2 객체 생성시에 UI설계 처리를 한다(프레임 배치 등)
	public Test5() {
		super("AWT 프레임");
		setBounds(300, 200, 350, 250); // 4. 프레임의 위치/크기 : 창 뜨는 위치 조절(x좌표,y좌표,width,height)
		
		// 5. 레이블 컴포넌트
		Label lbl1 = new Label("레이블 테스트입니다.");
		// 한글 깨지는 걸 방지하기 위해 Run Config의 Argumets탭에서 -Dfile.encoding=MS949 입력 
		// this.add(lbl1);
		add(lbl1); // 메소드명 앞의 this는 생략 가능
		
		Button btnExit = new Button("종료"); // 1. 컴포넌트를 만들고
		add(btnExit); // 2. 화면에 올리기
		
		setVisible(true);
		addWindowListener(this); // 리스너(윈도우 감지부분 처리)
		// 위에 만든 btnExit 버튼 감지 리스너
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Test5(); // 자신이 가지고 있는 생성자 호출
		
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); // 버튼을 감지하고 있는 객체가 이 메소드를 호출하면 윈도우를 닫게된다
	}
}
