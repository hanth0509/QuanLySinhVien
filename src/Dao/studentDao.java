package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import connect.database;
//import dsach.ds;
import model.student;

public class studentDao {
public boolean insert(student s) throws Exception {
	String sql ="insert into SinhVien(masv,hoten,email,dtb,gioitinh,diachi) values(?,?,?,?,?,?)";
	try(
		Connection con= database.openConnection();
		PreparedStatement pstmt= con.prepareStatement(sql);
	){
		pstmt.setString(1,s.getMaSV());
		//list.add(s.getMaSV());
		//add(s.getMaSV());
		pstmt.setString(2,s.getHoten());
		pstmt.setString(3,s.getEmail());
		pstmt.setString(4,s.getDtb());
		pstmt.setInt(5,s.getGioitinh());
		pstmt.setString(6,s.getDiachi());
		return pstmt.executeUpdate()>0;
	}
	
}
public String sl(int gt) throws Exception{
	 String sql = "SELECT COUNT(GioiTinh) AS count FROM SinhVien WHERE GioiTinh = ? GROUP BY GioiTinh;";
	try(
			Connection con= database.openConnection();
			PreparedStatement pstmt= con.prepareStatement(sql);
		){
		pstmt.setInt(1, gt);
        ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
            return rs.getString("count");
        } else {
            return null; // hoặc giá trị mặc định nếu không có bản ghi nào được trả về
        }
	}
	
}
public String tbd() throws Exception{
	String sql="SELECT ROUND(AVG(CAST(DTB AS FLOAT)),2) AS average_score FROM SinhVien;";
	try(
			Connection con= database.openConnection();
			PreparedStatement pstmt= con.prepareStatement(sql);
		){
		 ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
	            return rs.getString("average_score");
	        } else {
	            return null; // hoặc giá trị mặc định nếu không có bản ghi nào được trả về
	        }
	}
}
public String tbdnu() throws Exception{
	String sql="SELECT ROUND(AVG(CAST(DTB AS FLOAT)),2) AS nu_score FROM SinhVien WHERE GioiTinh =0";
	try(
			Connection con= database.openConnection();
			PreparedStatement pstmt= con.prepareStatement(sql);
		){
		 ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
	            return rs.getString("nu_score");
	        } else {
	            return null; // hoặc giá trị mặc định nếu không có bản ghi nào được trả về
	        }
	}
}
public String tbdnam() throws Exception{
	String sql="SELECT ROUND(AVG(CAST(DTB AS FLOAT)),2) AS nam_score FROM SinhVien WHERE GioiTinh =1";
	try(
			Connection con= database.openConnection();
			PreparedStatement pstmt= con.prepareStatement(sql);
		){
		 ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
	            return rs.getString("nam_score");
	        } else {
	            return null; // hoặc giá trị mặc định nếu không có bản ghi nào được trả về
	        }
	}
}

public student find(String maSV) throws Exception {
	String sql ="select* from SinhVien where masv=?";
	try(
		Connection con= database.openConnection();
		PreparedStatement pstmt= con.prepareStatement(sql);
	){
		pstmt.setString(1,maSV);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()){
			student s= new student();
			s.setMaSV(rs.getString("maSV"));
			s.setHoten(rs.getString("hoten"));
			s.setEmail(rs.getString("email"));
			s.setDtb(rs.getString("dtb"));
			s.setGioitinh(rs.getInt("gioitinh"));
			s.setDiachi(rs.getString("diachi"));
			return s;
		}
		return null;
	}
	
}
public boolean update(student s) throws Exception {
	String sql ="update SinhVien set hoten=?,email=?,dtb=?,gioitinh=?,diachi=?"
			+ " where masv = ?";
	try(
		Connection con= database.openConnection();
		PreparedStatement pstmt= con.prepareStatement(sql);
	){
		pstmt.setString(6,s.getMaSV());
		pstmt.setString(1,s.getHoten());
		pstmt.setString(2,s.getEmail());
		pstmt.setString(3,s.getDtb());
		pstmt.setInt(4,s.getGioitinh());
		pstmt.setString(5,s.getDiachi());
		return pstmt.executeUpdate()>0;
	}
	
}
public boolean delete(String s) throws Exception {
	String sql ="delete from SinhVien where masv = ?";
	try(
		Connection con= database.openConnection();
		PreparedStatement pstmt= con.prepareStatement(sql);
	){ 
		//remove(s);
		pstmt.setString(1, s);
		return pstmt.executeUpdate()>0;
	}
	
}

}
