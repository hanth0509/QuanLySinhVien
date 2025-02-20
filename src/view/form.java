package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import sv.StudentManagementForm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpasword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.YELLOW));
		contentPane.setBackground(new Color(206, 231, 255));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý Sinh Viên");
		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		JButton btnNewButton = new JButton("Đăng Nhập");
		JButton btnNewButton_1 = new JButton("Exit");
		JSeparator separator = new JSeparator();
		txtusername = new JTextField();
		txtusername.setBackground(new Color(255, 255, 255));
		txtpasword = new JPasswordField();
		txtpasword.setBackground(new Color(255, 255, 255));
		
		
		lblNewLabel.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(106, 181, 255));
		btnNewButton.setForeground(new Color(26, 26, 26));
		btnNewButton_1.setBackground(new Color(106, 181, 255));
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNewLabel.setBounds(136, 20, 180, 26);
		lblNewLabel_1.setBounds(25, 70, 122, 25);
		lblNewLabel_2.setBounds(25, 115, 93, 26);
		txtusername.setBounds(141, 70, 204, 27);
		txtpasword.setBounds(141, 115, 204, 27);
		btnNewButton.setBounds(196, 153, 108, 23);
		btnNewButton_1.setBounds(314, 153, 65, 23);
		
		txtusername.setColumns(10);
		
		contentPane.add(lblNewLabel);
		contentPane.add(separator);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(txtusername);
		contentPane.add(txtpasword);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username= txtusername.getText();
				String password= new String(txtpasword.getPassword());
				if(username.equals("admin") && password.equals("admin")) {
					try {
						StudentManagementForm frame = new StudentManagementForm();
						frame.setVisible(true);
						((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(new JFrame("Show message"), "Invalid username or password ");
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
