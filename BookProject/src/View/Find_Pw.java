package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Find_Pw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	UserDao userdao = UserDao.getInstance();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Find_Pw frame = new Find_Pw();
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
	public Find_Pw() {
		setBounds(400, 250, 400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("PW 찾기");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(115, 20, 150, 40);
		contentPane.add(lbTitle);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("굴림", Font.PLAIN, 20));
		lbId.setBounds(10, 100, 100, 30);
		contentPane.add(lbId);
		
		JTextField txtId = new JTextField(); 
		txtId.setFont(new Font("굴림", Font.PLAIN, 20));
		txtId.setBounds(150, 100, 160, 30);
		contentPane.add(txtId);
		
		JLabel lbQuestionTitle = new JLabel("질문.");
		lbQuestionTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lbQuestionTitle.setBounds(10, 140, 300, 30);
		contentPane.add(lbQuestionTitle);
		
		JLabel lbQuestionContent = new JLabel("가장 재미있는 선생님의 성함은?");
		lbQuestionContent.setFont(new Font("굴림", Font.ITALIC, 20));
		lbQuestionContent.setBounds(10, 180, 300, 30);
		contentPane.add(lbQuestionContent);
		
		JLabel lbQuestioAnswer = new JLabel("답변.");
		lbQuestioAnswer.setFont(new Font("굴림", Font.PLAIN, 20));
		lbQuestioAnswer.setBounds(10, 220, 300, 30);
		contentPane.add(lbQuestioAnswer);
		
		JTextField txtQuestionAnswer = new JTextField();
		txtQuestionAnswer.setFont(new Font("굴림", Font.PLAIN, 20));
		txtQuestionAnswer.setBounds(10, 260, 300, 30);
		contentPane.add(txtQuestionAnswer);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
		btnClose.setBounds(95, 310, 100, 40);
		contentPane.add(btnClose);
		
		JButton btnFind = new JButton("찾기");
		btnFind.setFont(new Font("굴림", Font.PLAIN, 25));
		btnFind.setBounds(203, 310, 100, 40);
		contentPane.add(btnFind);
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userPw = userdao.findPW(txtId.getText(), txtQuestionAnswer.getText());
				if(userPw != null) {
					Reset_Pw rPw = new Reset_Pw(txtId.getText());
					setVisible(false);
					rPw.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 답변입니다.","비밀번호 찾기",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
	}
}
