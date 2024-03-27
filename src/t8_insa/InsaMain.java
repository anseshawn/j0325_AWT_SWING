package t8_insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame{
	JButton btnInput, btnSearch, btnList, btnExit;
	
	public InsaMain() {
		super("인사관리 메뉴");
		setSize(800,600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 68);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리 프로그램(v1.0)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 760, 68);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 88, 760, 385);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMainImage = new JLabel("");
		lblMainImage.setIcon(new ImageIcon(InsaMain.class.getResource("/t8_insa/images/121.jpg")));
		lblMainImage.setBounds(0, 0, 760, 385);
		pn2.add(lblMainImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 483, 760, 68);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 17));
		btnInput.setBounds(32, 10, 150, 50);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 17));
		btnSearch.setBounds(214, 10, 150, 50);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.PLAIN, 17));
		btnList.setBounds(396, 10, 150, 50);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 17));
		btnExit.setBounds(578, 10, 150, 50);
		pn3.add(btnExit);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
		
		// 종료 버튼 마우스 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 종료 버튼 키보드 엔터시 수행
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			};
		});

		
		// 전체 조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaList();
			}
		});
		
		
		// 개별 조회 버튼 마우스 클릭시 수행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요.");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else {
					dispose();
					new InsaSearch(vo);
				}
				dao.connClose();
			}
		});
		// 개별 조회 버튼 엔터키로 수행
		btnSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요.");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else {
					dispose();
					new InsaSearch(vo);
				}
				dao.connClose();
			}
		});
		
		
		// 사원 등록 버튼을 마우스로 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.exit(0); -> JVM을 완전히 닫아버림
				dispose(); // JVM은 유지하고 현재 창만 닫기
				new InsaInput();
			}
		});
		// 사원 등록 버튼을 키보드 엔터키로 수행
		btnInput.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				dispose();
				new InsaInput();
			}
		});
		
	}
	
	public static void main(String[] args) {
		new InsaMain();
	}
	
}
