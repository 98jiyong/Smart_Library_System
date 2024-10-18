package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Notice_Failed_Pw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Notice_Failed_Pw ntcscs = null; 

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Alarm_Success frame = new Alarm_Success();
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
	private Notice_Failed_Pw() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 350, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("비밀번호가 틀렸습니다.");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 60, 200, 30);
		contentPane.add(lblNewLabel);
	}
	
	public static Notice_Failed_Pw getInstance() {
		if(ntcscs == null) {
			ntcscs = new Notice_Failed_Pw();
		}
		return ntcscs;
	}

}
