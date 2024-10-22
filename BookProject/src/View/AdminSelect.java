package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.BookDao;

public class AdminSelect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static AdminSelect as = null;
	MainFrame mf = MainFrame.getInstance();
	BookDao bookdao = BookDao.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminSelect frame = new AdminSelect();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public static AdminSelect getInstance(String id) {
		if(as == null) {
			as = new AdminSelect(id);
		}
		return as;
	}
	/**
	 * Create the frame.
	 */
	private AdminSelect(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 450, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("<html>도서<br>등록</html>");
		btnInsert.setFont(new Font("굴림", Font.BOLD, 30));
		btnInsert.setBounds(95, 50, 120, 100);
		contentPane.add(btnInsert);
		
		JButton btnSelect = new JButton("<html>도서<br>조회</html>");
		btnSelect.setFont(new Font("굴림", Font.BOLD, 30));
		btnSelect.setBounds(235, 50, 120, 100);
		contentPane.add(btnSelect);
		
		JButton btnUpdate = new JButton("<html>도서<br>수정</html>");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 30));
		btnUpdate.setBounds(95, 170, 120, 100);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("<html>도서<br>삭제</html>");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 30));
		btnDelete.setBounds(235, 170, 120, 100);
		contentPane.add(btnDelete);
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInsert bi = new BookInsert(id);
				bi.setVisible(true);
				setVisible(false);
			}
		});
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSelect bs = new BookSelect(id);
				bs.setVisible(true);
				setVisible(false);
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = JOptionPane.showInputDialog(null, "변경할 도서의 고유번호를 입력하세요.");
				if(isbn != null) {
					if(bookdao.isin(isbn)) {
						String bookcnt = JOptionPane.showInputDialog(null, "변경할 도서의 수량을 입력하세요.");
						if(bookcnt != null) {
							bookdao.update(isbn, Integer.parseInt(bookcnt));
							JOptionPane.showMessageDialog(null, "수정 성공!","도서 수정",JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "고유번호를 확인해주세요.","도서 수정",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = JOptionPane.showInputDialog(null, "삭제할 도서의 고유번호를 입력하세요.");
				if(isbn != null) {
					if(bookdao.isin(isbn)) {
						bookdao.delete(isbn);
						JOptionPane.showMessageDialog(null, "삭제 성공!","도서 삭제",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "고유번호를 확인해주세요.","도서 삭제",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}

}
