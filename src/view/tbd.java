package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.studentDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tbd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tbd frame = new tbd();
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
	public tbd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Điểm trung bình ");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(101, 0, 171, 32);
		contentPane.add(lblNewLabel);
		studentDao dao= new studentDao();
		JLabel lbltbd;
		try {
			lbltbd = new JLabel(dao.tbd());
			lbltbd.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbltbd.setBounds(210, 53, 49, 14);
			contentPane.add(lbltbd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			JLabel all = new JLabel("Tất cả học sinh:");
			all.setFont(new Font("Tahoma", Font.BOLD, 13));
			all.setBounds(51, 53, 106, 14);
			contentPane.add(all);
			
			JLabel lblnam = new JLabel("Học sinh nam:");
			lblnam.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblnam.setBounds(51, 89, 106, 14);
			contentPane.add(lblnam);
			
			JLabel lblNu = new JLabel("Học sinh nữ:");
			lblNu.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNu.setBounds(51, 124, 106, 14);
			contentPane.add(lblNu);
			
			JLabel lblNuu;
			try {
				lblNuu = new JLabel(dao.tbdnu());
				lblNuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNuu.setBounds(210, 124, 49, 14);
				contentPane.add(lblNuu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JLabel lblNamm;
			try {
				lblNamm = new JLabel(dao.tbdnam());
				lblNamm.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNamm.setBounds(210, 89, 49, 14);
				contentPane.add(lblNamm);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JButton btnexit = new JButton("exit");
			btnexit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((JFrame) SwingUtilities.getWindowAncestor(btnexit)).dispose();
				}
			});
			btnexit.setBackground(new Color(255, 226, 198));
			btnexit.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnexit.setBounds(210, 163, 89, 23);
			contentPane.add(btnexit);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 33, 332, 2);
			contentPane.add(separator);
		
		
	}

}
