package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.BookDao;
import DTO.BookDto;
import DTO.LoanDto;
import DTO.UserDto;

public class BookSelect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	UserDto userdto = new UserDto();
	LoanDto loandto = new LoanDto();
	BookDao bookdao = BookDao.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookSelect frame = new BookSelect();
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
	public BookSelect(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHeader = new JLabel("도서 조회");
		lbHeader.setIcon(new ImageIcon(BookInsert.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("굴림", Font.BOLD, 30));
		lbHeader.setBounds(142, 30, 300, 40);
		contentPane.add(lbHeader);
		
		String[] header = {"고유번호","제목","저자","분야","수량"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		
		ArrayList<BookDto> bookList = bookdao.selectAll();
	    for (BookDto b : bookList) {
	        Object[] rowData = {
	            b.getIsbn(),
	            b.getTitle(),
	            b.getWriter(),
	            b.getCategory(),
	            b.getBookcnt()
	        };
	        dtm.addRow(rowData);
	    }
	    
		JTable table = new JTable();
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(17, 100, 550, 200);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);;
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(50); 
		table.getColumnModel().getColumn(4).setPreferredWidth(35);
        contentPane.setLayout(null);
        contentPane.add(scrollPane);
        
        JButton btnClose = new JButton("닫기");
        btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
        btnClose.setBounds(467, 310, 100, 40);
        contentPane.add(btnClose);
        
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminSelect as = AdminSelect.getInstance(id);
				as.setVisible(true);
			}
		});
        
	}

}
