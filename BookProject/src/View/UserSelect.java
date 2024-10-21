package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserSelect extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static UserSelect us = null;
	MainFrame mf = MainFrame.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserSelect frame = UserSelect.getInstance(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static UserSelect getInstance(String id) {
		if(us == null) {
			us = new UserSelect(id);
		}
		return us;
	}
	
	/**
	 * Create the frame.
	 */

	private UserSelect(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoan = new JButton("대출");
		btnLoan.setFont(new Font("굴림", Font.BOLD, 30));
		btnLoan.setBounds(50, 75, 120, 100);
		contentPane.add(btnLoan);
		
		JButton btnReturn = new JButton("반납");
		btnReturn.setFont(new Font("굴림", Font.BOLD, 30));
		btnReturn.setBounds(220, 75, 120, 100);
		contentPane.add(btnReturn);
		
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut chOut = new CheckOut(id);
				chOut.setVisible(true);
				setVisible(false);
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckIn chIn = new CheckIn(id);
				chIn.setVisible(true);
				setVisible(false);
			}
		});
		
		
		
	}
	
}
