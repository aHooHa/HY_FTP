package hy_ftp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CFTP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	private String username;
	private String pwd;
	private String path;
	private int port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CFTP frame = new CFTP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CFTP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label_1 = new JLabel("主机名");

		textField1 = new JTextField();
		textField1.setColumns(10);

		JLabel label_2 = new JLabel("端口号");

		textField2 = new JTextField();
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setColumns(10);

		JLabel label_3 = new JLabel("用户");

		JLabel label_4 = new JLabel("密码");

		textField4 = new JTextField();
		textField4.setColumns(10);

		JLabel label = new JLabel("文件名");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton button = new JButton("文件选择");

		JButton button3 = new JButton("上    传");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JLabel lblNewLabel = new JLabel("文件描素");

		JButton button_2 = new JButton("连接");
		JTextArea textArea = new JTextArea();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = textField3.getText();
				pwd = textField4.getText();
				path = textField1.getText();
				port = Integer.parseInt(textField2.getText());

				if (username.equals("孙雅晖")) {
					if (pwd.equals("123456")) {
						ConUtil.getCon(path, port);
						textArea.append("连接成功");
					}else{
						textArea.append("密码有误，连接失败");
					}
				}else{
					textArea.append("不存在该用户，连接失败");
				}
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(48)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 218,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel).addComponent(
																textArea, GroupLayout.DEFAULT_SIZE, 220,
																Short.MAX_VALUE))
												.addGroup(
														gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_1).addComponent(label_3))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(textField3).addComponent(
																				textField1, GroupLayout.DEFAULT_SIZE,
																				126, Short.MAX_VALUE))
																.addGap(18)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_2).addComponent(label_4))))
								.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(188)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(
										gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 89,
																Short.MAX_VALUE)
														.addComponent(textField4, GroupLayout.DEFAULT_SIZE, 89,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(button_2))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(button)))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button3)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(63).addComponent(label))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_3).addComponent(label_4)
												.addComponent(textField4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_2))))
						.addGap(2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(10)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textArea,
												GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addComponent(button3))
						.addContainerGap(29, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
