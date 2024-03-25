package t6_Swing;

import javax.swing.JFrame;

// 화면 중앙에 윈도우 정렬... / 윈도우 크기 고정...
public class Test5_windowsAlign extends JFrame {
	
	public Test5_windowsAlign() {
		super("스윙연습5");
		
		// setBounds(300,250,300,250);
		
		setSize(300, 250); //(폭, 높이)
		setLocationRelativeTo(null); // 윈도우 화면 중앙에 배치
		setResizable(false); // true: 창크기 변경 가능 , false: 크기 고정
		
		setVisible(true);
		
		// 윈도우 창 닫기 (JFrame에서 제공해주는 메소드)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test5_windowsAlign();
	}
}
