package t2_Layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 사용자 지정 레이아웃(사용자가 좌표지정)
public class T5_AbsoluteLayout2 extends Frame implements WindowListener,ActionListener {
	Button btn1,btn2,btn3,btn4,btnExit;
	
	public T5_AbsoluteLayout2() {
		super("사용자지정 레이아웃");
		setLayout(null); // 사용자지정 레이아웃(수동 레이아웃)
		setBounds(400, 300, 350, 400);
		
		int x=100, y=100;
		
		btn1 = new Button("첫번째");
		btn2 = new Button("두번째");
		btn3 = new Button("세번째");
		btn4 = new Button("네번째");
		btnExit = new Button("종료");
		btn1.setBounds(x,y,150,30);
		btn2.setBounds(x,y+40,150,30);
		btn3.setBounds(x,y+80,150,30);
		btn4.setBounds(x,y+120,150,30);
		btnExit.setBounds(x,y+160,150,30);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btnExit);
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T5_AbsoluteLayout2();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) { System.exit(0); }
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
