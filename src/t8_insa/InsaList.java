package t8_insa;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class InsaList extends JFrame{
	private JTextField txtCondition;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private JTable table;
	private JComboBox cbCondition;
	private JButton btnCondition,btnList,btnExit,btnIpsailAsc,btnIpsailDesc;
	private JRadioButton rdFemale, rdMale;
	private Vector title, vData;
	private InsaDAO dao = new InsaDAO();
	private DefaultTableModel dtm; 
	private JScrollPane scrollPane;
	
	public InsaList() {
		super("전체 조회");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 84);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		cbCondition = new JComboBox();
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"이름", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 24, 80, 37);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setToolTipText("");
		txtCondition.setBounds(104, 24, 176, 37);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnCondition = new JButton("조건검색");
		btnCondition.setBounds(292, 24, 152, 37);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체검색");
		btnList.setBounds(456, 24, 152, 37);
		pn1.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(620, 24, 152, 37);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 84, 784, 398);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		//scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 483, 784, 78);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		rdFemale = new JRadioButton("여자");
		buttonGroupGender.add(rdFemale);
		rdFemale.setBounds(28, 27, 65, 23);
		pn3.add(rdFemale);
		
		rdMale = new JRadioButton("남자");
		buttonGroupGender.add(rdMale);
		rdMale.setBounds(108, 27, 65, 23);
		pn3.add(rdMale);
		
		btnIpsailAsc = new JButton("입사일 오름차순");
		btnIpsailAsc.setBounds(480, 24, 140, 28);
		pn3.add(btnIpsailAsc);
		
		btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setBounds(632, 24, 140, 28);
		pn3.add(btnIpsailDesc);
		
		// JTable 설계
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		vData = dao.getInsaList("","");
		dtm = new DefaultTableModel(vData,title);
		table = new JTable(dtm);
		table.setRowSorter(new TableRowSorter(dtm));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 760, 378);
		pn2.add(scrollPane);
		
// -----------------------------------------------------------------------------------------
		// 아래로 메소드 영역 위로 UI 영역
		
		// 조건 검색 마우스로 실행
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				conditionSearch();
			}
		});
		// 조건 검색 키보드로 실행
		btnCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				conditionSearch();
			}
		});
		
		// 전체 검색 마우스로 실행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalSearch();
			}
		});
		// 전체 검색 키보드 실행
		btnList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				totalSearch();
			}
		});
		
		// 입사일 오름차순
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail","a");
				dtm.setDataVector(vData, title); // 새로 만드는게 아니라 위에 만든거에 set 시키기
			}
		});
		// 입사일 내림차순
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail","d");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaMain();
			}
		});
// -----------------------------------------------------------------------------------------		
		setVisible(true);
	}

	protected void totalSearch() {
		vData = dao.getInsaList("", "");
		dtm.setDataVector(vData, title);
	}

	// 조건 검색 메소드
	protected void conditionSearch() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(txtCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;
		}
		
		if(cbCondi.equals("이름")) vData = dao.getConditionSearch("name", txtCondi); // 필드명이랑 들어온 텍스트를 넘김
		else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]+$", txtCondi)) {
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
				txtCondition.requestFocus();
			}
			else	vData = dao.getConditionSearch("age", txtCondi);
		}
		else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender", txtCondi);
		else if(cbCondi.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCondi);
		
		dtm.setDataVector(vData, title);
	}
}
