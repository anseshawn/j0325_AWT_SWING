package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class T5_Combo_ListBox extends JFrame {
	JButton btnCombo, btnExit,btnList1;
	JComboBox comboJob;
	JLabel lblMessage,lblNewLabel;
	
	public T5_Combo_ListBox() {
		super("콤보상자 연습");
		setSize(600, 500);		
		getContentPane().setLayout(null);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(12, 370, 560, 80);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		lblMessage = new JLabel("출력메세지");
		lblMessage.setFont(new Font("굴림", Font.BOLD, 15));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 548, 80);
		pn4.add(lblMessage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 280, 560, 80);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("굴림", Font.PLAIN, 16));
		btnCombo.setBounds(12, 10, 117, 60);
		pn3.add(btnCombo);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(444, 10, 100, 60);
		pn3.add(btnExit);
		
		btnList1 = new JButton("리스트상자출력1");
		btnList1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList1.setBounds(130, 10, 155, 60);
		pn3.add(btnList1);
		
		JButton btnList2 = new JButton("리스트상자출력2");
		btnList2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList2.setBounds(285, 10, 155, 60);
		pn3.add(btnList2);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(11, 10, 275, 260);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblNewLabel = new JLabel("직업을 선택하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 275, 60);
		pn1.add(lblNewLabel);
		
		comboJob = new JComboBox();
		comboJob.setFont(new Font("굴림", Font.PLAIN, 13));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "회사원", "군인", "변호사", "의사", "공무원", "기타"}));
		comboJob.setBounds(0, 70, 275, 40);
		pn1.add(comboJob);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 120, 275, 140);
		pn1.add(scrollPane_1);
		
		JTextArea txtaMemo = new JTextArea();
		scrollPane_1.setViewportView(txtaMemo);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(297, 10, 275, 260);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JList listJob = new JList();
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "판사", "군인", "공무원", "간호사", "역무원", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listJob.setBounds(12, 10, 251, 119);
		pn2.add(listJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 251, 111);
		pn2.add(scrollPane);
		
		JList listJob2 = new JList();
		listJob2.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "판사", "군인", "공무원", "간호사", "역무원", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob2);
		setVisible(true);
		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
		
		
		// 콤보상자의 내용 출력 메소드
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString() + "("+comboJob.getSelectedIndex()+")";
				lblMessage.setText(msg);
			}
		});
		
		// 리스트 상자 내용 출력 1
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				// Object[] jobs = listJob.getSelectedValues();
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				for(Object job : jobs) {
					msg += job + "/";
				}
				msg = msg.substring(0,msg.length()-1);
				
				lblMessage.setText(msg);
			}
		});
		
		// 리스트 상자 내용 출력 2
//		btnList2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String msg = "";
//				Object[] jobs = listJob2.getSelectedValuesList().toArray();
//				// for(Object job : jobs) msg += job + "\n"; //msg += job + "/"; 
//				//msg = msg.substring(0, msg.length()-1); // 옆으로 길어지는지 아래로 길어지는지에 따라 스크롤 생기는 방향이 달라짐
//				for(Object job : jobs) msg += job + "\n";
//				txtaMemo.setText(msg);
//			}
//		});
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMemo.append(listJob2.getSelectedValue()+"\n");
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
		new T5_Combo_ListBox();
	}
}
