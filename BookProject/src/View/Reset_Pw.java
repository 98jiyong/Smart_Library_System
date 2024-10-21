package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Reset_Pw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField ResetPw;
	private JPasswordField ResetPwCheck;
	UserDao userdao = UserDao.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Reset_Pw frame = new Reset_Pw();
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
	public Reset_Pw(String id) {
		setBounds(400, 300, 400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("비밀번호 변경");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lbTitle.setBounds(90, 20, 220, 40);
		contentPane.add(lbTitle);
		
		JLabel lbResetPw = new JLabel("새 비밀번호");
		lbResetPw.setFont(new Font("굴림", Font.PLAIN, 20));
		lbResetPw.setBounds(20, 80, 150, 30);
		contentPane.add(lbResetPw);
		
		ResetPw = new JPasswordField();
		ResetPw.setFont(new Font("굴림", Font.PLAIN, 20));
		ResetPw.setBounds(170, 80, 150, 30);
		contentPane.add(ResetPw);
		
		JLabel lbResetPwCheck = new JLabel("비밀번호 확인");
		lbResetPwCheck.setFont(new Font("굴림", Font.PLAIN, 20));
		lbResetPwCheck.setBounds(20, 130, 150, 30);
		contentPane.add(lbResetPwCheck);
		
		ResetPwCheck = new JPasswordField();
		ResetPwCheck.setFont(new Font("굴림", Font.PLAIN, 20));
		ResetPwCheck.setBounds(170, 130, 150, 30);
		contentPane.add(ResetPwCheck);
		
		JLabel lbPwCheck = new JLabel();
		lbPwCheck.setBackground(new Color(240, 240, 240));
		lbPwCheck.setFont(new Font("굴림", Font.PLAIN, 20));
		lbPwCheck.setBounds(20, 170, 300, 30);
		contentPane.add(lbPwCheck);
		
		JButton btnReset = new JButton("변경");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(272, 211, 100, 40);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(163, 211, 100, 40);
		contentPane.add(btnClose);
		
		ResetPwCheck.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(new String(ResetPwCheck.getPassword()).equals(new String (ResetPw.getPassword()))) {
					lbPwCheck.setText("비밀번호가 일치합니다.");
					lbPwCheck.setForeground(Color.blue);
				}else {
					lbPwCheck.setText("비밀번호가 일치하지 않습니다.");
					lbPwCheck.setForeground(Color.red);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(ResetPwCheck.getPassword()).equals(new String (ResetPw.getPassword()))) {
					userdao.updatePW(new String (ResetPwCheck.getPassword()), id);
					setVisible(false);
					JOptionPane.showMessageDialog(null, "변경 성공!","비밀번호 변경",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "변경할 비밀번호가 일치하지 않습니다.","비밀번호 변경",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
}
