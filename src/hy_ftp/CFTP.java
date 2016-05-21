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
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
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
	File file;
	String parhfile;
	String name;
	double len;

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

		JLabel label_1 = new JLabel("地址");

		textField1 = new JTextField();
		textField1.setColumns(10);

		JLabel label_2 = new JLabel("端口");

		textField2 = new JTextField();
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setColumns(10);

		JLabel label_3 = new JLabel("用户");

		JLabel label_4 = new JLabel("密码");

		textField4 = new JTextField();
		textField4.setColumns(10);

		JLabel label = new JLabel("文件");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton button = new JButton("选择文件");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showDialog(CFTP.this, "true");
				 fileChooser.setFileSelectionMode(2);

				file = fileChooser.getSelectedFile();
				name = file.getName();
				textField_1.setText(name);
				parhfile=file.getAbsolutePath();
				File ffff =new File(parhfile);
				len =ffff.length()/(1024.0);
			}
		});

		

		JLabel lblNewLabel = new JLabel("文件描述");

		JButton button_2 = new JButton("连接");
		JButton button3 = new JButton("上传");
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = textField3.getText();
				pwd = textField4.getText();
				
				if (username.equals("q")) {
					if (pwd.equals("1")) {
						
						textArea.setText("");
						textArea.append("连接成功"+"\t\n");
						
						button3.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent arg0) {
								path = textField1.getText();
								port = Integer.parseInt(textField2.getText());
								long start =System.currentTimeMillis();
								ConUtil.getCon(path, port,parhfile);
								long end =System.currentTimeMillis();
								textArea.append("文件名:"+name+"\t\n");
								if(len>1024){
									textArea.append("文件大小:"+Math.ceil(len)/(1024)+"M"+"\t\n");	
								}else{
								textArea.append("文件大小"+Math.ceil(len)+"kb"+"\t\n");}
								textArea.append("上传成功"+"\t\n");
								
								double time = end-start;
								if(time>6000){
									textArea.append("时间"+time/(6000)+"分钟"+":"+time%(6000)+"秒"+"\t\n");
								}else{
								textArea.append("时间"+time/(1000)+"秒"+"\t\n");}
								textArea.append("~~~~~~~~~~~~"+"\t\n");
								
							}
						});
					}else{
						textArea.append("密码有误");
					}
				}else{
					textArea.append("不存在该用户");
				}
			}

		});

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_1))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField3)
										.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4)
										.addComponent(label_2)))
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addComponent(textField4, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_2))
								.addComponent(button)
								.addComponent(button3)))
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2)
						.addComponent(label_4)
						.addComponent(label_3)
						.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(button3)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(111)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
