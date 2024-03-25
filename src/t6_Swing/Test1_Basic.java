package t6_Swing;

import javax.swing.JFrame;

public class Test1_Basic extends JFrame {
	
	public Test1_Basic() {
		super("스윙연습1");
		
		setBounds(300,250,300,250);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Test1_Basic();
	}
}
