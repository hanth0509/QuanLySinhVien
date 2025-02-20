package sv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.studentDao;
import connect.database;
//import mang.hmm;
import model.student;

//import view.aboume;
import view.aboutme;
import view.tbd;
import view.tt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class StudentManagementForm extends JFrame {
	
	private JPanel contentPane;
	private JTextField masv;
	private JTextField hoten;
	private JTextField email;
	private JTextField dtb;
	private JTextField diachi;
	private JTable table;
	private DefaultTableModel tblModel;
	private JTextField txt_timkiem;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementForm frame = new StudentManagementForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentManagementForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentManagementForm.class.getResource("/image/application.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 221, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("  QUẢN LÝ SINH VIÊN");
		lblNewLabel.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/student-icon.png")));

		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(106, 181, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(206, 11, 300, 23);
		//contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 595, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(159, 105, 60, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ Tên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(159, 138, 60, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(159, 182, 60, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm Tb");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(411, 182, 60, 22);
		contentPane.add(lblNewLabel_4);
		
		masv = new JTextField();
		masv.setBounds(229, 106, 137, 22);
		contentPane.add(masv);
		masv.setColumns(10);
		
		hoten = new JTextField();
		hoten.setBounds(228, 140, 298, 20);
		contentPane.add(hoten);
		hoten.setColumns(10);
		
		email = new JTextField();
		email.setBounds(229, 184, 166, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		dtb = new JTextField();
		dtb.setBounds(481, 184, 81, 20);
		contentPane.add(dtb);
		dtb.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Giới Tính");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(159, 215, 60, 22);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton nam = new JRadioButton("Nam");
		nam.setBackground(new Color(255, 222, 189));
		nam.setFont(new Font("Tahoma", Font.BOLD, 11));
		nam.setBounds(278, 215, 60, 25);
		contentPane.add(nam);
		
		JRadioButton nu = new JRadioButton("Nữ");
		nu.setBackground(new Color(255, 223, 191));
		nu.setFont(new Font("Tahoma", Font.BOLD, 11));
		nu.setBounds(381, 215, 60, 25);
		contentPane.add(nu);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(159, 248, 60, 22);
		contentPane.add(lblNewLabel_6);
		
		diachi = new JTextField();
		diachi.setBounds(243, 250, 359, 20);
		contentPane.add(diachi);
		diachi.setColumns(10);
		
		
		JButton timkiem = new JButton("Tìm Kiếm");
		timkiem.setBackground(new Color(191, 223, 255));
		timkiem.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/tim_kiem_icon.png")));
		timkiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_timkiem.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Mã sv cần nhập để tìm kiếm!");
					return;
				}
				try {
					studentDao dao= new studentDao();
					student s = dao.find(txt_timkiem.getText());
					if(s!=null) {
						masv.setText(txt_timkiem.getText());
						hoten.setText(s.getHoten());
						email.setText(s.getEmail());
						dtb.setText(s.getDtb());
						nam.setSelected(s.getGioitinh()==1);
						nu.setSelected(s.getGioitinh()==0);
						diachi.setText(s.getDiachi());
					}else {
						JOptionPane.showMessageDialog(new JFrame(),"Sinh viên không tìm thấy");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		timkiem.setBounds(566, 58, 117, 22);
		contentPane.add(timkiem);
		
		JButton them = new JButton("Làm sạch");
		them.setBackground(new Color(191, 223, 255));
		them.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/clear.png")));
		them.setFont(new Font("Tahoma", Font.BOLD, 11));
		them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				masv.setText("");
				hoten.setText("");
				email.setText("");
				dtb.setText("");
				nam.setSelected(false);
				nu.setSelected(false);
				diachi.setText("");
				
			}
		});
		them.setBounds(10, 80, 117, 30);
		contentPane.add(them);
		
		JButton capnhat = new JButton("Cập Nhật");
		capnhat.setBackground(new Color(191, 223, 255));
		capnhat.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/cap_nhat_icon.png")));
		capnhat.setFont(new Font("Tahoma", Font.BOLD, 11));
		capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder sb= new StringBuilder();
				if(masv.getText().equals("")) {
					sb.append("Mã sinh viên không được để trống!");	
					masv.setBackground(Color.red);
				}else {
					masv.setBackground(Color.white);
				}
				
				if(masv.getText().length()==0) {
					JOptionPane.showMessageDialog(new JFrame("Show message"), "Not");
					return;
				}
				try {
					student s= new student();
					s.setMaSV(masv.getText());
					s.setHoten(hoten.getText());
					s.setEmail(email.getText());
					s.setDtb(dtb.getText());
					s.setGioitinh(nam.isSelected()?1:0);
					s.setDiachi(diachi.getText());
					studentDao dao= new studentDao();
					dao.update(s);
					JOptionPane.showMessageDialog(new JFrame(),"Sinh viên đã được cập nhật vào csdl");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Error: "+ex.getMessage());
					ex.printStackTrace();
				}
				load();
			
			}
		});
		capnhat.setBounds(10, 140, 117, 30);
		contentPane.add(capnhat);
		
		JButton luu = new JButton("Thêm");
		luu.setBackground(new Color(191, 223, 255));
		luu.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/them_icon.png")));
		luu.setFont(new Font("Tahoma", Font.BOLD, 11));
		luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StringBuilder sb= new StringBuilder();
				if(masv.getText().equals("")) {
					sb.append("Mã sinh viên không được để trống!");	
					masv.setBackground(Color.red);
				}else {
					masv.setBackground(Color.white);
				}
				
				if(masv.getText().length()==0) {
					JOptionPane.showMessageDialog(new JFrame("Show message"), "Not");
				}

				try {
					student s= new student();
					s.setMaSV(masv.getText());
					s.setHoten(hoten.getText());
					s.setEmail(email.getText());
					s.setDtb(dtb.getText());
					s.setGioitinh(nam.isSelected()?1:0);
					s.setDiachi(diachi.getText());
					studentDao dao= new studentDao();
					dao.insert(s);
				//	MS.addList(s);
					JOptionPane.showMessageDialog(new JFrame(),"Sinh viên mới đã được chèn vào csdl");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Error: "+ex.getMessage());
					ex.printStackTrace();
				}
				load();
