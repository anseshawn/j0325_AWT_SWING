package t6_Swing;

import javax.swing.JFrame;

public class Test4_windowsClose extends JFrame {
	
	public Test4_windowsClose() {
		super("스윙연습4");
		
		setBounds(300,250,300,250);
		
		setVisible(true);
		
		// 윈도우 창 닫기 (JFrame에서 제공해주는 메소드)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Test4_windowsClose();
	}
}
