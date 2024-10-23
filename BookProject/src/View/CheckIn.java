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
import DTO.LoanDto;
import DTO.UserDto;

public class CheckIn extends JFrame {

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
	UserDao userdao = UserDao.getInstance();
	BookDao bookdao = BookDao.getInstance();
	LoanDao loandao = LoanDao.getInstance();
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
	public CheckIn(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 300, 600, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lbHeader = new JLabel("도서 반납");
		lbHeader.setIcon(new ImageIcon(BookInsert.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		lbHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeader.setFont(new Font("굴림", Font.BOLD, 30));
		lbHeader.setBounds(150, 30, 300, 40);
		contentPane.add(lbHeader);
		
		String[] header = {"고유번호","제목","저자","분야","수량"};
		
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		ArrayList<LoanDto> loanlist = loandao.selectAll(id);
	    for (LoanDto l : loanlist) {
	        Object[] rowData = {
	            l.getIsbn(),
	            l.getTitle(),
	            l.getWriter(),
	            l.getCategory(),
	            l.getBookcnt()
	        };
	        dtm.addRow(rowData);
	    }
	    
		JTable table = new JTable();
		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 140, 500, 200);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(50); 
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
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
       
        JButton btnReturn = new JButton("반납");
        btnReturn.setFont(new Font("굴림", Font.PLAIN, 25));
        btnReturn.setBounds(450, 350, 100, 40);
        contentPane.add(btnReturn);
        
        JLabel lbSearch = new JLabel("검색어");
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
        		DefaultTableModel model = new DefaultTableModel(header, 0);
        		ArrayList<LoanDto> searchList = loandao.select(id, txtSearch.getText());
        	    for (LoanDto s : searchList) {
        	        Object[] rowData = {
        	            s.getIsbn(),
        	            s.getTitle(),
        	            s.getWriter(),
        	            s.getCategory(),
        	            s.getBookcnt()
        	        };
        	        model.addRow(rowData);
        	    }
        	    table.setModel(model);
        		table.getColumnModel().getColumn(0).setPreferredWidth(100);
        		table.getColumnModel().getColumn(1).setPreferredWidth(250);
        		table.getColumnModel().getColumn(2).setPreferredWidth(70);
        		table.getColumnModel().getColumn(3).setPreferredWidth(50); 
        		table.getColumnModel().getColumn(4).setPreferredWidth(25);
        	}
        });
        
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserSelect us = UserSelect.getInstance(id);
				us.setVisible(true);
			}
		});
        
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		loandao.delete(isbn, id);
				loandao.bookSub(isbn, id, bookcnt);
				bookdao.bookAdd(isbn, title, writer, category);
				JOptionPane.showMessageDialog(null, "반납 성공!","도서 반납",JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model1 = new DefaultTableModel(header, 0);
				ArrayList<LoanDto> loanlist = loandao.selectAll(id);
				for (LoanDto l : loanlist) {
					Object[] rowData = {
							l.getIsbn(),
							l.getTitle(),
							l.getWriter(),
							l.getCategory(),
							l.getBookcnt()
					};
					model1.addRow(rowData);
				}
				table.setModel(model1);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(250);
				table.getColumnModel().getColumn(2).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setPreferredWidth(50); 
				table.getColumnModel().getColumn(4).setPreferredWidth(25);
        	}
        });
	}
}
