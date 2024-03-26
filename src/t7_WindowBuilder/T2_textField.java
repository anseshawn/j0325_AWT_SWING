package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class T2_textField extends JFrame {
	private JTextField txtMid,txtName,txtAge;
	JButton btnSubmit, btnReset, btnExit;
	private JPasswordField txtPwd;
	
	private String regage = "^[0-9]+$";

	public T2_textField() {
		super("회원가입");
		setSize(600, 480);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(12, 10, 560, 62);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 536, 42);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 88, 560, 279);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMid.setBounds(35, 28, 124, 34);
		pn2.add(lblMid);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("굴림", Font.PLAIN, 18));
		lblPwd.setBounds(35, 90, 124, 34);
		pn2.add(lblPwd);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(35, 152, 124, 34);
		pn2.add(lblName);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.PLAIN, 18));
		txtMid.setBounds(209, 23, 276, 41);
		pn2.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(209, 151, 276, 41);
		pn2.add(txtName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 18));
		lblAge.setBounds(35, 214, 124, 34);
		pn2.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 18));
		txtAge.setColumns(10);
		txtAge.setBounds(209, 215, 276, 41);
		pn2.add(txtAge);
		
		txtPwd = new JPasswordField(); // 이미지 위에 놓으면 잔상이 남지 않음
		txtPwd.setBackground(Color.WHITE);
		txtPwd.setBounds(209, 90, 276, 41);
		pn2.add(txtPwd);
		
		JLabel lblimage = new JLabel("");
//		lblimage.setIcon(new ImageIcon("D:\\javaclass\\java\\works\\j0325_AWT_Swing_Windowbuilder\\myImages\\121.jpg"));
		lblimage.setIcon(new ImageIcon("./myImages/121.jpg"));
//		lblimage.setIcon(new ImageIcon(Test2.class.getResource("/myImages/121.jpg")));
		lblimage.setBounds(0, 0, 560, 279);
		pn2.add(lblimage);
				
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 381, 560, 50);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnSubmit = new JButton("회원가입");
		btnSubmit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSubmit.setBounds(43, 10, 118, 30);
		pn3.add(btnSubmit);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(218, 10, 118, 30);
		pn3.add(btnReset);
		
		btnExit = new JButton("종료");
		btnExit.setIcon(new ImageIcon(T2_textField.class.getResource("/t7_WindowBuilder/images/exit.png")));
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(394, 10, 118, 30);
		pn3.add(btnExit);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setVisible(true);
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ---------------------------------------아래쪽은 메소드------------------------------
		
		// 회원가입 버튼
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMid.getText().trim().equals("")) { // getText: txtMid에 입력된 값을 읽어오기, trim: 공백제거
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
					txtMid.requestFocus(); // 커서 이동
				}
				else if(txtPwd.getText().trim().equals("")) { 
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					txtPwd.requestFocus(); // 커서 이동
				}
				else if(txtName.getText().trim().equals("")) { 
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
					txtName.requestFocus(); // 커서 이동
				}
//				else if(txtAge.getText().trim().equals("")) { 
//					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
//					txtAge.requestFocus(); // 커서 이동
//				}
				else if(!Pattern.matches(regage, txtAge.getText().trim())) {
					JOptionPane.showMessageDialog(null, "나이는 숫자만 입력하세요");
					txtAge.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "회원 가입 완료!!");
				}
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtMid.requestFocus();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new T2_textField();
	}
}
