package t8_insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaInput extends JFrame {
	JButton btnInput,btnReset,btnClose;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	JComboBox cbYY, cbMM, cbDD;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;

	public InsaInput() {
		super("회원가입창");
		setSize(800,600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 89);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 가 입 폼");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setBounds(0, 0, 760, 89);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 109, 760, 343);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(115, 36, 126, 40);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 20));
		lblAge.setBounds(115, 112, 126, 40);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 20));
		lblGender.setBounds(115, 188, 126, 40);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.PLAIN, 20));
		lblIpsail.setBounds(115, 264, 126, 40);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("굴림", Font.PLAIN, 20));
		txtName.setBounds(253, 36, 460, 40);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("굴림", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(253, 112, 460, 40);
		pn2.add(txtAge);
		
		JRadioButton rdGenderMale = new JRadioButton("남자");
		btnGroupGender.add(rdGenderMale);
		rdGenderMale.setFont(new Font("굴림", Font.PLAIN, 20));
		rdGenderMale.setBounds(252, 197, 121, 23);
		pn2.add(rdGenderMale);
		
		JRadioButton rdGenderFemale = new JRadioButton("여자");
		btnGroupGender.add(rdGenderFemale);
		rdGenderFemale.setSelected(true);
		rdGenderFemale.setFont(new Font("굴림", Font.PLAIN, 20));
		rdGenderFemale.setBounds(477, 199, 121, 23);
		pn2.add(rdGenderFemale);
		
		// 년도/월/일/ 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 0;
		for(int i=0; i<yy.length; i++) {
			imsi = 2024 - i;
			yy[i] = imsi + "";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		cbYY = new JComboBox(yy);
		cbYY.setBounds(253, 272, 71, 29);
		pn2.add(cbYY);
		
		cbMM = new JComboBox(mm);
		cbMM.setBounds(389, 272, 71, 29);
		pn2.add(cbMM);
		
		cbDD = new JComboBox(dd);
		cbDD.setBounds(527, 272, 71, 29);
		pn2.add(cbDD);
		
		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("굴림", Font.PLAIN, 20));
		lblYear.setBounds(328, 273, 60, 27);
		pn2.add(lblYear);
		
		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(465, 273, 60, 27);
		pn2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("일");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(599, 273, 60, 27);
		pn2.add(lblNewLabel_1_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 462, 760, 89);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInput.setBounds(48, 10, 189, 69);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 20));
		btnReset.setBounds(285, 10, 189, 69);
		pn3.add(btnReset);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		btnClose.setBounds(522, 10, 189, 69);
		pn3.add(btnClose);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
		
		// 회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender="";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
					txtName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(rdGenderMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
					// 회원명 중복처리
					vo = dao.getNameSearch(name);
					if(vo.getName() != null) { // 이름이 있다 = 중복이다
						JOptionPane.showMessageDialog(null, "이미 가입 된 회원입니다. 다시 성명을 입력해주세요.");
						txtName.requestFocus();
					}
					else {
						// 정상적으로 자료가 입력되었다면 vo에 값을 담아서 DB에 저장한다.
						vo.setName(name);
						vo.setAge(Integer.parseInt(age));
						vo.setGender(gender);
						vo.setIpsail(ipsail);
						
						res = dao.setInsaInput(vo);
						if(res != 0) {
							JOptionPane.showMessageDialog(null, "회원 가입이 완료되었습니다.");
							dispose();
							new InsaMain();
						}
						else {
							JOptionPane.showMessageDialog(null, "회원 가입 실패~~ 다시 가입해주세요.");
							txtName.requestFocus();
						}
					}
				}
				
			}
		});
		
		// 다시 입력
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtName.requestFocus();
			}
		});
		
		// 창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaMain();
			}
		});
	}
	
	// 모든 프로그램에 메인은 하나만
//	public static void main(String[] args) {
//		new InsaInput();
//	}
}
