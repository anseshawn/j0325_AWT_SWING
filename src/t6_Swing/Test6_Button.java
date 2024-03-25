package t6_Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test6_Button extends JFrame {
	JButton btnExit;
	
	public Test6_Button() {
		super("컴포넌트 연습");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
		setVisible(true); // 기준점으로 위쪽은 UI(그래픽) 아래쪽은 명령코드(메소드)
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test6_Button();
	}
}
