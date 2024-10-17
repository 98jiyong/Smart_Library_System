package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class No_Pw extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public No_Pw(String id, String pwhint) {
		setBounds(450, 350, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbResult = new JLabel();
		lbResult.setText("PW가 없습니다.");
		lbResult.setFont(new Font("굴림",Font.PLAIN, 20));
		lbResult.setBounds(80, 60, 200, 30);
		contentPane.add(lbResult);
	}
}
