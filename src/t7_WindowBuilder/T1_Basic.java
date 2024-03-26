package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1_Basic extends JFrame {
	private JTextField textName,textKor,textEng,textMat;
	private JButton btnInput, btnReset, btnExit;

	public T1_Basic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("그린중학교 성적표");
		lblTitle.setFont(new Font("경기천년제목 Medium", Font.PLAIN, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(81, 10, 642, 67);
		getContentPane().add(lblTitle);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		lblName.setBounds(60, 87, 125, 53);
		getContentPane().add(lblName);
		
		JLabel lblKor = new JLabel("국어점수");
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		lblKor.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		lblKor.setBounds(60, 199, 125, 53);
		getContentPane().add(lblKor);
		
		JLabel lblEng = new JLabel("영어점수");
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		lblEng.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		lblEng.setBounds(60, 313, 125, 53);
		getContentPane().add(lblEng);
		
		JLabel lblMat = new JLabel("수학점수");
		lblMat.setHorizontalAlignment(SwingConstants.CENTER);
		lblMat.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		lblMat.setBounds(60, 431, 125, 53);
		getContentPane().add(lblMat);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		textName.setBounds(197, 91, 490, 53);
		getContentPane().add(textName);
		textName.setColumns(10);
		
		textKor = new JTextField();
		textKor.setHorizontalAlignment(SwingConstants.CENTER);
		textKor.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		textKor.setColumns(10);
		textKor.setBounds(197, 199, 490, 53);
		getContentPane().add(textKor);
		
		textEng = new JTextField();
		textEng.setHorizontalAlignment(SwingConstants.CENTER);
		textEng.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		textEng.setColumns(10);
		textEng.setBounds(197, 313, 490, 53);
		getContentPane().add(textEng);
		
		textMat = new JTextField();
		textMat.setHorizontalAlignment(SwingConstants.CENTER);
		textMat.setFont(new Font("KBIZ한마음명조 R", Font.PLAIN, 17));
		textMat.setColumns(10);
		textMat.setBounds(197, 431, 490, 53);
		getContentPane().add(textMat);
		
		btnInput = new JButton("입 력");
		btnInput.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		btnInput.setBounds(124, 512, 95, 27);
		getContentPane().add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		btnReset.setBounds(343, 512, 95, 27);
		getContentPane().add(btnReset);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("KBIZ한마음고딕 R", Font.PLAIN, 15));
		btnExit.setBounds(562, 512, 95, 27);
		getContentPane().add(btnExit);
		
		// 위쪽은 디자인
		setVisible(true);
		// 아래쪽은 메소드
		
		// 입력 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textKor.setText("");
				textEng.setText("");
				textMat.setText("");
				textName.requestFocus();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "작업을 종료하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
				if(ans == 0)	System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new T1_Basic();
	}
}
