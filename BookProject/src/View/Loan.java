package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import DAO.BookDao;
import DAO.UserDao;
import DTO.BookDto;
import DTO.UserDto;

public class Loan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	BookDao bookdao = BookDao.getInstance();
	UserDao userdao = UserDao.getInstance();
	UserDto userdto = new UserDto();
	Login_User lgUser = Login_User.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Loan frame = new Loan();
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
	public Loan(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String[] header = {"고유번호","제목","저자","분야","권수"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		
		ArrayList<BookDto> booklist = bookdao.selectAll();
	    for (BookDto b : booklist) {
	        Object[] rowData = {
	            b.getIsbn(),
	            b.getTitle(),
	            b.getWriter(),
	            b.getCategory(),
	            b.getBookcnt()
	        };
	        dtm.addRow(rowData);
	    }
	    
		JTable table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 80, 500, 200);
		TableColumn isbnColumn = table.getColumnModel().getColumn(0);
		TableColumn titleColumn = table.getColumnModel().getColumn(1);
		TableColumn publisherColumn = table.getColumnModel().getColumn(2);
		TableColumn categoryColumn = table.getColumnModel().getColumn(3); 
		TableColumn cntColumn = table.getColumnModel().getColumn(4);
		isbnColumn.setPreferredWidth(70);
        titleColumn.setPreferredWidth(200);
        publisherColumn.setPreferredWidth(100);
        categoryColumn.setPreferredWidth(50);
        cntColumn.setPreferredWidth(30);
        contentPane.setLayout(null);
        contentPane.add(scrollPane);
        
        JLabel lbTitle = new JLabel(id +  "님 환영합니다.");
        lbTitle.setFont(new Font("굴림", Font.PLAIN, 20));
        lbTitle.setBounds(40, 10, 200, 30);
        contentPane.add(lbTitle);
        
        JButton btnClose = new JButton("닫기");
        btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
        btnClose.setBounds(320, 300, 100, 40);
        contentPane.add(btnClose);
       
        JButton btnLoan = new JButton("대출");
        btnLoan.setFont(new Font("굴림", Font.PLAIN, 25));
        btnLoan.setBounds(440, 300, 100, 40);
        contentPane.add(btnLoan);
        
        JLabel lbSearch = new JLabel("검색어");
        lbSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        lbSearch.setBounds(40, 40, 80, 30);
        contentPane.add(lbSearch);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        txtSearch.setBounds(120, 40, 300, 30);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        btnSearch.setBounds(443, 40, 97, 30);
        contentPane.add(btnSearch);
        
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
}
