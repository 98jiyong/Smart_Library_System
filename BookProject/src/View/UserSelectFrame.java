package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserSelectFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserSelectFrame frame = new UserSelectFrame();
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
	public UserSelectFrame(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoan = new JButton("대출");
		btnLoan.setFont(new Font("굴림", Font.BOLD, 30));
		btnLoan.setBounds(50, 70, 120, 100);
		contentPane.add(btnLoan);
		
		JButton btnReturn = new JButton("반납");
		btnReturn.setFont(new Font("굴림", Font.BOLD, 30));
		btnReturn.setBounds(220, 70, 120, 100);
		contentPane.add(btnReturn);
		
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan l = new Loan(id);
				l.setVisible(true);
				setVisible(false);
			}
		});
		
	}
}
