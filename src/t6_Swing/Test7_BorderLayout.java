package t6_Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test7_BorderLayout extends JFrame {
	JPanel pn1;
	JButton btn1,btn2,btn3,btn4,btn5;
	
	public Test7_BorderLayout() {
		super("BorderLayout 연습");
		setSize(300,300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pn1 = new JPanel();
		pn1.setLayout(null); //패널배치를 임의로 좌표를 주겠다는 뜻
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
		btn4 = new JButton("동쪽");
		btn5 = new JButton("중앙(종료)");
		
		setLayout(new BorderLayout());
		btn5.setBounds(10, 100, 150, 30); // 패널 위에서의 버튼 좌표
		pn1.add(btn5);
		
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
		add(btn4, BorderLayout.EAST);
		//add(btn5, BorderLayout.CENTER);
		add(pn1, BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test7_BorderLayout();
	}
}
