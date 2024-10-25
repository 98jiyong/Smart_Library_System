package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
	private int row = 0;
	private String isbn = null;
	private String title = null;
	private String writer = null;
	private String category = null;
	private int bookcnt = 0;
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
		setBounds(350, 300, 600, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbHeader = new JLabel("도서 대출");
		lbHeader.setIcon(new ImageIcon(BookInsert.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("굴림", Font.BOLD, 30));
		lbHeader.setBounds(150, 30, 300, 40);
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
		scrollPane.setBounds(50, 140, 500, 200);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);;
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(50); 
		table.getColumnModel().getColumn(4).setPreferredWidth(35);
        contentPane.setLayout(null);
        contentPane.add(scrollPane);
        
        JLabel lbTitle = new JLabel(id +  "님 환영합니다.");
        lbTitle.setFont(new Font("굴림", Font.PLAIN, 20));
        lbTitle.setBounds(50, 70, 300, 30);
        contentPane.add(lbTitle);
        
        JButton btnClose = new JButton("닫기");
        btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
        btnClose.setBounds(330, 350, 100, 40);
        contentPane.add(btnClose);
       
        JButton btnLoan = new JButton("대출");
        btnLoan.setFont(new Font("굴림", Font.PLAIN, 25));
        btnLoan.setBounds(450, 350, 100, 40);
        contentPane.add(btnLoan);
        
        JLabel lbSearch = new JLabel("제목");
        lbSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        lbSearch.setBounds(50, 100, 80, 30);
        contentPane.add(lbSearch);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        txtSearch.setBounds(120, 100, 300, 30);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("굴림", Font.PLAIN, 20));
        btnSearch.setBounds(450, 100, 100, 30);
        contentPane.add(btnSearch);
        
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
    			row = table.getSelectedRow();
    			isbn = (String) table.getValueAt(row, 0);
    			title = (String) table.getValueAt(row, 1);
    			writer = (String) table.getValueAt(row, 2);
    			category = (String) table.getValueAt(row, 3);
    			bookcnt = (int) table.getValueAt(row, 4);
			}
        });
        
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DefaultTableModel model1 = new DefaultTableModel(header, 0);
        		ArrayList<BookDto> searchList = bookdao.select(txtSearch.getText());
        	    for (BookDto s : searchList) {
        	        Object[] rowData = {
        	            s.getIsbn(),
        	            s.getTitle(),
        	            s.getWriter(),
        	            s.getCategory(),
        	            s.getBookcnt()
        	        };
        	        model1.addRow(rowData);
        	    }
        	    table.setModel(model1);
        		table.getColumnModel().getColumn(0).setPreferredWidth(100);;
        		table.getColumnModel().getColumn(1).setPreferredWidth(250);
        		table.getColumnModel().getColumn(2).setPreferredWidth(60);
        		table.getColumnModel().getColumn(3).setPreferredWidth(50); 
        		table.getColumnModel().getColumn(4).setPreferredWidth(35);
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
    			loandto.setBookcnt(bookcnt);
    			loandao.insert(loandto);
    			bookdao.bookSub(isbn, bookcnt);
    			JOptionPane.showMessageDialog(null, "대출 성공!","도서 대출",JOptionPane.INFORMATION_MESSAGE);
    			DefaultTableModel model2 = new DefaultTableModel(header, 0);
    			ArrayList<BookDto> searchList = bookdao.select(txtSearch.getText());
    			for (BookDto s : searchList) {
    				Object[] rowData = {
    						s.getIsbn(),
    						s.getTitle(),
    						s.getWriter(),
    						s.getCategory(),
    						s.getBookcnt()
    				};
    				model2.addRow(rowData);
    			}
    			table.setModel(model2);
    			table.getColumnModel().getColumn(0).setPreferredWidth(100);
    			table.getColumnModel().getColumn(1).setPreferredWidth(250);
    			table.getColumnModel().getColumn(2).setPreferredWidth(60);
    			table.getColumnModel().getColumn(3).setPreferredWidth(50); 
    			table.getColumnModel().getColumn(4).setPreferredWidth(35);
			}
		});
	}
}
