package View;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Login_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField passwordPw;
	UserDao userdao = UserDao.getInstance();
	MainFrame mf = MainFrame.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_Admin frame = new Login_Admin();
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
	public Login_Admin() {
		setBounds(400, 300, 400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("관리자 로그인");
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
						if(userdao.isAuth(txtId.getText())) {
							JOptionPane.showMessageDialog(null, "로그인 성공!","로그인 성공",JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							mf.setVisible(false);
							AdminSelect as = AdminSelect.getInstance(txtId.getText());
							as.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "관리자 권한이 없습니다.","로그인 실패",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","로그인 실패",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "입력한 아이디가 없습니다.","로그인 실패",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
