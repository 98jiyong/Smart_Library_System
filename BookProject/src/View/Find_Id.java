package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Find_Id extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Find_Id frame = new Find_Id();
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
	public Find_Id() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("ID 찾기");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(125, 20, 150, 40);
		contentPane.add(lbTitle);
		
		JLabel lbName = new JLabel("이름");
		lbName.setFont(new Font("굴림", Font.PLAIN, 20));
		lbName.setBounds(70, 90, 100, 30);
		contentPane.add(lbName);
		
		JTextField txtName = new JTextField(); 
		txtName.setFont(new Font("굴림", Font.PLAIN, 20));
		txtName.setBounds(180, 90, 150, 30);
		contentPane.add(txtName);
		
		JLabel lblTel = new JLabel("전화번호");
		lblTel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblTel.setBounds(70, 140, 100, 30);
		contentPane.add(lblTel);
		
		JTextField txtTel = new JTextField(); 
		txtTel.setFont(new Font("굴림", Font.PLAIN, 20));
		txtTel.setBounds(180, 140, 150, 30);
		contentPane.add(txtTel);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 25));
		btnClose.setBounds(95, 210, 100, 40);
		contentPane.add(btnClose);
		
		JButton btnFind = new JButton("찾기");
		btnFind.setFont(new Font("굴림", Font.PLAIN, 25));
		btnFind.setBounds(203, 210, 100, 40);
		contentPane.add(btnFind);
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Result_Id rId = new Result_Id(txtName.getText(), txtTel.getText());
				setVisible(false);
				rId.setVisible(true);
			}
		});
	}
}
