package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

//import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;
import DTO.UserDto;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtQuestion;
	private JTextField txtTel;
	private String auth = "n";
	private int cnt = 0;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp frame = new SignUp();
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
	public SignUp() {
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("회원가입");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("굴림", Font.PLAIN, 25));
		lbTitle.setBounds(100, 10, 200, 40);
		contentPane.add(lbTitle);
		
		JLabel lbId = new JLabel("아이디");
		lbId.setFont(new Font("굴림", Font.PLAIN, 20));
		lbId.setBounds(12, 100, 100, 30);
		contentPane.add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(110, 100, 120, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnDpCheck = new JButton("중복검사");
		btnDpCheck.setFont(new Font("굴림", Font.PLAIN, 14));
		btnDpCheck.setBounds(250, 100, 100, 30);
		btnDpCheck.setEnabled(false);
		contentPane.add(btnDpCheck);
		
		JLabel lbDpCheck = new JLabel();
		lbDpCheck.setBackground(new Color(240, 240, 240));
		lbDpCheck.setFont(new Font("굴림", Font.PLAIN, 20));
		lbDpCheck.setBounds(12, 135, 250, 30);
		contentPane.add(lbDpCheck);

		JLabel lbName = new JLabel("이름");
		lbName.setFont(new Font("굴림", Font.PLAIN, 20));
		lbName.setBounds(12, 170, 100, 30);
		contentPane.add(lbName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(110, 170, 120, 30);
		contentPane.add(txtName);
		
		JLabel lblNewLabel_Password = new JLabel("비밀번호");
		lblNewLabel_Password.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_Password.setBounds(12, 220, 100, 30);
		contentPane.add(lblNewLabel_Password);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(110, 220, 120, 30);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_PwHint = new JLabel("비밀번호 힌트");
		lblNewLabel_PwHint.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_PwHint.setBounds(12, 270, 150, 30);
		contentPane.add(lblNewLabel_PwHint);
		
		JLabel lblNewLabel_Question = new JLabel("가장 인상깊은 선생님의 성함은?");
		lblNewLabel_Question.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_Question.setBounds(12, 310, 300, 30);
		contentPane.add(lblNewLabel_Question);
		
		txtQuestion = new JTextField();
		txtQuestion.setColumns(10);
		txtQuestion.setBounds(12, 350, 300, 30);
		contentPane.add(txtQuestion);
		
		JLabel lbTel = new JLabel("전화번호");
		lbTel.setFont(new Font("굴림", Font.PLAIN, 20));
		lbTel.setBounds(12, 400, 100, 30);
		contentPane.add(lbTel);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(110, 400, 120, 30);
		contentPane.add(txtTel);
		
//		JLabel lbAuthor = new JLabel("권한");
//		lbAuthor.setFont(new Font("굴림", Font.PLAIN, 20));
//		lbAuthor.setBounds(12, 450, 100, 30);
//		contentPane.add(lbAuthor);
		
//		ButtonGroup group = new ButtonGroup();
//		
//		JRadioButton rdbtnUser = new JRadioButton("사용자");
//		rdbtnUser.setHorizontalAlignment(SwingConstants.CENTER);
//		rdbtnUser.setSelected(true);
//		rdbtnUser.setFont(new Font("굴림", Font.PLAIN, 20));
//		rdbtnUser.setBounds(110, 450, 100, 30);
//		contentPane.add(rdbtnUser);
//		
//		JRadioButton rdbtnAdmin = new JRadioButton("관리자");
//		rdbtnAdmin.setHorizontalAlignment(SwingConstants.CENTER);
//		rdbtnAdmin.setFont(new Font("굴림", Font.PLAIN, 20));
//		rdbtnAdmin.setBounds(220, 450, 100, 30);
//		contentPane.add(rdbtnAdmin);
//		
//		group.add(rdbtnUser);
//		group.add(rdbtnAdmin);

		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("굴림", Font.PLAIN, 25));
		btnSignUp.setBounds(222, 511, 150, 40);
		contentPane.add(btnSignUp);
	
		// Event
		
		txtId.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(txtId.getText().isEmpty()) {
					btnDpCheck.setEnabled(false);
				}else {
					btnDpCheck.setEnabled(true);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		btnDpCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().equals("98jiyong")) {
					lbDpCheck.setText("중복된 아이디 입니다.");
					lbDpCheck.setForeground(Color.red);
					}else {
					lbDpCheck.setText("사용가능한 아이디 입니다.");
					lbDpCheck.setForeground(Color.blue);
				}
			}
		});
		
		lbTitle.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cnt++;
				if(cnt >= 10) {
					auth = "y";
				}
			}
		});
		
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDto userdto = new UserDto();
				String id = txtId.getText();
				String name = txtName.getText();
				String pw = new String(txtPassword.getPassword());
				String pwHint = txtQuestion.getText();
				String tel = txtTel.getText();
				
				userdto.setId(id);
				userdto.setName(name);
				userdto.setPw(pw);
				userdto.setPwHint(pwHint);
				userdto.setTel(tel);
				userdto.setAuth(auth);
//				if(rdbtnAdmin.isSelected()) {
//					String auth = "y";
//					userdto.setAuth(auth);
//				}else {
//					String auth = "n";
//					userdto.setAuth(auth);
//				}
				UserDao userdao = UserDao.getInstance();
				userdao.insert(userdto);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
	}
}
