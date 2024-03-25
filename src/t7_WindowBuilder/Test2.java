package t7_WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Test2 extends JFrame {
	private JTextField textField;

	public Test2() {
		super("회원가입");
		setSize(600,480);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 86);
		getContentPane().add(pn1);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 125, 560, 104);
		getContentPane().add(pn2);
		
		JLabel lblNewLabel_1 = new JLabel("성명");
		pn2.add(lblNewLabel_1);
		
		textField = new JTextField();
		pn2.add(textField);
		textField.setColumns(10);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 260, 560, 128);
		getContentPane().add(pn3);
		
		JButton btnNewButton = new JButton("New button");
		pn3.add(btnNewButton);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
