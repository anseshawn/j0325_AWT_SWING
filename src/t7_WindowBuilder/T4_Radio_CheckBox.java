package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class T4_Radio_CheckBox extends JFrame {
	JRadioButton rdMale, rdFemale;
	JCheckBox ckHobby1,ckHobby2,ckHobby3,ckHobby4;
	JButton btnGender, btnHobby, btnExit;
	JLabel lblMessage,lblGender,lblHobby;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	
	public T4_Radio_CheckBox() {
		super("라디오/체크박스 연습");
		setSize(600,400);
		
		
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 60);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("라디오버튼/체크박스 연습");
		lblNewLabel.setFont(new Font("KBIZ한마음고딕 M", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 560, 60);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 80, 560, 201);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 17));
		lblGender.setBounds(41, 15, 107, 42);
		pn2.add(lblGender);
		
		rdMale = new JRadioButton("남자");
		btnGroupGender.add(rdMale);
		rdMale.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		rdMale.setBounds(181, 23, 121, 23);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		btnGroupGender.add(rdFemale);
		rdFemale.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		rdFemale.setBounds(306, 23, 121, 23);
		pn2.add(rdFemale);
		
		lblHobby = new JLabel("취 미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 17));
		lblHobby.setBounds(41, 70, 107, 42);
		pn2.add(lblHobby);
		
		ckHobby1 = new JCheckBox("등산");
		ckHobby1.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		ckHobby1.setBounds(156, 81, 85, 23);
		pn2.add(ckHobby1);
		
		ckHobby2 = new JCheckBox("낚시");
		ckHobby2.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		ckHobby2.setBounds(244, 81, 85, 23);
		pn2.add(ckHobby2);
		
		ckHobby3 = new JCheckBox("수영");
		ckHobby3.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		ckHobby3.setBounds(333, 81, 85, 23);
		pn2.add(ckHobby3);
		
		ckHobby4 = new JCheckBox("바둑");
		ckHobby4.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 15));
		ckHobby4.setBounds(426, 81, 85, 23);
		pn2.add(ckHobby4);
		
		lblMessage = new JLabel("메세지 출력");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("KBIZ한마음명조 M", Font.PLAIN, 20));
		lblMessage.setBounds(41, 149, 485, 42);
		pn2.add(lblMessage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 291, 560, 60);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 15));
		btnGender.setBounds(61, 10, 105, 40);
		pn3.add(btnGender);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 15));
		btnExit.setBounds(393, 10, 105, 40);
		pn3.add(btnExit);
		
		btnHobby = new JButton("취미출력");
		btnHobby.setFont(new Font("KBIZ한마음고딕 B", Font.PLAIN, 15));
		btnHobby.setBounds(227, 10, 105, 40);
		pn3.add(btnHobby);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
	
		// 성별출력버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "선택하신 성별은 : ";
				if(rdMale.isSelected()) gender += rdMale.getText();
				else gender += rdFemale.getText();
				
				lblMessage.setText(gender);
			}
		});
		
		// 취미출력버튼
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hobby = "";
				if(ckHobby1.isSelected()) hobby += ckHobby1.getText() + "/";
				if(ckHobby2.isSelected()) hobby += ckHobby2.getText()+ "/";
				if(ckHobby3.isSelected()) hobby += ckHobby3.getText()+ "/";
				if(ckHobby4.isSelected()) hobby += ckHobby4.getText()+ "/";
				
				hobby = hobby.substring(0,hobby.length()-1);
				
				lblMessage.setText("선택하신 취미는 : "+hobby);
				JOptionPane.showMessageDialog(null, "선택 된 취미는 "+ hobby);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new T4_Radio_CheckBox();
	}
}
