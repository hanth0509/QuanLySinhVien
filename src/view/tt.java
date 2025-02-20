package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Dao.studentDao;

public class tt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt frame = new tt();
					frame.setLocationRelativeTo(null);
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
	public tt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 193);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel tieude = new JLabel("Thông kê số lượng sinh viên theo giới tính");
		tieude.setBounds(31, 13, 299, 17);
		tieude.setForeground(new Color(0, 128, 255));
		tieude.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(tieude);
		
		JLabel lblNam = new JLabel("Nam:");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNam.setBounds(73, 68, 57, 14);
		contentPane.add(lblNam);
		studentDao dao= new studentDao();
		JLabel nam;
		try {
			nam = new JLabel(dao.sl(1));
			nam.setForeground(new Color(255, 128, 64));
			nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
			nam.setBounds(161, 68, 49, 14);
			contentPane.add(nam);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel nu;
		try {
			nu = new JLabel(dao.sl(0));
			nu.setBackground(new Color(255, 255, 255));
			nu.setForeground(new Color(255, 128, 64));
			nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
			nu.setBounds(161, 106, 49, 14);
			contentPane.add(nu);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNu = new JLabel("Nữ:");
		lblNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNu.setBounds(73, 106, 49, 14);
		contentPane.add(lblNu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 41, 398, 2);
		contentPane.add(separator);
		
		JButton exit = new JButton("exit");
		exit.setBackground(new Color(255, 227, 200));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JFrame) SwingUtilities.getWindowAncestor(exit)).dispose();
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		exit.setBounds(228, 122, 89, 23);
		contentPane.add(exit);
	}

}
