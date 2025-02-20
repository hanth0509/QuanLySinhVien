package model;

//import java.util.ArrayList;

public class student {
private String maSV,hoten,email,dtb,diachi;
//public ArrayList<String> list = new ArrayList<>();
private int gioitinh;


public student() {
	// TODO Auto-generated constructor stub
}
public String getMaSV() {
	return maSV;
}
public student(String maSV, String hoten, String email, String dtb, String diachi,
		int gioitinh) {
	super();
	this.maSV = maSV;
	this.hoten = hoten;
	this.email = email;
	this.dtb = dtb;
	this.diachi = diachi;
	this.gioitinh = gioitinh;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDtb() {
	return dtb;
}
public void setDtb(String dtb) {
	this.dtb = dtb;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public int getGioitinh() {
	return gioitinh;
}
public void setGioitinh(int gioitinh) {
	this.gioitinh = gioitinh;
}
}
//public void manga() {
//	loaddata();
//}
//
//public void loaddata() {
//	
//}
