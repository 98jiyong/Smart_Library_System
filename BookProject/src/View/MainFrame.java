package View;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=80,349
	 */

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyFrame frame = new MyFrame();
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
public MainFrame() {
		setBounds(300, 250, 600, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("도서관리 프로그램\r\n");
		lblNewLabel.setBounds(85, 30, 430, 80);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 40));
		getContentPane().add(lblNewLabel);
		
		JButton btnUser = new JButton("사용자");
		btnUser.setFont(new Font("굴림", Font.PLAIN, 30));
		btnUser.setBounds(120, 120, 150, 120);
		getContentPane().add(btnUser);
		
		
		JButton btnAdmin = new JButton("관리자");
		btnAdmin.setFont(new Font("굴림", Font.PLAIN, 30));
		btnAdmin.setBounds(330, 120, 150, 120);
		getContentPane().add(btnAdmin);
		
		JButton btnSignup = new JButton("회원가입");
		btnSignup.setFont(new Font("굴림", Font.PLAIN, 17));
		btnSignup.setBounds(120, 270, 100, 40);
		getContentPane().add(btnSignup);
		
		JButton btnFindId = new JButton("ID 찾기");
		btnFindId.setFont(new Font("굴림", Font.PLAIN, 17));
		btnFindId.setBounds(250, 270, 100, 40);
		getContentPane().add(btnFindId);
		
		JButton btnFindPw = new JButton("PW 찾기");
		btnFindPw.setFont(new Font("굴림", Font.PLAIN, 17));
		btnFindPw.setBounds(380, 270, 100, 40);
		getContentPane().add(btnFindPw);
		
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_User lgUser = new Login_User();
				lgUser.setVisible(true);
			}
		});
		
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Admin lgAdmin = new Login_Admin();
				lgAdmin.setVisible(true);
			}
		});
		

		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp s = new SignUp();
				s.setVisible(true);
			}
		});
		
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find_Id fId = new Find_Id();
				fId.setVisible(true);
			}
		});
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find_Pw fPw = new Find_Pw();
				fPw.setVisible(true);
			}
		});
	}
}
