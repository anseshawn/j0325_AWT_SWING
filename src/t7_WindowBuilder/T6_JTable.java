package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import t8_insa.InsaDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class T6_JTable extends JFrame{
	InsaDAO dao = new InsaDAO();
	private JTable table;
	private Vector title, vData; // 버전 차이로 제너릭이 안됨...
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;

	public T6_JTable() {
		super("JTable 연습");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 484, 46);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JButton btnPrint = new JButton("선택셀 출력");
		btnPrint.setBounds(12, 10, 120, 26);
		pn1.add(btnPrint);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setBounds(352, 10, 120, 26);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 46, 484, 178);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		
		// table = new JTable();
		// scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 223, 484, 38);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMessage = new JLabel("JTable에서 선택된 값을 출력합니다");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 484, 38);
		pn3.add(lblMessage);
		
		/* 아래로 JTable 설계하기 */
		// JTable제작시에는 '부제목'과 '데이터'를 설계하여 Vector 타입으로 준비한다.
		// (subtitle에 분류 적고, vData 가져와서 뿌리기)
		
		// 1. '부제목'을 Vector에 저장
		title = new Vector<>();
		title.add("번호");
		title.add("이름");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector타입으로 준비 (데이터는 DB에서 가져온다)
		vData = dao.getInsaList("",""); //(DAO에서 불러와서 쓸거임)
		
		// 3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel객체를 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData,title);
		
		// 4. DefaultTableModel에 담긴 벡터타입의 '데이터/타이틀'을 JTable객체 생성시에 담아준다.
		table = new JTable(dtm);
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함께 담아서 생성해 준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 168);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
//-----------------------------------------------------------------------
		
		// 종료 버튼 마우스 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		setVisible(true); // 창이 겹치면 제일 아래로 빼기
	}
	
	public static void main(String[] args) {
		new T6_JTable();
	}
}
