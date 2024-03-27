package t7_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class T8_File extends JFrame {
	private JButton btnUpload,btnDelete,btnExit;
	private JFileChooser chooser;
	private JLabel lblImage;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;

	public T8_File() {
		super("파일처리 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 59);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnUpload = new JButton("그림 업로드");
		btnUpload.setBounds(22, 10, 157, 39);
		pn1.add(btnUpload);
		
		btnDelete = new JButton("그림삭제");
		btnDelete.setBounds(191, 10, 157, 39);
		pn1.add(btnDelete);
		
		btnExit = new JButton("종 료");
		btnExit.setBounds(415, 10, 157, 39);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 60, 584, 310);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("사진이 출력됩니다");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(12, 10, 360, 290);
		pn2.add(lblImage);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(384, 10, 188, 290);
//		pn2.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 370, 584, 71);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		// JTable 설계
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더 안의 정보를 가져오기
		getFolderInfo();
		
		dtm = new DefaultTableModel(vData,title);
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(384, 10, 188, 290);
		pn2.add(scrollPane);
		
//------------------------------------------------------------------------------
		
		// 그림 업로드
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 생성
				chooser = new JFileChooser();
				
				// 파일 확장자 선별 출력 처리
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg","gif");
				chooser.setFileFilter(filter);
				
				// 파일 다이얼로그박스 출력 처리
				int res = chooser.showOpenDialog(null); // null일 경우 chooser가 지칭한 것이 올라옴
				
				// 다이얼로그에서 불러온 파일 개수를 정수로 받아서 표현
				if (res != chooser.APPROVE_OPTION) { // 사용자가 파일을 선택하지 않은 경우
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				}
				else {
					// 사용자가 파일을 선택하고 '열기'버튼을 누른 경우 (또는 선택한 파일명을 더블클릭 한 경우)
					String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다
					lblImage.setIcon(new ImageIcon(filePath)); // 생성된 그림을 이미지라벨에 아이콘형식으로 띄운다
					
					// 파일 업로드하기
					try {
						File imageFile = new File(filePath);
						// 파일명은 (1. ~\\mbc\\atom.jpg) (2. ~/mbc/atom.jpg) 처럼 되어있기 때문에 뒤에서부터 \\를 찾은뒤 자르면 파일명 .를 찾은뒤 자르면 확장자 
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // 파일명 + 확장자
						String extension = filePath.substring(filePath.lastIndexOf(".")+1); // 확장자					
						
						/* 위는 업로드 되는 파일의 위치정보+파일명 읽기 / 아래는 서버에 저장되는 폴더+파일명 지정 */
						
						BufferedImage image = ImageIO.read(imageFile); // 객체생성
						// 객체 생성 후 경로에 넣기
						File file = new File("./myImages/"+ fileName); // 자신의 위치에 있기 때문에 ./은 생략 가능
						if(file.exists()) { // exists명령이 존재하는가?(폴더가 있는가?) => 없으면 폴더 만들기
							file.mkdir(); // 폴더만들기
						}
						
						/* 폴더 만들어졌으니 파일 올리기 */
						ImageIO.write(image, extension, file); // image를 file로 업로드시켜준다
						System.out.println("파일명 : "+fileName);
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
//------------------------------------------------------------------------------		
		setVisible(true);
	}
	
	// 폴더 안의 파일 목록(정보)을 가져오는 메소드
	private void getFolderInfo() {
		File folder = new File("./myImages");
		File files[] = folder.listFiles(); // 지정한 폴더에 들어가있는 파일 목록을 배열에 담기
//		for(File f : files) {
//			System.out.println(f.getName());
//		}
		vData = new Vector<>();
		if(files.length != 0) {
			for(int i=0; i<files.length; i++) {
				System.out.println("파일("+(i+1)+") : "+files[i]);
				Vector vo = new Vector<>();
				vo.add(files[i]);
				vData.add(vo);
			}
		}
		
	}

	public static void main(String[] args) {
		new T8_File();
	}
}
