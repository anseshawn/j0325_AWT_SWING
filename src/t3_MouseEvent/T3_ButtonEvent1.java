package t3_MouseEvent;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T3_ButtonEvent1 extends Frame implements WindowListener,ActionListener {
	Button btnPlay, btnStop, btnExit;
	
	public T3_ButtonEvent1() {
		super("버튼 이벤트 연습");
		setLayout(new FlowLayout());
		setBounds(350, 300, 300, 250);
		
		btnPlay = new Button("Start");
		btnStop = new Button("Stop");
		btnExit = new Button("Exit");
		add(btnPlay);
		add(btnStop);
		add(btnExit);
		
		setVisible(true);
		
		addWindowListener(this);
		btnPlay.addActionListener(this);
		btnStop.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T3_ButtonEvent1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btnText = (Button) e.getSource(); // 다운캐스팅
		
		if(btnText.getLabel().equals("Start")) {
			System.out.println("시작버튼을 누르셨군요.");
		}
		else if(btnText.getLabel().equals("Stop")) {
			System.out.println("정지버튼을 누르셨군요.");
		}
		else {
			System.out.println("종료버튼을 누르셨군요.");
			System.exit(0);
		}		
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