//				System.out.println("luu");
//				load1();
			}
		});
		luu.setBounds(10, 110, 117, 30);
		contentPane.add(luu);
		
		JButton xoa = new JButton("Xóa");
		xoa.setBackground(new Color(191, 223, 255));
		xoa.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/xoa_icon.png")));
		xoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb= new StringBuilder();
				if(masv.getText().equals("")) {
					sb.append("Mã sinh viên không được để trống!");	
					masv.setBackground(Color.red);
				}else {
					masv.setBackground(Color.white);
				}
				
				if(masv.getText().length()==0) {
					JOptionPane.showMessageDialog(new JFrame("Show message"), "Not");
					return ;
				}
				JOptionPane.showMessageDialog(new JFrame(), "Bạn có muốn xóa sinh viên không");
				try {
					studentDao dao= new studentDao();
					dao.delete(masv.getText());
				//	String amasv= masv.getText();
				//.removeList(amasv);
					JOptionPane.showMessageDialog(new JFrame(),"Sinh vien đã được xóa khỏi csdl");
				}catch (Exception ex) {
					//JOptionPane.showMessageDialog( new JFrame(),"Error: "+ex.getMessage());
					JOptionPane.showMessageDialog(new JFrame(), "Error: "+ex.getMessage());
					ex.printStackTrace();
				}
				masv.setText("");
				hoten.setText("");
				email.setText("");
				dtb.setText("");
				nam.setSelected(false);
				nu.setSelected(false);
				diachi.setText("");
				load();
			    //load1();
			}
			}
		
		);
		
		
		xoa.setBounds(10, 170, 117, 30);
		contentPane.add(xoa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 305, 693, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton_5 = new JButton("<<");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_5.setBackground(new Color(226, 197, 197));
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=0;String gt;
				masv.setText(table.getValueAt(row, 0).toString());
				hoten.setText(table.getValueAt(row, 1).toString());
				email.setText(table.getValueAt(row, 2).toString());
				gt=table.getValueAt(row, 4).toString();
				if(gt.equalsIgnoreCase("1")) {
					nam.setSelected(true);
					nu.setSelected(false);
				}else {
					nam.setSelected(false);
					nu.setSelected(true);
				}
				dtb.setText(table.getValueAt(row, 3).toString());
				diachi.setText(table.getValueAt(row, 5).toString());
			}
		});
		btnNewButton_5.setBounds(10, 318, 45, 23);
		contentPane.add(btnNewButton_5);
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row= table.getSelectedRow();
				String gt;
				if(row>=0) {
					masv.setText(table.getValueAt(row, 0).toString());
					hoten.setText(table.getValueAt(row, 1).toString());
					email.setText(table.getValueAt(row, 2).toString());
					gt=table.getValueAt(row, 4).toString();
					if(gt.equalsIgnoreCase("1")) {
						nam.setSelected(true);
						nu.setSelected(false);
					}else {
						nam.setSelected(false);
						nu.setSelected(true);
					}
					dtb.setText(table.getValueAt(row, 3).toString());
					diachi.setText(table.getValueAt(row, 5).toString());
					
				}
			}
			
		});
		table.setBounds(17, 318, 578, 172);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 352, 670, 166);
		contentPane.add(scrollPane);
        
		tblModel = new DefaultTableModel();
		tblModel.setColumnIdentifiers(new String[] {"Mã SV","Họ Tên","Email","DTB","Giới Tính","Địa Chỉ"});
		table.setModel(tblModel);
		
		JScrollPane scrollPane_1 = new JScrollPane(lblNewLabel);
		scrollPane_1.setBounds(0,0,700,47);
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel_7 = new JLabel("Danh Sách");
		lblNewLabel_7.setForeground(new Color(128, 0, 64));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(65, 319, 81, 22);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("About me");
		btnNewButton.setIcon(new ImageIcon(StudentManagementForm.class.getResource("/image/aboutme.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   aboutme a= new aboutme();
			   a.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(191, 223, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 260, 117, 30);
		contentPane.add(btnNewButton);
		
		txt_timkiem = new JTextField();
		txt_timkiem.setBounds(450, 59, 116, 20);
		contentPane.add(txt_timkiem);
		txt_timkiem.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nhập mã sv cần tìm");
		lblNewLabel_8.setBounds(330, 62, 111, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Các chức năng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 58, 117, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThngK.setBackground(new Color(191, 223, 255));
		btnThngK.setBounds(10, 200, 117, 30);
		contentPane.add(btnThngK);
		
		JButton btnTbim = new JButton("TB Điểm");
		btnTbim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbd fre= new tbd();
				fre.setVisible(true);
			}
		});
		btnTbim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTbim.setBackground(new Color(191, 223, 255));
		btnTbim.setBounds(10, 230, 117, 30);
		contentPane.add(btnTbim);
		
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 tt a= new tt();
				// tt.setLocationRelativeTo(null);
				 a.setVisible(true);
			}
		});
		load();
		//load1();
	
	}
	private void load() {
		try {
		//	k=0;
			Connection con= database.openConnection();
			String sql="select*from SinhVien";
			PreparedStatement pstmt= con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			tblModel.setRowCount(0);
			while(rs.next()) {
				String[] row = new String[] {
						rs.getString("masv"),rs.getString("hoten"),rs.getString("email"),rs.getString("dtb"),rs.getString("gioitinh"),rs.getString("diachi")
				};
				tblModel.addRow(row);
			//	k++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
			e.printStackTrace();
		}
	}	
//	private void load1() {
//		String amasv,ahoten,aemail,adtb,agt,adiachi;
//		int gt;
//        try {
//			int dem=0;
//			while(dem<k) {
//				amasv=table.getValueAt(dem, 0).toString();
//				ahoten=table.getValueAt(dem, 1).toString();
//				aemail=table.getValueAt(dem, 2).toString();
//				agt=table.getValueAt(dem, 4).toString();
//				if(agt.equalsIgnoreCase("1")) {
//					gt=1;
//				}else {
//					gt=0;
//				}
//				adtb=table.getValueAt(dem, 3).toString();
//				adiachi=table.getValueAt(dem, 5).toString();
//				dem++;
//				student o = new student(amasv,ahoten,aemail,adtb,adiachi,gt);
//				MS.addList(o);
//				tblModel.fireTableDataChanged();
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
//			e.printStackTrace();
//		}
//        System.out.println("--------");
//		MS.display();
//		System.out.println("--------");
//	}
}


