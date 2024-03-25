package t4_panel;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T1_GridPanel2 extends Frame implements WindowListener, ActionListener {
	Panel pn1, pn2, pn3;
	Label lbl1, lbl2, lbl3;
	Button btnExit;
	
	public T1_GridPanel2() {
		super("그리드 패널 연습");
		setLayout(new GridLayout(3,1));
		setBounds(400,350,400,350);
		
		pn1 = new Panel();
		pn2 = new Panel();
		pn3 = new Panel();
		
		lbl1 = new Label("첫번째 패널입니다.");
		lbl2 = new Label("두번째 패널입니다.");
		lbl3 = new Label("세번째 패널입니다.");
		
		btnExit = new Button("종료");
		
		pn1.add(lbl1);	
		pn2.add(lbl2);
		pn3.add(lbl3);
		pn3.add(btnExit);

		this.add(pn1);
		add(pn2);
		add(pn3);
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T1_GridPanel2();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {System.exit(0);}
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
