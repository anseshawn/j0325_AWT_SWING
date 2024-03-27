package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import t8_insa.InsaDAO;
import t8_insa.InsaVO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class T7_JTable extends JFrame{
	InsaDAO dao = new InsaDAO();
	private JTable table;
	private Vector title, vData; // 버전 차이로 제너릭이 안됨...
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;

	public T7_JTable() {
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
		
		// + 테이블의 내용을 행(타이틀) 이름으로 정렬 (오름차순/내림차순) 하기
		table.setRowSorter(new TableRowSorter(dtm)); // 객체를 만들어서 올려놓기 (객체 안에 내용vData,title 넣기)
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함께 담아서 생성해 준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 168);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
		/* JTable 속성 제어하기 */
		// table의 컬럼크기 설정
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		// table의 컬럼 크기 고정
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		// 여러 컬럼에 적용하고 싶으면 for문.. JTable에 관한 함수가 많으니까 메소드로 따로 빼는 것도 방법...
		
		// 컬럼 위치 고정
		table.getTableHeader().setReorderingAllowed(false);
		
		// 셀 안의 내용을 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // dtcr을 수평정렬(왼쪽,가운데,오른쪽 정렬)
		TableColumnModel tcm = table.getColumnModel();
		// tcm.getColumn(3).setCellRenderer(dtcr); // 3번 컬럼에 dtcr 적용
		
		// 전체 셀 가운데 정렬...
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
//-----------------------------------------------------------------------
		
		// 테이블에서 선택된 셀의 레코드(행)의 정보를 출력하기(마우스)
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); // 컬럼은 열 row는 행
				int column = table.getSelectedColumn();
//				if(row < 0) {
//					JOptionPane.showMessageDialog(null,"행을 선택 후 버튼을 눌러주세요.");
//				}
//				else {
//					JOptionPane.showMessageDialog(null,"선택된 인덱스 행 번호 : "+row+", 열번호 : "+column);
//				}
				
				if(row != -1) {
//					System.out.println("선택된 내용 : "+table.getValueAt(row, column));
//					lblMessage.setText("선택된 내용 : "+table.getValueAt(row, column));
					
					// 선택된 행의 모든 정보를 메세지 창에 띄우시오
					InsaVO vo = dao.getNameSearch(table.getValueAt(row, 1)+"");
					String temp = "성명:"+vo.getName()+", 나이:"+vo.getAge()+", 성별:"+vo.getGender()+", 입사일:"+vo.getIpsail().substring(0,10);
					System.out.println(temp);
					JOptionPane.showMessageDialog(null, temp);
				}
				
			}
		});
		
		// 종료 버튼 마우스 클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		setVisible(true); // 창이 겹치면 제일 아래로 빼기
	}
	
	public static void main(String[] args) {
		new T7_JTable();
	}
}
