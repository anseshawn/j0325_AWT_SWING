package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T3_Image extends JFrame {
	JButton btnTotal, btn1, btn2, btn3, btn4, btnRandom, btnClose, btnExit;
	JLabel lblImg1,lblImg2,lblImg3,lblImg4,lblCount;
	
	int img1Cnt = 0,img2Cnt = 0,img3Cnt = 0,img4Cnt = 0;
	
	public T3_Image() {
		super("카드 횟수 맞추기");
		setSize(800,480);
		
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 35);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnTotal = new JButton("모두보기");
		btnTotal.setBounds(0, 0, 80, 35);
		pn1.add(btnTotal);
		
		btn1 = new JButton("1번보기");
		btn1.setBounds(80, 0, 80, 35);
		pn1.add(btn1);
		
		btn2 = new JButton("2번보기");
		btn2.setBounds(160, 0, 80, 35);
		pn1.add(btn2);
		
		btn3 = new JButton("3번보기");
		btn3.setBounds(240, 0, 80, 35);
		pn1.add(btn3);
		
		btn4 = new JButton("4번보기");
		btn4.setBounds(320, 0, 80, 35);
		pn1.add(btn4);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(660, 0, 100, 35);
		pn1.add(btnExit);
		
		btnRandom = new JButton("랜덤보기");
		btnRandom.setBounds(400, 0, 80, 35);
		pn1.add(btnRandom);
		
		btnClose = new JButton("모두닫기");
		btnClose.setBounds(480, 0, 80, 35);
		pn1.add(btnClose);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 55, 760, 330);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 395, 760, 40);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		lblCount = new JLabel("1번: 0, 2번: 0, 3번: 0, 4번: 0");
		lblCount.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setBounds(12, 10, 736, 20);
		pn3.add(lblCount);
		
		lblImg1 = new JLabel("");
		lblImg1.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBuilder/images/11.jpg")));
		lblImg1.setBounds(0, 0, 190, 330);
		pn2.add(lblImg1);
		lblImg1.setVisible(false);
		
		lblImg2 = new JLabel("");
		lblImg2.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBuilder/images/12.jpg")));
		lblImg2.setBounds(190, 0, 190, 330);
		pn2.add(lblImg2);
		lblImg2.setVisible(false);
		
		lblImg3 = new JLabel("");
		lblImg3.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBuilder/images/14.png")));
		lblImg3.setBounds(380, 0, 190, 330);
		pn2.add(lblImg3);
		lblImg3.setVisible(false);
		
		lblImg4 = new JLabel("");
		lblImg4.setIcon(new ImageIcon(T3_Image.class.getResource("/t7_WindowBuilder/images/13.png")));
		lblImg4.setBounds(570, 0, 190, 330);
		pn2.add(lblImg4);
		lblImg4.setVisible(false);

		
		// ---------------------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null); // 실행시 윈도우 창이 가운데에 팝업 됨
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		// ---------------------------------------아래쪽은 메소드------------------------------
			
		// 모두보기
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDisplay();
				img1Cnt++; img2Cnt++; img3Cnt++; img4Cnt++;
				dispCount();
			}
		});
		
		// 1번보기
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(true);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				img1Cnt++;
				dispCount();
			}
		});
		// 2번보기
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(true);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				img2Cnt++;
				dispCount();
			}
		});
		// 3번보기
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(true);
				lblImg4.setVisible(false);
				img3Cnt++;
				dispCount();
			}
		});
		// 4번보기
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(true);
				img4Cnt++;
				dispCount();
			}
		});
		//랜덤보기
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//randomDisplay();
				int rand = (int)(Math.random())*4+1;
				if(rand == 1) {
					lblImg1.setVisible(true);
					lblImg2.setVisible(false);
					lblImg3.setVisible(false);
					lblImg4.setVisible(false);
					img1Cnt++;
				}
				if(rand == 2) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(true);
					lblImg3.setVisible(false);
					lblImg4.setVisible(false);
					//img2Cnt++;
				}
				if(rand == 3) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(false);
					lblImg3.setVisible(true);
					lblImg4.setVisible(false);
					img3Cnt++;
				}
				if(rand == 4) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(false);
					lblImg3.setVisible(false);
					lblImg4.setVisible(true);
					img4Cnt++;
				}
				dispCount();
			}
		});
		//모두닫기
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
			}
		});
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 랜덤보기
//	protected void randomDisplay() {
//		int random = (int)(Math.random())*4+1;
//		switch(random) {
//			case 1:
//				lblImg1.setVisible(true);
//				img1Cnt++;
//				dispCount();
//				break;
//			case 2:
//				lblImg2.setVisible(true);
//				img2Cnt++;
//				dispCount();
//				break;
//			case 3:
//				lblImg3.setVisible(true);
//				img3Cnt++;
//				dispCount();
//				break;
//			case 4:
//				lblImg4.setVisible(true);
//				img4Cnt++;
//				dispCount();
//				break;
//		}
//	}

	// 카운트 레이블에 표시하기
	protected void dispCount() {
		lblCount.setText("1번: "+img1Cnt+", 2번: "+img2Cnt+", 3번: "+img3Cnt+", 4번: "+img4Cnt);
	}

	// 모두닫기 처리
	protected void allClose() {
		lblImg1.setVisible(false);
		lblImg2.setVisible(false);
		lblImg3.setVisible(false);
		lblImg4.setVisible(false);		
	}

	// 모두 열기 처리
	protected void allDisplay() {
		lblImg1.setVisible(true);
		lblImg2.setVisible(true);
		lblImg3.setVisible(true);
		lblImg4.setVisible(true);
	}

	public static void main(String[] args) {
		new T3_Image();
	}
}
