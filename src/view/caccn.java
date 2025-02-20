package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class caccn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					caccn frame = new caccn();
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
	public caccn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcn = new JLabel("Các chức năng");
		lblcn.setBounds(147, 11, 142, 22);
		lblcn.setForeground(new Color(255, 0, 0));
		lblcn.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblcn);
		
		JLabel lblNewLabel = new JLabel("-Với bốn chức năng đầu bạn cần chú ý các phiếu điền bên phải");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(37, 73, 365, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("- Với hai chức năng tiếp theo nó sẽ cung cấp thông tin cần thiết cho bạn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 114, 416, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-Với chức năng cuối bạn có thể tim hiểu thêm QLSV ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(37, 153, 365, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mọi thắc mắc vui lòng liên hệ admin");
		lblNewLabel_3.setForeground(new Color(0, 128, 255));
		lblNewLabel_3.setBounds(118, 202, 233, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnexit = new JButton("exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JFrame) SwingUtilities.getWindowAncestor(btnexit)).dispose();
			}
		});
		btnexit.setBackground(new Color(255, 219, 183));
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnexit.setBounds(313, 227, 89, 23);
		contentPane.add(btnexit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-12, 44, 458, 2);
		contentPane.add(separator);
	}

}
