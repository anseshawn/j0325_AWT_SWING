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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaSearch extends JFrame {
	JButton btnUpdate,btnDelete,btnClose;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	JComboBox cbYY, cbMM, cbDD;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;

	public InsaSearch(InsaVO vo) {
		super("회원가입창");
		setSize(800,600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 89);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 개 별 조 회(수정/삭제처리)");
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
		txtName.setEditable(false);
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
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 20));
		btnUpdate.setBounds(48, 10, 189, 69);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDelete.setBounds(285, 10, 189, 69);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		btnClose.setBounds(522, 10, 189, 69);
		pn3.add(btnClose);
		
		// <개별검색결과> vo에 담겨서 넘어온 회원의 정보를 검색창에 뿌려주도록 한다.
		txtName.setText(vo.getName());
		txtAge.setText(vo.getAge()+"");
		if(vo.getGender().equals("남자")) rdGenderMale.setSelected(true);
		if(vo.getGender().equals("여자")) rdGenderFemale.setSelected(true);
		
		// <DB의 날짜형식을 콤보상자의 날짜형식과 일치시켜서 비교하기 위한 작업>
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d"); // 선택지 창은 01이 아니라 1이 되어있기 때문에
		// 1. 2024-03-25 를 2024-3-25로 변경
		LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10),dtf); // 2. 날짜형식을 문자로 parsing 후 dtf로 변경
		String strDate = date.format(dtf); // 3. 날짜 타입을 문자로 변경
		
		String[] ymds = strDate.split("-"); // 4. 변경한 문자를 - 기준으로 자름
		cbYY.setSelectedItem(ymds[0]);	// 5. 배열에 저장된 값을 콤보상자에 넣어줌
		cbMM.setSelectedItem(ymds[1]);
		cbDD.setSelectedItem(ymds[2]);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
		
		// 회원정보 수정 버튼 마우스로 실행
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText().trim();
				String gender="";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사
				if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(rdGenderMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 모든 체크가 끝나면 DB에 회원정보를 수정처리한다.
					vo.setName(txtName.getText());
					vo.setAge(Integer.parseInt(age));
					vo.setGender(gender);
					vo.setIpsail(ipsail);
					
					res = dao.setInsaUpdate(vo);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, "회원 정보가 수정되었습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원 정보 수정 실패~~");
					}
				}
				
			}
		});
		
		// 삭제 버튼 마우스로 실행
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				
				int ans = JOptionPane.showConfirmDialog(null, name+"회원을 삭제하시겠습니까?", "회원삭제창",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, name+"회원 삭제 완료");
						dispose();
						new InsaMain();
					}
					else JOptionPane.showMessageDialog(null, name+"회원 삭제 실패");
				}
				else JOptionPane.showMessageDialog(null, "회원 삭제 취소");
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
