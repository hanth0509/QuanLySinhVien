package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sv.StudentManagementForm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class aboutme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    aboutme frame = new aboutme();
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
	public aboutme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 231);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đây là một ứng dụng giúp quản lý sinh viên");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(65, 80, 294, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý sinh viên");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(137, 11, 185, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hỗ trợ trong việc quản lý và được lưu trữ trong cơ sở dữ liệu");
		lblNewLabel_2.setBounds(61, 114, 365, 23);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 436, 3);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();
//					StudentManagementForm frame = new StudentManagementForm();
//					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
			}

		});
		
		btnNewButton.setBounds(337, 148, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
