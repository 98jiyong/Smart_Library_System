package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDao;

public class Result_Id extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String foundId = null;
	UserDao userdao = UserDao.getInstance();
	
	public Result_Id(String name, String tel) {
		setBounds(450, 350, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		foundId = userdao.findID(name, tel);
		JLabel lbResult = new JLabel();
		if(foundId != null) {
			lbResult.setText("ID :  " + foundId);
		}else {
			lbResult.setText("ID가 없습니다.");
		}
		lbResult.setFont(new Font("굴림",Font.PLAIN, 20));
		lbResult.setBounds(80, 60, 200, 30);
		contentPane.add(lbResult);
	}
}
