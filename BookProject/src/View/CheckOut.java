package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import DAO.LoanDao;
import DAO.UserDao;
import DTO.BookDto;
import DTO.LoanDto;
import DTO.UserDto;

public class CheckOut extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private String isbn = null;
	private String title = null;
	private String writer = null;
	private String category = null;
	UserDto userdto = new UserDto();
	LoanDto loandto = new LoanDto();
	BookDao bookdao = BookDao.getInstance();
	UserDao userdao = UserDao.getInstance();
	LoanDao loandao = LoanDao.getInstance();
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
	public CheckOut(String id) {
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
		TableColumn writerColumn = table.getColumnModel().getColumn(2);
		TableColumn categoryColumn = table.getColumnModel().getColumn(3); 
		TableColumn cntColumn = table.getColumnModel().getColumn(4);
		isbnColumn.setPreferredWidth(100);
        titleColumn.setPreferredWidth(250);
        writerColumn.setPreferredWidth(70);
        categoryColumn.setPreferredWidth(50);
        cntColumn.setPreferredWidth(25);
        contentPane.setLayout(null);
        contentPane.add(scrollPane);
        
        JLabel lbTitle = new JLabel(id +  "님 환영합니다.");
        lbTitle.setFont(new Font("굴림", Font.PLAIN, 20));
        lbTitle.setBounds(40, 10, 300, 30);
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
        
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
    			int row = table.getSelectedRow();
    			isbn = (String) table.getValueAt(row, 0);
    			title = (String) table.getValueAt(row, 1);
    			writer = (String) table.getValueAt(row, 2);
    			category = (String) table.getValueAt(row, 3);
			}
        });
        
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserSelect us = UserSelect.getInstance(id);
				us.setVisible(true);
			}
		});
        
        btnLoan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				loandto.setIsbn(isbn);
				loandto.setTitle(title);
				loandto.setWriter(writer);
				loandto.setCategory(category);
				loandto.setId(id);
				loandao.insert(loandto);
				Notice_Success ntcscs = Notice_Success.getInstance();
				ntcscs.setVisible(true);
			}
		});
		
	}
}
