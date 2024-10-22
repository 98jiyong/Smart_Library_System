package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.BookDao;
import DTO.BookDto;

public class BookInsert extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtTitle;
	private JTextField txtWriter;
	BookDto bookdto = new BookDto();
	BookDao bookdao = BookDao.getInstance();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInsert frame = new BookInsert();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookInsert(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHeader = new JLabel("도서 등록");
		lbHeader.setIcon(new ImageIcon(BookInsert.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("굴림", Font.BOLD, 30));
		lbHeader.setBounds(150, 30, 300, 40);
		contentPane.add(lbHeader);
		
		JLabel lbIsbn = new JLabel("고유번호");
		lbIsbn.setFont(new Font("굴림", Font.PLAIN, 20));
		lbIsbn.setBounds(70, 100, 100, 30);
		contentPane.add(lbIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("굴림", Font.PLAIN, 20));
		txtIsbn.setBounds(190, 100, 200, 30);
		contentPane.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lbTitle = new JLabel("제목");
		lbTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lbTitle.setBounds(70, 150, 100, 30);
		contentPane.add(lbTitle);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		txtTitle.setColumns(10);
		txtTitle.setBounds(190, 150, 300, 30);
		contentPane.add(txtTitle);
		
		JLabel lbWriter = new JLabel("저자");
		lbWriter.setFont(new Font("굴림", Font.PLAIN, 20));
		lbWriter.setBounds(70, 200, 100, 30);
		contentPane.add(lbWriter);
		
		txtWriter = new JTextField();
		txtWriter.setFont(new Font("굴림", Font.PLAIN, 20));
		txtWriter.setColumns(10);
		txtWriter.setBounds(190, 200, 200, 30);
		contentPane.add(txtWriter);
		
		JLabel lbCategory = new JLabel("분류");
		lbCategory.setFont(new Font("굴림", Font.PLAIN, 20));
		lbCategory.setBounds(70, 250, 100, 30);
		contentPane.add(lbCategory);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소설", "시/에세이", "인문", "가정/육아", "요리", "건강", "취미/스포츠", "경제/경영", "자기계발", "정치/사회", "역사/문화", "외국어", "과학", "컴퓨터/IT", "여행"}));
		comboBox.setBounds(190, 250, 200, 30);
		contentPane.add(comboBox);
		
		JLabel lbBookcnt = new JLabel("수량");
		lbBookcnt.setFont(new Font("굴림", Font.PLAIN, 20));
		lbBookcnt.setBounds(70, 300, 100, 30);
		contentPane.add(lbBookcnt);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("굴림", Font.PLAIN, 20));
		spinner.setBounds(190, 300, 60, 30);
		contentPane.add(spinner);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
		btnClose.setBounds(330, 350, 100, 40);
		contentPane.add(btnClose);
		
		JButton btnInsert = new JButton("등록");
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 25));
		btnInsert.setBounds(450, 350, 100, 40);
		contentPane.add(btnInsert);
		
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminSelect as = AdminSelect.getInstance(id);
				as.setVisible(true);
			}
		});
        
        btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookdto.setIsbn(txtIsbn.getText());
				bookdto.setTitle(txtTitle.getText());
				bookdto.setWriter(txtWriter.getText());
				bookdto.setCategory(comboBox.getSelectedItem().toString());
				bookdto.setBookcnt((int) spinner.getValue());
				bookdao.insert(bookdto);
    			JOptionPane.showMessageDialog(null, "등록 성공!","도서 등록",JOptionPane.INFORMATION_MESSAGE);
				txtIsbn.setText("");
				txtTitle.setText("");
				txtWriter.setText("");
				comboBox.setSelectedIndex(0);
				spinner.setValue(0);
			}
		});
        
	}
}
