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

import DAO.LoanDao;
import DAO.UserDao;
import DTO.LoanDto;
import DTO.UserDto;

public class CheckIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	UserDto userdto = new UserDto();
	UserDao userdao = UserDao.getInstance();
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
		setBounds(350, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String[] header = {"고유번호","제목","저자","분야"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		
		ArrayList<LoanDto> loanlist = loandao.selectAll(id);
	    for (LoanDto l : loanlist) {
	        Object[] rowData = {
	            l.getIsbn(),
	            l.getTitle(),
	            l.getWriter(),
	            l.getCategory(),
	            l.getId()
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
		isbnColumn.setPreferredWidth(100);
        titleColumn.setPreferredWidth(250);
        writerColumn.setPreferredWidth(100);
        categoryColumn.setPreferredWidth(70);
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
       
        JButton btnReturn = new JButton("반납");
        btnReturn.setFont(new Font("굴림", Font.PLAIN, 25));
        btnReturn.setBounds(440, 300, 100, 40);
        contentPane.add(btnReturn);
        
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
				UserSelect us = UserSelect.getInstance(id);
				us.setVisible(true);
			}
		});
		
	}
}
