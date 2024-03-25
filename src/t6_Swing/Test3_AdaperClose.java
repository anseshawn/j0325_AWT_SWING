package t6_Swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

// 어댑터를 이용한 Swing의 종료
public class Test3_AdaperClose extends JFrame{
	
	public Test3_AdaperClose() {
		super("스윙연습3");
		
		setBounds(300,250,300,250);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test3_AdaperClose();
	}
}
