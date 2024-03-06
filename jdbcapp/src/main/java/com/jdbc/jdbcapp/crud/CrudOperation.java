package com.jdbc.jdbcapp.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.jdbc.jdbcapp.connection.GlobalConnection;

public class CrudOperation {
	Scanner sc = new Scanner(System.in);

	public void InsertStudent() {
		Connection con = null;
		try {
			con = GlobalConnection.getGlobalConnection();
			String query = "INSERT INTO studentjdbc (name, email, password, gender, salary) VALUES (?, ?, ?, ?, ?)";
			System.out.println("Enter name");
			String str1 = sc.nextLine();
			System.out.println("Enter email");
			String str2 = sc.nextLine();
			System.out.println("Enter password");
			String str3 = sc.nextLine();
			System.out.println("Enter gender");
			String str4 = sc.nextLine();
			System.out.println("Enter salary");
			String str5 = sc.nextLine();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, str1);
			ps.setString(2, str2);
			ps.setString(3, str3);
			ps.setString(4, str4);
			ps.setString(5, str5);
			
			int res = ps.executeUpdate();
			if(res>0) {
				System.out.println("Record inserted");
			}else {
				System.out.println("Record insertion failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showAllStudents() {
		Connection con = null;
		try {
			con=GlobalConnection.getGlobalConnection();
			String query = "select id, name,email,password,gender,salary from studentjdbc";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 	int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String password = rs.getString("password");
	                String gender = rs.getString("gender");
	                String salary = rs.getString("salary");
	                
	                System.out.println("ID: " + id);
	                System.out.println("Name: " + name);
	                System.out.println("Email: " + email);
	                System.out.println("Password: " + password);
	                System.out.println("Gender: " + gender);
	                System.out.println("Salary: " + salary);
	                System.out.println("==========================");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateStudent() {
		Connection con = null;
		try {
			con=GlobalConnection.getGlobalConnection();
			System.out.println("Enter id to update");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println("Updated email");
			String str = sc.nextLine();
			 
			String query = "UPDATE studentjdbc SET email = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, str);
			ps.setInt(2, num);
			int update = ps.executeUpdate();
			if(update>0) {
				System.out.println("Record of "+num+" updated successfully");
			}else {
				System.out.println("Record of "+num+" updated failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteStudent() {
		Connection con = null;
		try {
			System.out.println("Enter id to delete record");
			int deleteid = sc.nextInt();
			sc.nextLine();
			con = GlobalConnection.getGlobalConnection();
			String query = "delete from studentjdbc where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, deleteid);
			int deletedata = ps.executeUpdate();
			if(deletedata>0) {
				System.out.println("Record of "+deleteid+" deleted successfully");
			}else {
				System.out.println("Record of "+deleteid+" deletetion failed");
			}
		}catch(Exception e) {
			
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
