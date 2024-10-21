package View;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Login_User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField passwordPw;
	UserDao userdao = UserDao.getInstance();
	MainFrame mf = MainFrame.getInstance();
	public static Login_User lgUser = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_User frame = new Login_User();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public static Login_User getInstance() {
		if(lgUser == null) {
			lgUser = new Login_User();
		}
		return lgUser;
	}
	/**
	 * Create the frame.
	 */
	private Login_User() {
		setBounds(400, 300, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("사용자 로그인");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lbTitle.setBounds(90, 30, 220, 30);
		contentPane.add(lbTitle);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("굴림", Font.PLAIN, 20));
		lbId.setBounds(90, 90, 30, 30);
		contentPane.add(lbId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 20));
		txtId.setBounds(140, 90, 150, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lbPw = new JLabel("PW");
		lbPw.setFont(new Font("굴림", Font.PLAIN, 20));
		lbPw.setBounds(90, 140, 30, 30);
		contentPane.add(lbPw);
		
		passwordPw = new JPasswordField();
		passwordPw.setFont(new Font("굴림", Font.PLAIN, 20));
		passwordPw.setBounds(140, 140, 150, 30);
		contentPane.add(passwordPw);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.BOLD, 30));
		btnLogin.setBounds(90, 200, 200, 40);
		contentPane.add(btnLogin);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userdao.isinId(txtId.getText())) {
					String userPw = userdao.findPW(txtId.getText());
					if(new String(passwordPw.getPassword()).equals(userPw)) {
						setVisible(false);
						mf.setVisible(false);
						Notice_Success ntcscs = Notice_Success.getInstance();
						UserSelectFrame us = new UserSelectFrame(txtId.getText());
						us.setVisible(true);
						ntcscs.setVisible(true);
					}else {
						Notice_Failed_Pw ntcFailPw = Notice_Failed_Pw.getInstance();
						ntcFailPw.setVisible(true);
					}
				}else {
					Notice_Failed_Id ntcFailId = Notice_Failed_Id.getInstance();
					ntcFailId.setVisible(true);
				}
			}
		});
	}
}
